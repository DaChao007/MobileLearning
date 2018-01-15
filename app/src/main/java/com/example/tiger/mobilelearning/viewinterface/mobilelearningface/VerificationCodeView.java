package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;

import retrofit2.Response;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface VerificationCodeView {

    void OnSucceed(Response<GetVerificationCodeBean> bean);

    void OnDefeated(String error);
}
