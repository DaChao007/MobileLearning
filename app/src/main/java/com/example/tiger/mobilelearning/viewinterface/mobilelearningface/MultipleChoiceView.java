package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.MultipleChoiceBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface MultipleChoiceView {

    void OnSucceed(MultipleChoiceBean bean);

    void OnDefeated(String error);
}
