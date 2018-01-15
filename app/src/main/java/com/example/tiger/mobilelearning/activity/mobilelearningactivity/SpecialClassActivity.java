package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.SpecialClassAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.view.SpaceItemDecoration;

import java.util.ArrayList;

/**
 * 专题课程页面
 */
public class SpecialClassActivity extends BaseActivity implements View.OnClickListener{

    //一个列表
    private RecyclerView specialClassRecyclerView;
    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private RecyclerAdapterWithHF recyclerAdapterWithHF;


    private void assignViews() {
        specialClassRecyclerView = (RecyclerView) findViewById(R.id.specialClassRecyclerView);
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
    }


    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        recyclerAdapterWithHF.setOnItemClickListener(new RecyclerAdapterWithHF.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerAdapterWithHF adapter, RecyclerView.ViewHolder vh, int position) {
                startJump(SpecialClassActivity.this,ClasstwoActivity.class);
            }
        });
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("专题课程");
            }
        });
        ArrayList list = new ArrayList();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        SpecialClassAdapter adapter = new SpecialClassAdapter(this,list);
        recyclerAdapterWithHF = new RecyclerAdapterWithHF(adapter);
        specialClassRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        specialClassRecyclerView.addItemDecoration(new SpaceItemDecoration(1));
        specialClassRecyclerView.setAdapter(recyclerAdapterWithHF);
    }

    @Override
    protected void initView() {
        assignViews();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_special_class;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
