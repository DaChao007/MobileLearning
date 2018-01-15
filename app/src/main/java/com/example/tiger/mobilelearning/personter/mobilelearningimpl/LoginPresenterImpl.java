package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.LoginBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.LoginPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.LoginView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 *
 */
public class LoginPresenterImpl implements LoginPresenter,Observer<LoginBean> {


    private RetrofitInterfaceImpl interfaceimpl;
    private LoginView baseView;

    public LoginPresenterImpl(LoginView baseView) {
        this.baseView = baseView;
        this.interfaceimpl = new RetrofitInterfaceImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginName",username);
        map.put("password",password);
        if (baseView!=null){
            baseView.showProgress();
        }
        interfaceimpl.requestPostLogin(this,map);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull LoginBean loginBean) {
        baseView.navigateToHome(loginBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (baseView!=null){
            baseView.failure(e.getMessage());
            baseView.hideProgress();
        }

    }

    @Override
    public void onComplete() {
    }
}
