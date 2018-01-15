package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.ExamTabAdapter;
import com.example.tiger.mobilelearning.application.MainApplication;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.fragment.mobilelearningfragment.DidNotPassFragment;
import com.example.tiger.mobilelearning.fragment.mobilelearningfragment.NoExamsFragment;
import com.example.tiger.mobilelearning.fragment.mobilelearningfragment.PassedFragment;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;

import java.util.ArrayList;

/**
 * 我的记录里我的考试界面
 */
public class MyExamActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout examTab;
    private NoScrollViewPager examViewPager;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private ArrayList<Fragment> list;
    private ExamTabAdapter adapter;

    private void assignViews() {
        titleText = (TextView) findViewById(R.id.titleText);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        examTab = (TabLayout) findViewById(R.id.examTab);
        examViewPager = (NoScrollViewPager) findViewById(R.id.examViewPager);
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("我的考试");
            }
        });
        list = new ArrayList<Fragment>();
        NoExamsFragment noExamsFragment = new NoExamsFragment();
        DidNotPassFragment didNotPassFragment = new DidNotPassFragment();
        PassedFragment passedFragment = new PassedFragment();
        list.add(noExamsFragment);
        list.add(didNotPassFragment);
        list.add(passedFragment);
        adapter = new ExamTabAdapter(getSupportFragmentManager(), MainApplication.mBaseActivity, list);
        examViewPager.setAdapter(adapter);
        examTab.setupWithViewPager(examViewPager);
        examTab.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_exam;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
