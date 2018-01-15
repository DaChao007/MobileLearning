package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StartExamBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PStartExamImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.StartExamView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 考试的第一个界面，点击开始答题按钮，进入答题界面
 */
public class StartExamActivity extends BaseActivity implements StartExamView {

    private static final String TAG = "StartExamActivity";

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.examName)
    TextView examName;
    @BindView(R.id.examNum)
    TextView examNum;
    @BindView(R.id.examTime)
    TextView examTime;
    @BindView(R.id.examFullScore)
    TextView examFullScore;
    @BindView(R.id.examPassPoints)
    TextView examPassPoints;
    @BindView(R.id.startExamBut)
    Button startExamBut;

    private static int paperId;
    private static int num;

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
                titleText.setText("考试");
            }
        });
        paperId = getIntent().getIntExtra("paperId", 0);
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
//        PMultipleChoiceImpl choice= new PMultipleChoiceImpl(this,user.getString("token",null));
//        choice.getSuccess();
        PStartExamImpl exam = new PStartExamImpl(this, user.getString("token", null));
       /* if (paperId!=0){
            exam.getSuccess(paperId);
        }else {
            Toast.makeText(this, "无网络！", Toast.LENGTH_SHORT).show();
        }*/
        exam.getSuccess(paperId);
        Log.e(TAG, paperId + "");
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_start_exam;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.startExamBut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.startExamBut:
                if (num != 0 && paperId != 0) {
                    startJump(this, SingleChoiceActivity.class, num, paperId);
                }
                break;
        }
    }


    private void startJump(Context context, Class c, int num, int paperId) {
        Intent intent = new Intent(context, c);
        intent.putExtra("num", num);
        intent.putExtra("paperId", paperId);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(StartExamBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                num = bean.getData().getGetcountPaperId();
                if (!examName.equals("")) {
                    examName.setText(bean.getData().getPaper().getTitle());
                }
                examNum.setText(bean.getData().getGetcountPaperId() + " 道");
                examTime.setText(bean.getData().getPaper().getTimLimit() + " 分钟");
                examFullScore.setText(bean.getData().getPaper().getScore() + " 分");
                examPassPoints.setText(bean.getData().getPaper().getPassScore() + " 分");
            } else {
                Toast.makeText(this, "您访问的页面无信息!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e("TAG", bean.getResultCode());
        }
    }


    @Override
    public void OnDefeated(String error) {
        Log.e("TAG", "请求失败" + error);
    }
}
