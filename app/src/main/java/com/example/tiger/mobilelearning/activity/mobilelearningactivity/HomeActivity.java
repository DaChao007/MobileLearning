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

/**
 * 首页  角色：普通角色
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    //进阶学堂
    private PercentRelativeLayout advancedSchool;
    //新手七天
    private PercentRelativeLayout noviceSevenDays;
    //专题课堂
    private PercentRelativeLayout specialClass;
    //消息通知
    private PercentRelativeLayout notification;
    //我的记录
    private PercentRelativeLayout myrecord;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        myrecord.setOnClickListener(this);
        specialClass.setOnClickListener(this);
        noviceSevenDays.setOnClickListener(this);
        notification.setOnClickListener(this);
        backButImg.setOnClickListener(this);
        advancedSchool.setOnClickListener(this);
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
        advancedSchool = (PercentRelativeLayout) findViewById(R.id.advancedSchool);
        noviceSevenDays = (PercentRelativeLayout) findViewById(R.id.noviceSevenDays);
        specialClass = (PercentRelativeLayout) findViewById(R.id.specialClass);
        notification = (PercentRelativeLayout) findViewById(R.id.notification);
        myrecord = (PercentRelativeLayout) findViewById(R.id.myrecord);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myrecord:
                startJump(this, MyRecordEmployeeActivity.class);
                break;
            case R.id.specialClass:
//                startJump(this, SpecialClassActivity.class);
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.noviceSevenDays:
                startJump(this, NoviceSchoolActivity.class);
                break;
            case R.id.notification:
//                startJump(this, NotificationActivity.class);
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.advancedSchool:
                startJump(this, AdvancedSchoolActivity.class);
//                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
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
