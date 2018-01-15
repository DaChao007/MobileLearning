package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.StaffBindingAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.BoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UnBind;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PBoundImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PUnBoundImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.BoundView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.UnBoundView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 人员绑定界面（过期）
 * 我的学员界面
 * <p>
 * 页面与18/01/12 改动   我的记录中我的学员跳转到此页面
 * 可以查看学员的培训计划情况 多个培训计划 一个人 多条item  分别是
 * <p>
 * 学员名称 培训计划  完成情况
 */
public class StaffBindingActivity extends BaseActivity implements BoundView, UnBoundView, StaffBindingAdapter.Callback {

    private static final String TAG = "StaffBindingActivity";

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    ListView staffBindingListView;
    @BindView(R.id.staffBindingAdd)
    TextView staffBindingAdd;

    private ArrayList<BoundBean.DataBean> list = new ArrayList<>();
    private StaffBindingAdapter adapter;
    private SharedPreferences user;
    private ProgressDialog waitingDialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件获取焦点事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(this);
//        waitingDialog.setTitle("解绑");
        waitingDialog.setMessage("解绑中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        staffBindingListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //以前点击人员跳转到个人学习进度页面
                        /*Intent intent = new Intent(StaffBindingActivity.this, PersonalLearningProgressActivity.class);
                        intent.putExtra("title", list.get(position).getEmployeeName());
                        intent.putExtra("id", list.get(position).getId());
                        startActivity(intent);*/
                    }
                });
    }

    private void setImg(ImageView itemBindingImg, int pos) {
        switch (pos) {
            case 0:
                itemBindingImg.setImageResource(R.drawable.img_close);
                break;
            case 1:
                itemBindingImg.setImageResource(R.drawable.img_open);
                break;
        }
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("我的学员");
            }
        });
        staffBindingListView = (ListView) findViewById(R.id.staffBindingListView);
        adapter = new StaffBindingAdapter(this, list, this);
        staffBindingListView.setAdapter(adapter);
        //以前获取已绑定人员的请求
      /*  user = getSharedPreferences("user", Context.MODE_PRIVATE);
        Map<String, String> map = new HashMap<String, String>();
        map.put("teacherId", user.getInt("uid", 0) + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        Log.e("TAG", getIntent().getIntExtra("id", 0) + "");
        sendNetWork(map, user.getString("token", null));*/
    }


    private void sendNetWork(Map<String, String> map, String token) {
        PBoundImpl program = new PBoundImpl(this, token);
        program.getSuccess(map);
    }

    private void sendUnBind(Map<String, String> map, String token) {
        PUnBoundImpl program = new PUnBoundImpl(this, token);
        program.getSuccess(map);
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_staff_binding;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.staffBindingAdd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.staffBindingAdd:
//                startJump(this, AddStaffActivity.class, getIntent().getIntExtra("id", 0));
                startJump(this, AddStaffActivity.class);
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
//        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(BoundBean bean) {
        if (bean.getResultCode().equals("0")) {
            if (bean.getData() != null) {
                list.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "无绑定人员", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "请求失败！", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void OnDefeated() {

    }

    @Override
    public void OnSucceed(UnBind body) {
        if ("0".equals(body.getResultCode())) {
            //解绑绑定的时候刷新。
//            onRest();
            waitingDialog.cancel();
            handler.sendEmptyMessage(200);
            Toast.makeText(this, body.getResultMsg(), Toast.LENGTH_SHORT).show();
        } else {
            waitingDialog.cancel();
        }
    }

    @Override
    public void OnDefeated(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    private HashMap<String, String> map;
    private int flag = 1;

    @Override
    public void click(int pos) {

        //执行解绑操作需要进行网络请求
       /* final int userId = list.get(pos).getId();
        map = new HashMap();
        map.put("userId", userId + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        map.put("teacherId", user.getInt("uid", 0) + "");
        Log.e("TAG", userId + "" + getIntent().getIntExtra("id", 0) + user.getInt("uid", 0) + flag);
        AlertDialog.Builder builder = new AlertDialog.Builder(StaffBindingActivity.this);
        builder.setMessage("您确定要执行解绑操作吗？");
        builder.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showWaitingDialog();
                        flag = 0;
                        map.put("operate", flag + "");
                        sendUnBind(map, user.getString("token", null));
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
        builder.show();*/
    }

    private void showCustomizeDialog() {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        final AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(this);
        final View dialogView = LayoutInflater.from(this)
                .inflate(R.layout.item_isjiebang, null);
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        SpannableString msp = new SpannableString("解除绑定");
        // 设置字体前景色 ，Color.MAGENTA为紫红
        msp.setSpan(new ForegroundColorSpan(Color.RED), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // 设置前景色为洋红色
        customizeDialog.setNegativeButton(msp,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        customizeDialog.show();
    }

    private void onRest() {
        list.clear();
        Map<String, String> map = new HashMap<String, String>();
        map.put("teacherId", user.getInt("uid", 0) + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        Log.e("TAG", getIntent().getIntExtra("id", 0) + "");
//        sendNetWork(map, user.getString("token", null));
    }

    @Override
    protected void onRestart() {
//        onRest();
        super.onRestart();
    }
}
