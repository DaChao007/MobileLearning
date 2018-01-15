package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.FeedbackBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.ProgressUploadPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.FeedbackView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 我的记录我的学习进度
 */

public class PFeedbackImpl implements ProgressUploadPresenter, Observer<FeedbackBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private FeedbackView baseView;
    private String token;

    public PFeedbackImpl(FeedbackView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }

    @Override
    public void getSuccess(String trainScheduleStr) {
        interfaceimpl.requestFeedback(this,token,trainScheduleStr);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull FeedbackBean feedbackBean) {
        baseView.OnSucceed(feedbackBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
