package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.MyHistoryRecordAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PHistoryRecordImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.HistoryRecordView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 学习的历史记录页面
 */
public class MyHistoryRecordActivity extends BaseActivity implements HistoryRecordView {

    private static final String TAG = "MyHistoryRecordActivity";

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.histirtListView)
    ListView histirtListView;

    private ArrayList<HistoryRecordBean.DataBean> list = new ArrayList<HistoryRecordBean.DataBean>();
    private MyHistoryRecordAdapter adapter;

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
                titleText.setText("历史记录");
            }
        });
        adapter = new MyHistoryRecordAdapter(this,list);
        histirtListView.setAdapter(adapter);
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PHistoryRecordImpl record = new PHistoryRecordImpl(this,user.getString("token", null));
        record.getSuccess(user.getInt("uid", 0));
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_history_record;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick(R.id.backButImg)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void OnSucceed(HistoryRecordBean bean) {
        if ("0".equals(bean.getResultCode())){
            list.addAll(bean.getData());
            adapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, bean.getResultMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG,"请求出错"+error);
    }
}
