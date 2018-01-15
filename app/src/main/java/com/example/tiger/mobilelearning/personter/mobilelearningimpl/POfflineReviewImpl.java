package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.OfflineReviewBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.SubmitExamPresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.OfflineReviewView;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 个人学习记录页面中 线下考试的 通过未通过
 */

public class POfflineReviewImpl implements SubmitExamPresenter,Observer<OfflineReviewBean> {


    private RetrofitInterfaceImpl interfaceimpl;
    private OfflineReviewView baseView;
    private String token;

    public POfflineReviewImpl(OfflineReviewView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }

    @Override
    public void getSuccess(Map<String,Object> map) {
        interfaceimpl.requestOfflineReview(this,token,map);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull OfflineReviewBean offlineReviewBean) {
        baseView.OnSucceed(offlineReviewBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
