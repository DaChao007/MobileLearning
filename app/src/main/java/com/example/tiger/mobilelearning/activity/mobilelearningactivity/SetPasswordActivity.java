package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.LoginActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ForgetPasswordNewBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PPasswordNewImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.PasswordNewView;

import java.util.HashMap;
import java.util.Map;

/**
 * 找回密码短信验证码验证成功跳转的设置新密码界面
 */
public class SetPasswordActivity extends BaseActivity implements View.OnClickListener, PasswordNewView {

    private static final String TAG = "SetPasswordActivity";

    //两次输入框的输入密码 和确定按钮
    private EditText nearPawEdit;
    private EditText nearPawOkEdit;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private Button setPawBut;
    private ProgressDialog waitingDialog;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    waitingDialog.cancel();
                    SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = user.edit();
                    edit.clear();
                    edit.commit();
                    removeALLActivity();
                    Intent intent = new Intent(SetPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
    private String nearPhoneText;
    private String codeEditText;
    private String cookie;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        setPawBut.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("新密码");
            }
        });
        nearPhoneText = getIntent().getStringExtra("nearPhoneText");
        codeEditText = getIntent().getStringExtra("codeEditText");
    }

    @Override
    protected void initView() {
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
        setPawBut = (Button) findViewById(R.id.setPawBut);
        nearPawEdit = (EditText) findViewById(R.id.nearPawEdit);
        nearPawOkEdit = (EditText) findViewById(R.id.nearPawOkEdit);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_password;
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
            case R.id.setPawBut:
                String nearPawEditText = nearPawEdit.getText().toString().trim();
                String nearPawOkEditText = nearPawOkEdit.getText().toString().trim();
                cookie = getIntent().getStringExtra("cookie");
                if (!TextUtils.isEmpty(nearPawEditText) && !TextUtils.isEmpty(nearPawOkEditText)) {
                    if (nearPawEditText.equals(nearPawOkEditText)) {
                        if (nearPhoneText != null && codeEditText != null && cookie != null) {
                            PPasswordNewImpl pp = new PPasswordNewImpl(this, this.cookie);
                            Map<String, Object> map = new HashMap<>();
                            map.put("phoneNum", getIntent().getStringExtra("nearPhoneText"));
                            map.put("phoneCode", getIntent().getStringExtra("codeEditText"));
                            map.put("password", nearPawEditText);
                            pp.getSuccess(map);
                            Log.e(TAG, getIntent().getStringExtra("nearPhoneText") + "--" + getIntent().getStringExtra("codeEditText") + "--" + nearPawEditText);
                        } else {
                            Toast.makeText(this, "手机号和验证码不匹配！", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "请输入两次一样的密码!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入密码！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setMessage("找回密码成功，正在跳到登录页面，请稍后...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    //关闭软键盘
    private void closeKeyboard() {
        View view = getWindow().peekDecorView();
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void OnSucceed(ForgetPasswordNewBean bean) {
        if (bean.getResultCode().equals("0")) {
            closeKeyboard();
            showWaitingDialog();
            handler.sendEmptyMessageDelayed(200, 3000);
        } else {
            Toast.makeText(this, bean.getResultMsg(), Toast.LENGTH_SHORT).show();
        }
        Log.e(TAG, bean.toString());
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }
}
