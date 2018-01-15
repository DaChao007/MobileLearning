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
 * 考试未通过的界面
 */
public class TheExamDidNotPassActivity extends BaseActivity {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.ditNotFraction)
    TextView ditNotFraction;
    @BindView(R.id.ditNotTime)
    TextView ditNotTime;
    @BindView(R.id.ditNotNum)
    TextView ditNotNum;
    @BindView(R.id.ditNotAllNum)
    TextView ditNotAllNum;
    @BindView(R.id.ditNotWrongNum)
    TextView ditNotWrongNum;
    @BindView(R.id.ditNotReturnrBut)
    Button ditNotReturnrBut;
    @BindView(R.id.notRoundProgressBar)
    RoundProgressBar notRoundProgressBar;

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
        notRoundProgressBar.setMax(100);
        setData();
    }

    private void setData() {
        SubmitExamBean.DataBean data = getIntent().getParcelableExtra("data");
        ditNotFraction.setText(data.getScoreCount()+"");
        ditNotTime.setText(data.getInTime()+"");
        ditNotNum.setText(data.getTrueCount()+"");
        ditNotAllNum.setText(data.getCountNum()+"");
        ditNotWrongNum.setText(data.getFalseCount()+"");
        notRoundProgressBar.setProgress(data.getScoreCount());
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_the_exam_did_not_pass;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg,R.id.ditNotReturnrBut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.ditNotReturnrBut:
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
