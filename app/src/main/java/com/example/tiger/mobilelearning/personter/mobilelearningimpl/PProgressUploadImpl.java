package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.ProgressUploadPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.ProgressUploadView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 同时实现俩接口 网络请求开始调用网络请求 实现观察者 重写4个方法
 * 并在构造中传入BaseView的实现类 内供成功失败 成功则返回当前所需要的Bean对象
 */

/**
 * 保存当前培训计划进度
 */

public class PProgressUploadImpl implements ProgressUploadPresenter,Observer<ProgressUploadBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private ProgressUploadView baseView;
    private String token;

    public PProgressUploadImpl(ProgressUploadView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }

    @Override
    public void getSuccess(String trainScheduleStr) {
        interfaceimpl.requestProgressUpload(this,token,trainScheduleStr);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull ProgressUploadBean progressUploadBean) {
        baseView.OnSucceed(progressUploadBean);
    }


    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
