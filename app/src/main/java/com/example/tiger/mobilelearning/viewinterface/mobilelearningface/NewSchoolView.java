package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;

/**
 * Created by Tiger on 2017/12/13.
 */

public interface NewSchoolView {

    void OnSucceed(NewNoviceShoolBean bean);

    void OnDefeated(String error);
}
