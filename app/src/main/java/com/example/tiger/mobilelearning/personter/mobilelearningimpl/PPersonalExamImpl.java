package com.example.tiger.mobilelearning.personter.mobilelearningimpl;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.model.mobilelearningimpl.RetrofitInterfaceImpl;
import com.example.tiger.mobilelearning.personter.MultipleChoicePresenter;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.PersonalExamView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Tiger on 2017/12/6.
 * 个人学习进度查询
 */

public class PPersonalExamImpl implements MultipleChoicePresenter,Observer<PersonalExamBean> {

    private RetrofitInterfaceImpl interfaceimpl;
    private PersonalExamView baseView;
    private String token;

    public PPersonalExamImpl(PersonalExamView view, String token) {
        interfaceimpl = new RetrofitInterfaceImpl();
        this.baseView = view;
        this.token = token;
    }



    @Override
    public void getSuccess(int paperId) {
        interfaceimpl.requestPersonalExag(this,token,paperId);
    }

    @Override
    public void onDestroy() {
        baseView = null;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull PersonalExamBean body) {
        baseView.OnSucceed(body);
    }


    @Override
    public void onError(@NonNull Throwable e) {
        baseView.OnDefeated(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
