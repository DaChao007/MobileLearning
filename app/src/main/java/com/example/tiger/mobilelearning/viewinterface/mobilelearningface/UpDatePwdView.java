package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.UpDatePwdBean;

/**
 * Created by Tiger on 2017/12/21.
 */

public interface UpDatePwdView {

    void OnSucceed(UpDatePwdBean bean);

    void OnDefeated(String error);
}
