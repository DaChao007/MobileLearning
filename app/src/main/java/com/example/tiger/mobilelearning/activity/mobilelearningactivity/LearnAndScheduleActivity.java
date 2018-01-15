package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.ChangePasswordActivity;
import com.example.tiger.mobilelearning.activity.LoginActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.utils.DensityUtil;
import com.zhy.android.percent.support.PercentRelativeLayout;

/**
 * 学习 和 排班 选择界面
 */
public class LearnAndScheduleActivity extends BaseActivity implements View.OnClickListener {

    //移动学习和排班管理界面选择
    private PercentRelativeLayout learnRelative;
    private PercentRelativeLayout scheduleRelative;
    //android实现点击两次返回键实现退出功能,对系统返回键进行监听,
    //定义一个变量记录按键时间,通过计算时间差来实现该功能
    //退出时的时间
    private long mExitTime;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private ImageView scheduleSet;
    private PopupWindow window;

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(LearnAndScheduleActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
//            ConfigurationStats.clearSharePre(this, "users");
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        learnRelative.setOnClickListener(this);
        scheduleRelative.setOnClickListener(this);
        scheduleSet.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("西贝营运管理中心");
            }
        });
    }

    @Override
    protected void initView() {
        learnRelative = (PercentRelativeLayout) findViewById(R.id.learnRelative);
        scheduleRelative = (PercentRelativeLayout) findViewById(R.id.scheduleRelative);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        backButImg.setVisibility(View.GONE);
        titleText = (TextView) findViewById(R.id.titleText);
        scheduleSet = (ImageView) findViewById(R.id.scheduleSet);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_learn_and_schedule;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.learnRelative:
               /* SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                if (user.getString("pname",null).equals("训导师")||user.getString("pname",null).equals("店长")){
                    startJump(this, HomeTrainerActivity.class);
                }else if (user.getString("pname",null).equals("初级员工")){
                    startJump(this, HomeActivity.class);
                }else {

                }*/
                //五个模块的界面
                startJump(this, HomeActivity.class);
//                    Toast.makeText(this, "无法辨别您的身份！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scheduleRelative:
                Toast.makeText(this, "模块正在努力建设中，敬请期待！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scheduleSet:
                //用来设置弹出框（修改密码和退出登录）
                setPopupwindow();
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        window.dismiss();
    }

    private void setPopupwindow() {
        // 构建一个popupwindow的布局
        View popupView = LayoutInflater.from(this).inflate(R.layout.item_popwindow_exit, null);
        popupView.findViewById(R.id.updataPwd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startJump(LearnAndScheduleActivity.this, ChangePasswordActivity.class);
            }
        });
        popupView.findViewById(R.id.dropOutLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LearnAndScheduleActivity.this);
                builder.setMessage("您确定要退出登录吗？");
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor edit = user.edit();
                                edit.clear();
                                edit.commit();
                                Intent intent = new Intent(LearnAndScheduleActivity.this, LoginActivity.class);
                                intent.putExtra("clear", "清空");
                                startActivity(intent);
                                removeALLActivity();
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
            }
        });
        // 创建PopupWindow对象，指定宽度和高度
        window = new PopupWindow(popupView, DensityUtil.dip2px(this,180),DensityUtil.dip2px(this,100));
        // 设置背景颜色
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
        // 设置可以获取焦点
        window.setFocusable(true);
        //  设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // 更新popupwindow的状态
        window.update();
        // 以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(scheduleSet, 0, 0);
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
