package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 进阶学堂页面
 */
public class AdvancedSchoolActivity extends BaseActivity {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.advancedSchoolViewPager)
    NoScrollViewPager advancedSchoolViewPager;

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
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_advanced_school;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick(R.id.backButImg)
    public void onViewClicked() {
    }
}
