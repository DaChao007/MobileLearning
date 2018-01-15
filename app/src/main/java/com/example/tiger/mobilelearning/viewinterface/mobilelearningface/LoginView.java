package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.LoginBean;

/**
 * Created by Anthony on
 * Class Note:登陆View的接口，实现类也就是登陆的activity
 */
public interface LoginView {

    void failure(String throwable);

    void navigateToHome(LoginBean bean);

    void showProgress();

    void hideProgress();
}
