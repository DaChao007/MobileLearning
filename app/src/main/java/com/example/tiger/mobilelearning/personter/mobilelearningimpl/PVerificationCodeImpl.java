package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.ProgressUploadPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.VerificationCodeView;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * Created by Tiger on 2017/12/6.
 * 同时实现俩接口 网络请求开始调用网络请求 实现观察者 重写4个方法
 * 并在构造中传入BaseView的实现类 内供成功失败 成功则返回当前所需要的Bean对象
 *
 * 获取手机验证码的personter
 */

public class PVerificationCodeImpl implements ProgressUploadPresenter, Observer<Response<GetVerificationCodeBean>> {

    private RetrofitInterfaceImpl interfaceimpl;
    private VerificationCodeView baseView;

    public PVerificationCodeImpl(VerificationCodeView view) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
    }

    @Override
    public void getSuccess(String trainScheduleStr) {
        interfaceimpl.requestVerificationCode(this,trainScheduleStr);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull Response<GetVerificationCodeBean> response) {
        baseView.OnSucceed(response);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
