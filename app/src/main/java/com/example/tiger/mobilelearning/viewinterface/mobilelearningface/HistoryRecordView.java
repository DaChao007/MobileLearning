package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;

/**
 * Created by Tiger on 2017/12/13.
 *   获取我的记录里个人历史记录
 */

public interface HistoryRecordView {

    void OnSucceed(HistoryRecordBean bean);

    void OnDefeated(String error);
}
