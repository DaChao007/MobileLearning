package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.ImageView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.LoginActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;

/**
 * 引导页界面
 */
public class GuideActivity extends BaseActivity {

    //引导页的一张图片
    private ImageView mainImage;
    private ObjectAnimator animator;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                if (user.getString("token", null) != null) {
                    Intent intent = new Intent(GuideActivity.this, LearnAndScheduleActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void initData() {
        animator = ObjectAnimator.ofFloat(mainImage, "alpha", 1f, 0.8f);
        animator.setDuration(1500);
        animator.start();
    }

    @Override
    protected void initView() {
        mainImage = (ImageView) findViewById(R.id.mainImage);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void destroyData() {

    }

}
