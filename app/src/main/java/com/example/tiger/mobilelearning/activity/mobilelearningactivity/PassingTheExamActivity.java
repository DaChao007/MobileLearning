package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.SubmitExamBean;
import com.example.tiger.mobilelearning.view.RoundProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 考试通过的界面
 */
public class PassingTheExamActivity extends BaseActivity {

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.passingFraction)
    TextView passingFraction;
    @BindView(R.id.passingTime)
    TextView passingTime;
    @BindView(R.id.passingNum)
    TextView passingNum;
    @BindView(R.id.passingAllNum)
    TextView passingAllNum;
    @BindView(R.id.wrongNum)
    TextView wrongNum;
    @BindView(R.id.passingUnderBut)
    Button passingUnderBut;
    @BindView(R.id.passRoundProgressBar)
    RoundProgressBar passRoundProgressBar;

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
                titleText.setText("考试成绩");
            }
        });
        passRoundProgressBar.setMax(100);
        setData();
    }

    private void setData() {
        SubmitExamBean.DataBean data = getIntent().getParcelableExtra("data");
        passingFraction.setText(data.getScoreCount()+"");
        passingTime.setText(data.getInTime()+"");
        passingNum.setText(data.getTrueCount()+"");
        passingAllNum.setText(data.getCountNum()+"");
        wrongNum.setText(data.getFalseCount()+"");
        passRoundProgressBar.setProgress(data.getScoreCount());
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_passing_the_exam;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg,R.id.passingUnderBut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.passingUnderBut:
                removeActivity();
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
        removeActivity();
    }
}
