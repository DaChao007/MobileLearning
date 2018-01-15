package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;

/**
 * 角色：店长 我的记录
 *
 * 需求更改  无用界面
 */
public class MyRecordBossActivity extends BaseActivity {


    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_record_boss;
    }

    @Override
    protected void destroyData() {

    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
