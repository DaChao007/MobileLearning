package com.example.tiger.mobilelearning.fragment.mobilelearningfragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseFragment;

/**
 * Created by Tiger on 2017/12/2.
 * 我的考试中未考试的Fragment
 */

public class NoExamsFragment extends BaseFragment{

    private ImageView noExamsImg;
    private RecyclerView noExamsRecyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_noexams;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        noExamsImg = (ImageView) view.findViewById(R.id.noExamsImg);
        noExamsRecyclerView = (RecyclerView) view.findViewById(R.id.noExamsRecyclerView);
    }
}
