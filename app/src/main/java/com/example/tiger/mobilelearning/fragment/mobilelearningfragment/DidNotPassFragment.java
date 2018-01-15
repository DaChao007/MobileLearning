package com.example.tiger.mobilelearning.fragment.mobilelearningfragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseFragment;

/**
 * Created by Tiger on 2017/12/2.
 * 我的考试中未未通过的Fragment
 */

public class DidNotPassFragment extends BaseFragment{

    private ImageView didNotPassImg;
    private RecyclerView didNotPassRecyclerView;

    @Override
    public int getLayout() {
        return R.layout.fragment_didnotpass;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        didNotPassImg = (ImageView) view.findViewById(R.id.didNotPassImg);
        didNotPassRecyclerView = (RecyclerView) view.findViewById(R.id.didNotPassRecyclerView);
    }
}
