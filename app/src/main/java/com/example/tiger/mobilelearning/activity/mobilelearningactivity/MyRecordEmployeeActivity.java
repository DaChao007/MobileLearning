package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MyStudyRecordBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainerNameBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PMyStudyRecordImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PTrainerNameImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.MyStudyRecordView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.TrainerNameView;
import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * 角色：员工 我的记录
 *
 * 更改需求 已变成所有角色
 */
public class MyRecordEmployeeActivity extends BaseActivity implements View.OnClickListener, TrainerNameView, MyStudyRecordView {

    private static final String TAG = "MyRecordEmployeeActivity";

    //姓名 今日在线时长 累计学习课程 考试已通过几门课程
    private TextView myName;
    private TextView learnTodayTime;
    private TextView learningCourseNum;
    private TextView haveFinished;
    //训导员
    private PercentRelativeLayout trainerRelative;
    //历史
    private PercentRelativeLayout historyrecordRelative;
    //我的考试
    private PercentRelativeLayout myexamRelative;
    //意见反馈
    private PercentRelativeLayout feedbackRelative;
    //修改密码
    private PercentRelativeLayout changePasswordRelative;
    //退出登录
    private PercentRelativeLayout cleanupthecacheRelative;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    //员工姓名
    private TextView trainer;
    //员工职位
    private TextView myPosition;
    //我的学员
    private PercentRelativeLayout myStudents;
    //全店排名
    private PercentRelativeLayout myRanking;

    private void assignViews() {
        backButImg = (ImageView) findViewById(R.id.backButImg);
        trainer = (TextView) findViewById(R.id.trainer);
        titleText = (TextView) findViewById(R.id.titleText);
        myName = (TextView) findViewById(R.id.myName);
        learnTodayTime = (TextView) findViewById(R.id.learnTodayTime);
        myPosition = (TextView) findViewById(R.id.myPosition);
        learningCourseNum = (TextView) findViewById(R.id.learningCourseNum);
        haveFinished = (TextView) findViewById(R.id.haveFinished);
        trainerRelative = (PercentRelativeLayout) findViewById(R.id.trainerRelative);
        historyrecordRelative = (PercentRelativeLayout) findViewById(R.id.historyrecordRelative);
        myexamRelative = (PercentRelativeLayout) findViewById(R.id.myexamRelative);
        feedbackRelative = (PercentRelativeLayout) findViewById(R.id.feedbackRelative);
        changePasswordRelative = (PercentRelativeLayout) findViewById(R.id.changePasswordRelative);
        cleanupthecacheRelative = (PercentRelativeLayout) findViewById(R.id.cleanupthecacheRelative);
        myStudents = (PercentRelativeLayout) findViewById(R.id.myStudents);
        myRanking = (PercentRelativeLayout) findViewById(R.id.myRanking);
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        feedbackRelative.setOnClickListener(this);
        changePasswordRelative.setOnClickListener(this);
        myexamRelative.setOnClickListener(this);
        historyrecordRelative.setOnClickListener(this);
        cleanupthecacheRelative.setOnClickListener(this);
        myStudents.setOnClickListener(this);
        myRanking.setOnClickListener(this);
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
        //获取训导员的名字
        setTrainerName();
        //获取我的学习进度
        setMyStudyRecord();
    }

    private void setMyStudyRecord() {
        PMyStudyRecordImpl record = new PMyStudyRecordImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null));
        record.getSuccess();
    }

    private void setTrainerName() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PTrainerNameImpl pTrainerName = new PTrainerNameImpl(this, user.getString("token", null));
        Log.e(TAG, user.getString("token", null));
        pTrainerName.getSuccess();
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_record_employee;
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
            case R.id.feedbackRelative:
                startJump(this, FeedbackActivity.class);
                break;
            case R.id.changePasswordRelative:
//                startJump(this, ChangePasswordActivity.class);
                break;
            case R.id.myexamRelative:
                startJump(this,PersonalLearningProgressActivity.class);
                break;
            case R.id.historyrecordRelative:
                startJump(this,MyHistoryRecordActivity.class);
                break;
            case R.id.cleanupthecacheRelative:
               /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("您确定要退出登录吗？");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edit = user.edit();
                                edit.clear();
                                edit.commit();
                                Intent intent = new Intent(MyRecordEmployeeActivity.this, LoginActivity.class);
                                intent.putExtra("clear", "清空");
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
                builder.show();*/
                break;
            case R.id.myStudents:
                //跳转到我的学员界面
                startJump(this,StaffBindingActivity.class);
                break;
            case R.id.myRanking:
                //跳转到全店排名界面
                startJump(this,WholeShopRankingActivity.class);
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(TrainerNameBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                Log.e(TAG, bean.getData().getTeacherName());
                trainer.setText(bean.getData().getTeacherName());
            } else {
                trainer.setText("无");
            }
        } else {
            Toast.makeText(this, "网络错误!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnSucceed(MyStudyRecordBean bean) {
        if ("0".equals(bean.getResultCode())) {
            MyStudyRecordBean.DataBean data = bean.getData();
            if (data!=null){
                learnTodayTime.setText(data.getOnlineDuring()+"分钟");
                learningCourseNum.setText(data.getCoursesCount()+"门课程");
                haveFinished.setText(data.getExamPassed()+"门课程");
            }
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }
}
