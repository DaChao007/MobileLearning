package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.MultipleChoicePresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.HistoryRecordView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 获取我的记录里个人历史记录
 */

public class PHistoryRecordImpl implements MultipleChoicePresenter, Observer<HistoryRecordBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private HistoryRecordView baseView;
    private String token;

    public PHistoryRecordImpl(HistoryRecordView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }


    @Override
    public void getSuccess(int paperId) {
        interfaceimpl.requestHistoryRecord(this,token, paperId);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull HistoryRecordBean historyRecordBean) {
        baseView.OnSucceed(historyRecordBean);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
