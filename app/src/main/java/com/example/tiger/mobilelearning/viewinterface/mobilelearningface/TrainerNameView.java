package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainerNameBean;

/**
 * Created by Tiger on 2017/12/21.
 */

public interface TrainerNameView {

    void OnSucceed(TrainerNameBean bean);

    void OnDefeated(String error);
}
