package com.example.tiger.mobilelearning.personter;

import java.util.Map;

/**
 * Created by Administrator on 2017/9/14.
 * 网络请求的生命周期 开始和结束
 */

public interface SubmitExamPresenter {

    void getSuccess(Map<String,Object> map);

    void onDestroy();
}