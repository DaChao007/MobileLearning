package com.example.tiger.mobilelearning.fragment.mobilelearningfragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseFragment;

/**
 * Created by Tiger on 2017/12/2.
 * 我的考试中已通过的Fragment
 */

public class PassedFragment extends BaseFragment {

    private ImageView passedImg;
    private RecyclerView passedRecyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_passed;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        passedImg = (ImageView) view.findViewById(R.id.passedImg);
        passedRecyclerView = (RecyclerView) view.findViewById(R.id.passedRecyclerView);
    }
}
