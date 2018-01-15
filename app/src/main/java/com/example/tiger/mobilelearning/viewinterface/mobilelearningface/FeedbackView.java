package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.FeedbackBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface FeedbackView {

    void OnSucceed(FeedbackBean bean);

    void OnDefeated(String error);
}
