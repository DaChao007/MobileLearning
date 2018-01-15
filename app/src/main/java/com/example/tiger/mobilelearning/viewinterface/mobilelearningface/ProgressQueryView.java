package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressQueryBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface ProgressQueryView {

    void OnSucceed(ProgressQueryBean body);

    void OnDefeated(String error);
}
