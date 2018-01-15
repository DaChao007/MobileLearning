package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.NotBoundBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.BaseMapPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.NotBoundView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 同时实现俩接口 网络请求开始调用网络请求 实现观察者 重写4个方法
 * 并在构造中传入BaseView的实现类 内供成功失败 成功则返回当前所需要的Bean对象
 */

public class PBoundNoImpl implements BaseMapPresenter, Observer<NotBoundBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private NotBoundView baseView;
    private String token;

    public PBoundNoImpl(NotBoundView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }


    @Override
    public void getSuccess(Map<String, String> map) {
        interfaceimpl.requestPostBoundNo(this, token,map);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull NotBoundBean notBoundBean) {
        baseView.OnSucceed(notBoundBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated();
    }

    @Override
    public void onComplete() {

    }
}
