package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.MyStudyRecordBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.BasePresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.MyStudyRecordView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 我的记录我的学习进度
 */

public class PMyStudyRecordImpl implements BasePresenter, Observer<MyStudyRecordBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private MyStudyRecordView baseView;
    private String token;

    public PMyStudyRecordImpl(MyStudyRecordView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }

    @Override
    public void getSuccess() {
        interfaceimpl.requestStudyRecord(this, token);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull MyStudyRecordBean bean) {
        baseView.OnSucceed(bean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
