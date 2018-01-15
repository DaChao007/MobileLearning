package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.BindPhoneBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PBindPhoneImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PVerificationCodeImpl;
import com.example.tiger.mobilelearning.utils.InterfaceStatusCodeUtils;
import com.example.tiger.mobilelearning.view.CountDownTimerUtils;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.BindPhoneView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.VerificationCodeView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Response;


/**
 * 登录成功后需要绑定手机页面
 */
public class BindPhoneActivity extends BaseActivity implements View.OnClickListener, VerificationCodeView, BindPhoneView {

    private static final String TAG = "BindPhoneActivity";

    private EditText nearPhone;
    private EditText codeEdit;
    private TextView getCode;
    private EditText nearPawEdit;
    private EditText nearPawOkEdit;
    private Button forgetNextstep;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;

    private String cookie;

    private void assignViews() {
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
        nearPhone = (EditText) findViewById(R.id.nearPhone);
        codeEdit = (EditText) findViewById(R.id.codeEdit);
        getCode = (TextView) findViewById(R.id.getCode);
        nearPawEdit = (EditText) findViewById(R.id.nearPawEdit);
        nearPawOkEdit = (EditText) findViewById(R.id.nearPawOkEdit);
        forgetNextstep = (Button) findViewById(R.id.forgetNextstep);
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        forgetNextstep.setOnClickListener(this);
        getCode.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("绑定手机号码");
            }
        });
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bind_phone;
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
                String nearPhoneTextt = nearPhone.getText().toString().trim();
                String codeEditText = codeEdit.getText().toString().trim();
                String nearPawEditText = nearPawEdit.getText().toString().trim();
                String nearPawOkEditText = nearPawOkEdit.getText().toString().trim();
                if (!TextUtils.isEmpty(nearPhoneTextt) && !TextUtils.isEmpty(codeEditText) && !TextUtils.isEmpty(nearPawEditText) && !TextUtils.isEmpty(nearPawOkEditText)) {
                    if (nearPawEditText.equals(nearPawOkEditText) && cookie != null) {
                        PBindPhoneImpl bindPhone = new PBindPhoneImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null), cookie);
                        Log.e(TAG,cookie);
                        Map<String, Object> map = new HashMap<>();
                        map.put("phoneNum", nearPhoneTextt);
                        map.put("phoneCode", codeEditText);
                        map.put("password", nearPawEditText);
                        bindPhone.getSuccess(map);
                    } else {
                        show_Toast("两次密码输入不一致！");
                    }
                } else {
                    Toast.makeText(this, "请输入完整信息后再确定！", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(Response<GetVerificationCodeBean> bean) {
        if ("0".equals(bean.body().getResultCode())) {
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
    public void OnSucceed(BindPhoneBean body) {
        if ("0".equals(body.getResultCode())) {
            show_Toast("手机号绑定成功！");
            startJump(this, LearnAndScheduleActivity.class);
            finish();
        } else {
            show_Toast(body.getResultMsg());
        }
        Log.e(TAG, body.toString());
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }
}
