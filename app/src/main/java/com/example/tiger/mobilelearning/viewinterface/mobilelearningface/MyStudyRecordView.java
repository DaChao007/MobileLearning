package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.MyStudyRecordBean;

/**
 * Created by Tiger on 2017/12/13.
 * 我的记录我的学习进度
 */

public interface MyStudyRecordView {

    void OnSucceed(MyStudyRecordBean bean);

    void OnDefeated(String error);
}
