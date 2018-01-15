package com.example.tiger.mobilelearning.fragment.mobilelearningfragment;

import android.view.View;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseFragment;

/**
 * Created by Tiger on 2017/12/1.
 * 课程详情里的简介
 */

public class IntroductionFragment extends BaseFragment {

    private TextView courseName;
    private TextView courseLabel;
    private TextView courseTime;
    private TextView courseObject;
    private TextView description;

    @Override
    public int getLayout() {
        return R.layout.fragment_introduction;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        courseName = (TextView) view.findViewById(R.id.courseName);
        courseLabel = (TextView) view.findViewById(R.id.courseLabel);
        courseTime = (TextView) view.findViewById(R.id.courseTime);
        courseObject = (TextView) view.findViewById(R.id.courseObject);
        description = (TextView) view.findViewById(R.id.description);
    }
}
