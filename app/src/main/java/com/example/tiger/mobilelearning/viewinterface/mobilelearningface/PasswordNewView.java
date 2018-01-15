package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.ForgetPasswordNewBean;

/**
 * Created by Tiger on 2017/12/13.
 *   登录界面忘记密码中确定新密码
 */

public interface PasswordNewView {

    void OnSucceed(ForgetPasswordNewBean bean);

    void OnDefeated(String error);
}
