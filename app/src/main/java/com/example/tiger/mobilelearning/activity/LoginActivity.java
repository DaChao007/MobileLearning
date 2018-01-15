package com.example.tiger.mobilelearning.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.BindPhoneActivity;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.ForgetPasswordActivity;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.LearnAndScheduleActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.LoginBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.LoginPresenterImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.LoginView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 引导界面跳转过来的Login界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    private static final String TAG = "LoginActivity";

    //用户和密码框
    private EditText loginPawEdit;
    private EditText loginUserEdit;
    //登录按钮和忘记密码文本
    private Button loginBut;
    private TextView forgetPaw;
    private LoginPresenterImpl presenter;
    private ProgressBar progressBar;
    private int loggedOn;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        forgetPaw.setOnClickListener(this);
        loginBut.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        loginPawEdit = (EditText) findViewById(R.id.loginPawEdit);
        loginUserEdit = (EditText) findViewById(R.id.loginUserEdit);
        loginBut = (Button) findViewById(R.id.loginBut);
        forgetPaw = (TextView) findViewById(R.id.forgetPaw);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        //清除登录记录
        clearData();
    }

    private void clearData() {
        if ("清空".equals(getIntent().getStringExtra("clear"))) {
            loginPawEdit.setText("");
            loginUserEdit.setText("");
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgetPaw:
                startJump(this, ForgetPasswordActivity.class);
                break;
            case R.id.loginBut:
                if (!loginUserEdit.getText().toString().trim().equals("") && !loginPawEdit.getText().toString().trim().equals("")) {
                    presenter = new LoginPresenterImpl(this);
                    String loginString = shaEncrypt(loginUserEdit.getText().toString().trim() + loginPawEdit.getText().toString().trim());
                    presenter.validateCredentials(loginUserEdit.getText().toString().trim(),loginString);
                    Log.e(TAG, "加密后—>" + loginString);
                } else if (loginUserEdit.getText().toString().trim().equals("")) {
                    loginUserEdit.setError("请填写用户名");
                } else if (loginPawEdit.getText().toString().trim().equals("")) {
                    loginPawEdit.setError("请填写密码");
                }
                break;
        }
    }

    /**
     * SHA加密
     *
     * @param strSrc 明文
     * @return 加密之后的密文
     */
    public static String shaEncrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");// 将此换成SHA-1、SHA-512、SHA-384等参数
            md.update(bt);
            //加密
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * byte数组转换为16进制字符串
     *
     * @param bts 数据源
     * @return 16进制字符串
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }


    @Override
    public void failure(String throwable) {
        Toast.makeText(this, "网络问题!若多次登录未成功，请联系客服!" + throwable, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void navigateToHome(LoginBean bean) {
        if (bean.getResultCode().equals("0")) {
            LoginBean.DataBean data = bean.getData();
            loggedOn = data.getLoggedOn();
            SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = user.edit();
            edit.putString("unname", data.getUname())
                    .putString("pname", data.getPname())
                    .putInt("uid", data.getUid())
                    .putString("gender", data.getGender())
                    .putInt("orgId", data.getOrgId())
                    .putString("orgName", data.getOrgName())
                    .putString("token", data.getToken());
            edit.commit();
            if (loggedOn == 0) {
                startJump(this, BindPhoneActivity.class);
            } else {
                startJump(this, LearnAndScheduleActivity.class);
            }
            Log.e(TAG, data.getToken());
            Toast.makeText(this, "登录成功!", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, bean.getResultMsg(), Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    // 定义一个变量，来标识是否退出

    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override

        public void handleMessage(Message msg) {

            super.handleMessage(msg);

            isExit = false;

        }

    };

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            exit();

            return false;

        }

        return super.onKeyDown(keyCode, event);

    }

    private void exit() {

        if (!isExit) {

            isExit = true;

            Toast.makeText(getApplicationContext(), "再按一次退出程序",

                    Toast.LENGTH_SHORT).show();

            // 利用handler延迟发送更改状态信息

            mHandler.sendEmptyMessageDelayed(0, 2000);

        } else {

            finish();

            System.exit(0);

        }

    }
}
