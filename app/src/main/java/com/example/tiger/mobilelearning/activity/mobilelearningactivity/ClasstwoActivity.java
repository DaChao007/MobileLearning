package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.CourseDetailsActivity;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.ExpandableAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 专题课程页面跳转详情课程界面
 */
public class ClasstwoActivity extends BaseActivity implements ExpandableListView.OnChildClickListener{

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.classTwoExpandable)
    ExpandableListView classTwoExpandable;
    private ArrayList<String> bigList = new ArrayList<String>();
    private ArrayList<ArrayList<String>> smallList = new ArrayList<ArrayList<String>>();

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        classTwoExpandable.setOnChildClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("二级菜单");
            }
        });
        getData();
        ExpandableAdapter adapter = new ExpandableAdapter(bigList,smallList,this);
        classTwoExpandable.setAdapter(adapter);
    }

    private void getData() {
        bigList.add("A");
        bigList.add("B");
        bigList.add("C");
        bigList.add("D");
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list1.add((i+1)+"");
            list2.add((i+1)+"");
            list3.add((i+1)+"");
            list4.add((i+1)+"");
        }
        smallList.add(list1);
        smallList.add(list2);
        smallList.add(list3);
        smallList.add(list4);
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_classtwo;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick(R.id.backButImg)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        startJump(this, CourseDetailsActivity.class);
        return true;
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
