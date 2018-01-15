package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.AddStaffAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NotBoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UnBind;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PBoundNoImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PUnBoundImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.NotBoundView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.UnBoundView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 新增人员界面
 */
public class AddStaffActivity extends BaseActivity implements View.OnClickListener, NotBoundView, UnBoundView, AddStaffAdapter.CallbackAdd {

    private static final String TAG = "AddStaffActivity";

    private TextView addSearch;
    private SearchView addSearchView;
    private ListView addListView;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;

    private ArrayList<NotBoundBean.DataBean> list = new ArrayList<>();
    private ArrayList<NotBoundBean.DataBean> listQuery = new ArrayList<>();
    private AddStaffAdapter adapter;
    private SharedPreferences user;
    private ProgressDialog waitingDialog;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 200:
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    private RadioGroup itemDialogXuanZePid;
    private RadioButton radioButton;


    private void showWaitingDialog() {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(this);
//        waitingDialog.setTitle("绑定");
        waitingDialog.setMessage("绑定中...");
        waitingDialog.setIndeterminate(true);
//        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    private void assignViews() {
        addSearch = (TextView) findViewById(R.id.addSearch);
        addSearchView = (SearchView) findViewById(R.id.addSearchView);
        addListView = (ListView) findViewById(R.id.addListView);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        // 设置搜索文本监听
        addSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // 当点击搜索按钮时触发该方法
            @Override
            public boolean onQueryTextSubmit(final String query) {
                if (!query.equals("")) {
                    addSearchList(query);
                }
                return false;
            }

            // 当搜索内容改变时触发该方法
            @Override
            public boolean onQueryTextChange(final String newText) {
                if (TextUtils.isEmpty(newText)) {
//                    onRest();
                }
                addSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!newText.equals("")){
                            addSearchList(newText);
                        }
                    }
                });
                return false;
            }
        });
    }

    private void addSearchList(String data) {
        listQuery.clear();
        for (int i = 0; i < list.size(); i++) {
            NotBoundBean.DataBean notBindUsersBean = list.get(i);
            Log.e(TAG,notBindUsersBean.getEmployeeName()+"");
            if (notBindUsersBean.getEmployeeName().contains(data)) {
                Log.e(TAG,notBindUsersBean.getEmployeeName()+"---");
                listQuery.add(notBindUsersBean);
            }
        }
        list.clear();
        list.addAll(listQuery);
        if (list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                View childAt = addListView.getChildAt(i);
                NotBoundBean.DataBean dataBean = list.get(i);
                TextView addstaffName = (TextView) childAt.findViewById(R.id.addstaffName);
                setTVColor(dataBean.getEmployeeName(),0,1,R.color.red,addstaffName);
            }
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, "无法查询您输入的人员信息！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *  对指定字符设置颜色
     * @param str
     *                         字符串
     * @param ch1
     *                         切换颜色开始的字符
     * @param ch2
     *                         切换颜色停止的字符
     * @param color
     *                         设置的颜色
     * @param tv
     *                         TextView控件
     */
    private void setTVColor(String str , int ch1 , int ch2 , int color , TextView tv){
//        int a = str.indexOf(ch1); //从字符ch1的下标开始
//        int b = str.indexOf(ch2)+1; //到字符ch2的下标+1结束,因为SpannableStringBuilder的setSpan方法中区间为[ a,b )左闭右开
        SpannableStringBuilder builder = new SpannableStringBuilder(str);
        builder.setSpan(new ForegroundColorSpan(color), ch1, ch2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(builder);
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

    private void sendUnBind(Map<String, String> map, String token) {
        PUnBoundImpl program = new PUnBoundImpl(this, token);
        program.getSuccess(map);
    }


    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("新增人员");
            }
        });
        adapter = new AddStaffAdapter(this, list, this);
        addListView.setAdapter(adapter);
    /*    user = getSharedPreferences("user", Context.MODE_PRIVATE);
        Map<String, String> map = new HashMap<String, String>();
        map.put("teacherId", user.getInt("uid", 0) + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        map.put("orgId", user.getInt("orgId", 0) + "");
        sendNetWork(map, user.getString("token", null));*/
    }

    private void sendNetWork(Map<String, String> map, String token) {
        PBoundNoImpl boundNo = new PBoundNoImpl(this, token);
        boundNo.getSuccess(map);
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_staff;
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
        }
    }

    private void showListDialog() {
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.item_dialogxuanzepid, null);
        itemDialogXuanZePid = (RadioGroup) view.findViewById(R.id.itemDialogXuanZePid);
        setRadioButton("新手七天散服", 0);
        setRadioButton("新手七天传菜", 1);
        setRadioButton("带训4部曲", 2);
        listDialog.setView(view);
        listDialog.show();
    }

    private void setRadioButton(String title, int id) {
        radioButton = new RadioButton(this);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(500, 120);
        layoutParams.setMargins(0, 10, 0, 10);
        radioButton.setLayoutParams(layoutParams);
        radioButton.setId(id);
        radioButton.setText(title);
        radioButton.setTextSize(16);
//        radioButton.setButtonDrawable(android.R.color.transparent);//隐藏单选圆形按钮
        radioButton.setGravity(Gravity.CENTER);
        radioButton.setPadding(100, 5, 100, 5);
        radioButton.setTextColor(getResources().getColorStateList(R.color.item_dialogxuanzepidtextcolor));//设置选中/未选中的文字颜色
        radioButton.setBackground(getResources().getDrawable(R.drawable.item_dialogxuanzepidbackground));//设置按钮选中/未选中的背景
        radioButton.setButtonDrawable(null);
        itemDialogXuanZePid.addView(radioButton);//将单选按钮添加到RadioGroup中
        if (id == 0) {
            radioButton.setChecked(true);
        }
    }

    @Override
    public void OnSucceed(NotBoundBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                list.addAll(bean.getData());
                adapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "无未绑定人员", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e(TAG, "请求失败！");
        }

    }

    @Override
    public void OnDefeated() {

    }

    @Override
    public void OnSucceed(UnBind body) {
        if ("0".equals(body.getResultCode())) {
//            onRest();
            waitingDialog.cancel();
            handler.sendEmptyMessage(200);
            Toast.makeText(this, body.getResultMsg(), Toast.LENGTH_SHORT).show();
        }else {
            waitingDialog.cancel();
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, error);
    }

    private int flag = 0;
    private HashMap<String, String> map;

    @Override
    public void click(int pos) {
        //执行绑定操作取消
       /* final int userId = list.get(pos).getId();
        map = new HashMap();
        map.put("userId", userId + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        map.put("teacherId", user.getInt("uid", 0) + "");
        Log.e(TAG, userId + "" + getIntent().getIntExtra("id", 0) + user.getInt("uid", 0));
            AlertDialog.Builder builder = new AlertDialog.Builder(AddStaffActivity.this);
            builder.setMessage("您确定要执行绑定操作吗？");
            builder.setPositiveButton("确定",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showWaitingDialog();
                            flag = 1;
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

    private void onRest() {
        list.clear();
        Map<String, String> map = new HashMap<String, String>();
        map.put("teacherId", user.getInt("uid", 0) + "");
        map.put("planId", getIntent().getIntExtra("id", 0) + "");
        map.put("orgId", user.getInt("orgId", 0) + "");
//        sendNetWork(map, user.getString("token", null));
    }
}
