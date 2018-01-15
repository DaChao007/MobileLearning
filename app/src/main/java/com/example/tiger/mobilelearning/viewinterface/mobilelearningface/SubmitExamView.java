package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.SubmitExamBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface SubmitExamView {

    void OnSucceed(SubmitExamBean bean);

    void OnDefeated(String error);
}
