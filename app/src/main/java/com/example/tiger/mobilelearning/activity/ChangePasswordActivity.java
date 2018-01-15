package com.example.tiger.mobilelearning.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UpDatePwdBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PUpDatePwdImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.UpDatePwdView;

import java.util.HashMap;
import java.util.Map;

/**
 * 设置新密码界面
 */
public class ChangePasswordActivity extends BaseActivity implements View.OnClickListener, UpDatePwdView {

    private static final String TAG = "ChangePasswordActivity";

    //三个输入框 分别是原密码，新密码，确定密码
    private EditText formerPawEdit;
    private EditText newPasswordEdit;
    private EditText newPasswordEditOk;
    //确定按钮
    private Button changePawBut;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private String formerPawText;
    private String newPasswordText;
    private String newPasswordOkText;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        changePawBut.setOnClickListener(this);
        backButImg.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("修改密码");
            }
        });
    }

    @Override
    protected void initView() {
        formerPawEdit = (EditText) findViewById(R.id.formerPawEdit);
        newPasswordEdit = (EditText) findViewById(R.id.newPasswordEdit);
        newPasswordEditOk = (EditText) findViewById(R.id.newPasswordEditOk);
        changePawBut = (Button) findViewById(R.id.changePawBut);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changePawBut:
                setNewPaw();
                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                PUpDatePwdImpl datePwd = new PUpDatePwdImpl(this,user.getString("token",null));
                if (!formerPawText.equals("")&&!newPasswordText.equals("")&&!newPasswordOkText.equals("")){
                    Map<String,Object> map =new HashMap();
                    map.put("oldPwd",formerPawText);
                    map.put("newPwd",newPasswordText);
                    map.put("confPwd",newPasswordOkText);
                    datePwd.getSuccess(map);
                }else {
                    Toast.makeText(this, "数据错误！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void setNewPaw() {
        formerPawText = formerPawEdit.getText().toString().trim();
        newPasswordText = newPasswordEdit.getText().toString().trim();
        newPasswordOkText = newPasswordEditOk.getText().toString().trim();

    }

    @Override
    public void OnSucceed(UpDatePwdBean bean) {
        if ("0".equals(bean.getResultCode())) {
            Toast.makeText(this, bean.getResultMsg(), Toast.LENGTH_SHORT).show();
            startJump(this,LoginActivity.class);
        } else {
            Toast.makeText(this, bean.getResultMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG,error);
    }
}
