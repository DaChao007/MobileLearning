package com.example.tiger.mobilelearning.application;

import android.app.Activity;
import android.app.Application;

import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiger on 2017/11/24.
 * 全局唯一的Application
 */

public class MainApplication extends Application {

    public static BaseActivity mBaseActivity;
    public static BaseFragment mBaseFragment;

    private List<Activity> oList;//用于存放所有启动的Activity的集合

    public void onCreate() {
        super.onCreate();
        oList = new ArrayList<Activity>();
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
    // 判断当前集合中不存在该Activity
        if (!oList.contains(activity)) {
            oList.add(activity);//把当前Activity添加到集合中
        }
    }

    /**
     * 销毁单个Activity
     */
    public void removeActivity(Activity activity) {
        //判断当前集合中存在该Activity
        if (oList.contains(activity)) {
            oList.remove(activity);//从集合中移除
            activity.finish();//销毁当前Activity
        }
    }

    /**
     * 销毁所有的Activity
     */
    public void removeALLActivity() {
        //通过循环，把集合中的所有Activity销毁
        for (Activity activity : oList) {
            activity.finish();
        }
    }

}
