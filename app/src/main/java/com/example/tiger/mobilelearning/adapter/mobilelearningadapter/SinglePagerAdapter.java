package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/19.
 * 单选的adapter
 */

public class SinglePagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<Fragment> list;

    public SinglePagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
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
    public long getItemId(int position) {
        super.getItemId(position);
        if (list != null) {
            if (position < list.size()) {
                return list.get(position).hashCode();       //important
            }
        }
        return super.getItemId(position);
    }
}