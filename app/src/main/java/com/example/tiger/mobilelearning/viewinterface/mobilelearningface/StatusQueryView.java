package com.example.tiger.mobilelearning.viewinterface.mobilelearningface;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.StatusQueryBean;

/**
 * Created by Tiger on 2017/12/25.
 *   考试状态查询
 */

public interface StatusQueryView {

    void OnSucceed(StatusQueryBean bean);

    void OnDefeated(String error);
}
