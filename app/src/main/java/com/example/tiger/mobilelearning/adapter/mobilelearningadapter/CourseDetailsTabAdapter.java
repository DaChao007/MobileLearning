package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/1.
 * 带视频的课程详情界面的TabLayout的Adapter
 */

public class CourseDetailsTabAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] str= new String[]{"简介","目录"};
    private ArrayList<Fragment> list;

    public CourseDetailsTabAdapter(FragmentManager fm, Context context, ArrayList<Fragment> list) {
        super(fm);
        this.context = context;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
