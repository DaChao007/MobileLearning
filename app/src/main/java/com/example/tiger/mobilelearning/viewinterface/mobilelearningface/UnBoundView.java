package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.UnBind;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface UnBoundView {

    void OnSucceed(UnBind body);

    void OnDefeated(String error);
}
