package com.example.tiger.mobilelearning.personter;

/**
 * Created by Administrator on 2017/9/14.
 * 网络请求的生命周期 开始和结束
 */

public interface ProgressUploadPresenter {

    void getSuccess(String trainScheduleStr);

    void onDestroy();
}
