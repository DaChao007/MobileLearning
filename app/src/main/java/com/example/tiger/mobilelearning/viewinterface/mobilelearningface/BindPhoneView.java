package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.BindPhoneBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface BindPhoneView {

    void OnSucceed(BindPhoneBean body);

    void OnDefeated(String error);
}
