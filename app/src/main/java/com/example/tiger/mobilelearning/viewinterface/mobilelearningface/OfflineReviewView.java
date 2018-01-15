package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.OfflineReviewBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface OfflineReviewView {

    void OnSucceed(OfflineReviewBean bean);

    void OnDefeated(String error);
}
