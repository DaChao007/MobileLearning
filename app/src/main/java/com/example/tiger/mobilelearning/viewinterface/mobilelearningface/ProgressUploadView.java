package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface ProgressUploadView {

    void OnSucceed(ProgressUploadBean body);

    void OnDefeated(String error);
}
