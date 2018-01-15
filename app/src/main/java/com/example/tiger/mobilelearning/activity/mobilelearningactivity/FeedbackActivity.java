package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.FeedbackBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PFeedbackImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.FeedbackView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 我的记录里的意见反馈界面
 */
public class FeedbackActivity extends BaseActivity implements View.OnClickListener, FeedbackView {

    private static final String TAG = "WordActivity";

    //功能建议 课程问题 其他意见三个反馈标签选项
    private Button suggestBut;
    private Button problemBut;
    private Button opinionBut;
    //反馈内容的输入框
    private EditText feedbackEdit;
    //反馈所携带的图片
    private ImageView uploadImg;
    //输入框留下联系方式
    private EditText contactEdit;
    //提交按钮
    private Button feedbackBut;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;


    private int type = 1;
    private ProgressDialog waitingDialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    Toast.makeText(FeedbackActivity.this, "您的反馈我们会即使处理，请您耐心等候！", Toast.LENGTH_SHORT).show();
                    waitingDialog.cancel();
                    removeActivity();
                    break;
            }
        }
    };

    private void assignViews() {
        suggestBut = (Button) findViewById(R.id.suggestBut);
        problemBut = (Button) findViewById(R.id.problemBut);
        opinionBut = (Button) findViewById(R.id.opinionBut);
        feedbackEdit = (EditText) findViewById(R.id.feedbackEdit);
        uploadImg = (ImageView) findViewById(R.id.uploadImg);
        contactEdit = (EditText) findViewById(R.id.contactEdit);
        feedbackBut = (Button) findViewById(R.id.feedbackBut);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }


    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        suggestBut.setOnClickListener(this);
        problemBut.setOnClickListener(this);
        opinionBut.setOnClickListener(this);
        feedbackBut.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("意见反馈");
            }
        });
        suggestBut.setBackgroundDrawable(getdrawable());
        problemBut.setBackgroundDrawable(getdrawableWrite());
        opinionBut.setBackgroundDrawable(getdrawableWrite());
    }

    private GradientDrawable getdrawable() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE); // 画框
        drawable.setStroke(1, Color.BLUE); // 边框粗细及颜色
        drawable.setColor(0x22FFFF00); // 边框内部颜色
        return drawable;
    }

    private GradientDrawable getdrawableWrite() {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE); // 画框
        drawable.setStroke(1, Color.GRAY); // 边框粗细及颜色
        drawable.setColor(0x766360); // 边框内部颜色
        return drawable;
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback;
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
            case R.id.suggestBut:
                type = 1;
                suggestBut.setBackgroundDrawable(getdrawable());
                problemBut.setBackgroundDrawable(getdrawableWrite());
                opinionBut.setBackgroundDrawable(getdrawableWrite());
                break;
            case R.id.problemBut:
                type = 2;
                problemBut.setBackgroundDrawable(getdrawable());
                suggestBut.setBackgroundDrawable(getdrawableWrite());
                opinionBut.setBackgroundDrawable(getdrawableWrite());
                break;
            case R.id.opinionBut:
                type = 3;
                opinionBut.setBackgroundDrawable(getdrawable());
                problemBut.setBackgroundDrawable(getdrawableWrite());
                suggestBut.setBackgroundDrawable(getdrawableWrite());
                break;
            case R.id.feedbackBut:
                String content = feedbackEdit.getText().toString().trim();
                String phoneOrEmail = contactEdit.getText().toString().trim();
                if (content.equals("")) {
                    Toast.makeText(this, "请提出您的宝贵建议!", Toast.LENGTH_SHORT).show();
                } else if (phoneOrEmail.equals("")) {
                    Toast.makeText(this, "留下您的联系方式吧!", Toast.LENGTH_SHORT).show();
                } else {
                    setNekWork(content, phoneOrEmail, type);
                }
                break;
        }
    }

    private void setNekWork(String content, String phoneOrEmail, int type) {
        try {
            PFeedbackImpl feedback = new PFeedbackImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null));
            JSONObject object = new JSONObject();
            object.put("content", content);
            object.put("type", type);
            object.put("phoneOrEmail", phoneOrEmail);
            feedback.getSuccess(object.toString().substring(0, object.toString().length()));
            Log.e(TAG, object.toString().substring(0, object.toString().length()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void OnSucceed(FeedbackBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                showWaitingDialog();
                handler.sendEmptyMessageDelayed(200, 2000);
            }
        }
        Log.e(TAG, bean.toString());
    }

    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(this);
//        waitingDialog.setTitle("解绑");
        waitingDialog.setMessage("提交中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }
}
