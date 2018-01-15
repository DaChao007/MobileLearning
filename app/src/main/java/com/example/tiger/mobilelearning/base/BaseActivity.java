package com.example.tiger.mobilelearning.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tiger.mobilelearning.application.MainApplication;

/**
 * Created by admin on 2017/8/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private MainApplication application;
    private BaseActivity oContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (application == null) {
            // 得到Application对象
            application = (MainApplication) getApplication();
        }
        oContext = this;// 把当前的上下文对象赋值给BaseActivity
        addActivity();// 调用添加方法
        setContentView(getLayoutId());
        MainApplication.mBaseActivity = this;
        initView();
        initData();
        initListener();
    }

    // 添加Activity方法
    public void addActivity() {
        application.addActivity(oContext);// 调用myApplication的添加Activity方法
    }

    //销毁当个Activity方法
    public void removeActivity() {
        application.removeActivity(oContext);// 调用myApplication的销毁单个Activity方法
    }
    //销毁所有Activity方法
    public void removeALLActivity() {
        application.removeALLActivity();// 调用myApplication的销毁所有Activity方法
        oContext.onDestroy();
    }

    /* 把Toast定义成一个方法  可以重复使用，使用时只需要传入需要提示的内容即可*/
    public void show_Toast(String text) {
        Toast.makeText(oContext, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 恢复数据（重复调用数据）
     */
    protected abstract void resumeData();

    /**
     * 加载点击事件
     */
    protected abstract void initListener();

    /**
     * 加载数据
     */
    protected abstract void initData();

    /**
     * 加载控件
     */

    protected abstract void initView();

    /**
     * 加载布局
     */
    public abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyData();
    }

    /**
     * 回收、清除数据
     */
    protected abstract void destroyData();


}
