package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页  角色：训导员特殊首页
 *
 * PS:跳转的所有训练首页变成五个模块 此页面已无效 培训计划模块无效
 */
public class HomeTrainerActivity extends BaseActivity {


    @BindView(R.id.advancedSchool)
    PercentRelativeLayout advancedSchool;
    @BindView(R.id.noviceSevenDays)
    PercentRelativeLayout noviceSevenDays;
    @BindView(R.id.specialClass)
    PercentRelativeLayout specialClass;
    @BindView(R.id.notification)
    PercentRelativeLayout notification;
    @BindView(R.id.myrecord)
    PercentRelativeLayout myrecord;
    @BindView(R.id.trainingProgram)
    PercentRelativeLayout trainingProgram;
    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("西贝莜面村");
            }
        });
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_trainer;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.advancedSchool, R.id.noviceSevenDays, R.id.specialClass, R.id.notification, R.id.myrecord, R.id.trainingProgram,R.id.backButImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myrecord:
                startJump(this, MyRecordEmployeeActivity.class);
                break;
            case R.id.specialClass:
//                startJump(this, SpecialClassActivity.class);
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.noviceSevenDays:
                Toast.makeText(this, "您的身份是管理员，无法查看课程信息！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notification:
//                startJump(this, NotificationActivity.class);
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.advancedSchool:
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.trainingProgram:
                startJump(this, TrainingProgramActivity.class);
                break;
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
