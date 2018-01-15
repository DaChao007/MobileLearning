package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.PersonalThreeAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PPersonalExamImpl;
import com.example.tiger.mobilelearning.view.CustomExpandableListView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.PersonalExamView;

import java.util.ArrayList;

/**
 * 个人学习进度界面
 */
public class PersonalLearningProgressActivity extends BaseActivity implements View.OnClickListener, PersonalExamView {

    private static final String TAG = "PersonalLearningProgressActivity";
    private static final String REQUESTSUCCESS = "0";

    private CustomExpandableListView learningProgressListView;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;

    private ArrayList<PersonalExamBean.DataBean> list = new ArrayList<>();
    private PersonalThreeAdapter personalThreeOneAdapter;
    public static int id;

    private void assignViews() {
        learningProgressListView = (CustomExpandableListView) findViewById(R.id.personalPersonalExpand);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
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
                String title = getIntent().getStringExtra("title");
                if (title!=null) {
                    if (getSharedPreferences("user", Context.MODE_PRIVATE).getInt("uid",0)==getIntent().getIntExtra("id", 0)){
                        titleText.setText("自己的学习进度");
                    }else {
                        titleText.setText(title + "的学习进度");
                    }
                }else {
                    titleText.setText("自己的学习进度");
                }
            }
        });
        if (getIntent().getIntExtra("id", 0)==0||getSharedPreferences("user", Context.MODE_PRIVATE).getInt("uid",0)==getIntent().getIntExtra("id", 0)){
            Log.e(TAG,"我的考试");
            personalThreeOneAdapter = new PersonalThreeAdapter(this, list,false);
        }else {
            Log.e(TAG,"训导员查看别人的");
            personalThreeOneAdapter = new PersonalThreeAdapter(this, list,true);
        }
        learningProgressListView.setAdapter(personalThreeOneAdapter);
        sendNetWork();
    }

    private void sendNetWork() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PPersonalExamImpl exam = new PPersonalExamImpl(this, user.getString("token", null));
        if (getIntent().getIntExtra("id", 0)==0){
            id = user.getInt("uid",0);
        }else {
            id = getIntent().getIntExtra("id", 0);
        }
        exam.getSuccess(id);
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_learning_progress;
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


    @Override
    public void OnSucceed(PersonalExamBean bean) {
        if (REQUESTSUCCESS.equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                list.addAll(bean.getData());
                personalThreeOneAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "您访问的页面无信息!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e(TAG, bean.getResultMsg());
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, error);
    }
}
