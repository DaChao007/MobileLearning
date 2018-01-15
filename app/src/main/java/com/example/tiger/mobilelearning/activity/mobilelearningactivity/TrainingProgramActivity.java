package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.TrainingProgramAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainingProgramBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PTrainingProgramImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.TrainingProgramView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 培训计划界面
 *
 *  PS:此页面跳转的所有页面已失效(此页面暂无日和改动)
 */
public class TrainingProgramActivity extends BaseActivity implements TrainingProgramView {

    private static final String TAG = "TrainingProgramActivity";
    private static final int HANDLERWHAT = 456;

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    ListView trainingProgramListView;
    private RelativeLayout noExamsImg;
    private ArrayList<TrainingProgramBean.DataBean> list = new ArrayList<TrainingProgramBean.DataBean>();
    private TrainingProgramAdapter adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (list.size() == 0) {
                noExamsImg.setVisibility(View.VISIBLE);
                trainingProgramListView.setVisibility(View.GONE);
            } else {
                noExamsImg.setVisibility(View.GONE);
                trainingProgramListView.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        trainingProgramListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startJump(TrainingProgramActivity.this, StaffBindingActivity.class,position);
            }
        });
        noExamsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNetWork();
            }
        });
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("培训计划");
            }
        });
        adapter = new TrainingProgramAdapter(this, list);
        trainingProgramListView.setAdapter(adapter);
        Log.e(TAG, "" + list.size());
        sendNetWork();
    }

    private void sendNetWork() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PTrainingProgramImpl program = new PTrainingProgramImpl(this,user.getString("token",null));
        program.getSuccess();
    }

    @Override
    protected void initView() {
        trainingProgramListView = (ListView) findViewById(R.id.trainingProgramListView);
        noExamsImg =(RelativeLayout) findViewById(R.id.noExamsImgIn);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_training_program;
    }

    @Override
    protected void destroyData() {

    }


    @OnClick({R.id.backButImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void startJump(Context context, Class c,int pos) {
        Intent intent = new Intent(context, c);
        intent.putExtra("id",list.get(pos).getId());
        intent.putExtra("name",list.get(pos).getTitle());
        startActivity(intent);
    }

    @Override
    public void OnSucceed(TrainingProgramBean bean) {
        list.clear();
        if (bean.getResultCode().equals("0")){
            list.addAll(bean.getData());
            adapter.notifyDataSetChanged();
            isVisi();
        }else {
            Toast.makeText(this, "请求失败！", Toast.LENGTH_SHORT).show();
        }

    }

    private void isVisi() {
        handler.sendEmptyMessage(HANDLERWHAT);
    }


    @Override
    public void OnDefeated() {
        isVisi();
    }



}
