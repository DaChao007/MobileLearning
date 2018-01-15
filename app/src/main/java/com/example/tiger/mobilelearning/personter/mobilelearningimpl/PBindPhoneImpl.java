package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.BindPhoneBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.SubmitExamPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.BindPhoneView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 同时实现俩接口 网络请求开始调用网络请求 实现观察者 重写4个方法
 * 并在构造中传入BaseView的实现类 内供成功失败 成功则返回当前所需要的Bean对象
 * <p>
 * 获取手机验证码的personter
 */

public class PBindPhoneImpl implements SubmitExamPresenter, Observer<BindPhoneBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private BindPhoneView baseView;
    private String token;
    private String cookie;

    public PBindPhoneImpl(BindPhoneView view, String token, String cookie) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
        this.cookie = cookie;
    }

    @Override
    public void getSuccess(Map<String, Object> map) {
        interfaceimpl.requestBindPhone(this, token, cookie, map);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull BindPhoneBean bindPhoneBean) {
        baseView.OnSucceed(bindPhoneBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
