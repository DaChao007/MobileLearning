package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface PersonalExamView {

    void OnSucceed(PersonalExamBean bean);

    void OnDefeated(String error);
}
