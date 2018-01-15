package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.StartExamBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface StartExamView {

    void OnSucceed(StartExamBean bean);

    void OnDefeated(String error);
}
