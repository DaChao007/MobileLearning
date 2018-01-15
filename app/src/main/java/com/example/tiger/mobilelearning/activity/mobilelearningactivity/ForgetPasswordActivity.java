package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PVerificationCodeImpl;
import com.example.tiger.mobilelearning.utils.InterfaceStatusCodeUtils;
import com.example.tiger.mobilelearning.view.CountDownTimerUtils;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.VerificationCodeView;

import okhttp3.Headers;
import retrofit2.Response;

/**
 * 忘记密码，通过绑定的电话号码找回的界面
 */
public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener, VerificationCodeView {

    private static final String TAG = "ForgetPasswordActivity";

    //输入框手机号跟验证码 包括获取验证码的文本getCode
    private EditText nearPhone;
    private TextView getCode;
    private EditText codeEdit;
    //下一步按钮 点击跳转到修改密码的界面
    private Button forgetNextstep;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;

    private String nearPhoneTextt;
    private String codeEditText;
    private String cookie;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        getCode.setOnClickListener(this);
        forgetNextstep.setOnClickListener(this);
        backButImg.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("忘记密码");
            }
        });
    }

    @Override
    protected void initView() {
        nearPhone = (EditText) findViewById(R.id.nearPhone);
        getCode = (TextView) findViewById(R.id.getCode);
        codeEdit = (EditText) findViewById(R.id.codeEdit);
        forgetNextstep = (Button) findViewById(R.id.forgetNextstep);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getCode:
                String nearPhoneText = nearPhone.getText().toString().trim();
                if (!nearPhoneText.equals("")) {
                    PVerificationCodeImpl pVerificationCode = new PVerificationCodeImpl(this);
                    pVerificationCode.getSuccess(nearPhoneText);
                } else {
                    Toast.makeText(this, "请您输入正确格式的手机号！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.forgetNextstep:
                nearPhoneTextt = nearPhone.getText().toString().trim();
                codeEditText = codeEdit.getText().toString().trim();
                if (!nearPhoneTextt.equals("") && !codeEditText.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ForgetPasswordActivity.this);
                    builder.setMessage("请您检查手机号和4位验证码无误后点击确认！");
                    builder.setPositiveButton("确定",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (cookie != null) {
                                        startJump(ForgetPasswordActivity.this, SetPasswordActivity.class, nearPhoneTextt, codeEditText, cookie);
                                    }
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

                } else {
                    Toast.makeText(this, "请您输入手机号和获取的验证码！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void startJump(Context context, Class c, String nearPhoneText, String codeEditText, String cookie) {
        Intent intent = new Intent(context, c);
        intent.putExtra("nearPhoneText", nearPhoneText);
        intent.putExtra("codeEditText", codeEditText);
        intent.putExtra("cookie", cookie);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(Response<GetVerificationCodeBean> bean) {
        if ("0".equals(bean.body().getResultCode())) {
            Headers headers = bean.headers();
            Log.e(TAG, "headers:" + headers.toString());
            CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(getCode, 60000, 1000);
            mCountDownTimerUtils.start();
            Toast.makeText(this, "验证码已发送到您的手机，请注意查收！", Toast.LENGTH_SHORT).show();
            if (bean.headers().get("Set-Cookie") != null) {
                Log.e(TAG, "获取code成功，" + bean.headers().get("Set-Cookie"));
                int i = bean.headers().get("Set-Cookie").indexOf(";");
                if (i != -1) {
                    cookie = bean.headers().get("Set-Cookie").substring(0, i);
                    Log.e(TAG, cookie + "--" + i);
                }
            }
        } else {
            Log.e(TAG, InterfaceStatusCodeUtils.getResultMsg(Integer.parseInt(bean.body().getResultCode())) + "-->" + bean.body().getResultCode());
            Toast.makeText(this, "请您输入正确格式的手机号！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }
}
