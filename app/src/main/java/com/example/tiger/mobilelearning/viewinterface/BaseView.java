package com.example.tiger.mobilelearning.viewinterface;

import com.example.tiger.mobilelearning.entity.VideoBean;

/**
 * Created by LiYRong on 2017/8/26.
 * 网络情求 课程详情视频返回接口
 */

public interface BaseView {

    void OnSucceed(VideoBean bean);

    void OnDefeated();
}
