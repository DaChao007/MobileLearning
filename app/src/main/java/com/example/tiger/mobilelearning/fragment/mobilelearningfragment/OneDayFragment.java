package com.example.tiger.mobilelearning.fragment.mobilelearningfragment;

import android.view.View;
import android.widget.ListView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.OneDayAdapter;
import com.example.tiger.mobilelearning.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/11/30.
 * 新手第一天fragment
 */

public class OneDayFragment extends BaseFragment {


    private ListView oneListView;
    private ArrayList<String> list = new ArrayList<String>();
    private OneDayAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.fragment_one_day;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        oneListView = (ListView) view.findViewById(R.id.oneListView);
        ArrayList<String> list =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("第"+(i+1)+"节课");
        }
//        OneDayAdapter oneDayAdapter = new OneDayAdapter(MainApplication.mBaseActivity,list);
//        oneListView.setAdapter(oneDayAdapter);
    }


}
