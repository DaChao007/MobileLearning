package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.ChangePasswordActivity;
import com.example.tiger.mobilelearning.activity.LoginActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 角色：训导员 我的记录
 *
 * 需求更改  无用界面
 */
public class MyRecordActivity extends BaseActivity {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.myName)
    TextView myName;
    @BindView(R.id.learnTodayTime)
    TextView learnTodayTime;
    @BindView(R.id.learningCourseNum)
    TextView learningCourseNum;
    @BindView(R.id.haveFinished)
    TextView haveFinished;
    @BindView(R.id.imgHead)
    ImageView imgHead;
    @BindView(R.id.trainerRelative)
    PercentRelativeLayout trainerRelative;
    @BindView(R.id.courseRelative)
    PercentRelativeLayout courseRelative;
    @BindView(R.id.feedbackRelative)
    PercentRelativeLayout feedbackRelative;
    @BindView(R.id.changePasswordRelative)
    PercentRelativeLayout changePasswordRelative;
    @BindView(R.id.cleanupthecacheRelative)
    PercentRelativeLayout cleanupthecacheRelative;
    @BindView(R.id.myPosition)
    Button myPosition;

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
                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                titleText.setText("我的记录");
                myName.setText(user.getString("unname", null));
                myPosition.setText(user.getString("pname", null));
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
        return R.layout.activity_my_record;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.imgHead, R.id.trainerRelative, R.id.courseRelative, R.id.feedbackRelative, R.id.changePasswordRelative, R.id.cleanupthecacheRelative})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.imgHead:
                break;
            case R.id.trainerRelative:
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.courseRelative:
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedbackRelative:
                startJump(this,FeedbackActivity.class);
                break;
            case R.id.changePasswordRelative:
                startJump(this,ChangePasswordActivity.class);
                break;
            case R.id.cleanupthecacheRelative:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("您确定要退出登录吗？");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences.Editor user = getSharedPreferences("user", Context.MODE_PRIVATE).edit();
                                user.clear();
                                user.commit();
                                Intent intent = new Intent(MyRecordActivity.this, LoginActivity.class);
                                intent.putExtra("clear","清空");
                                startActivity(intent);
                                removeALLActivity();
                            }
                        });
                builder.setNegativeButton("关闭",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                            }
                        });
                // 显示
                builder.show();
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

}
