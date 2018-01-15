package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/1.
 * 新手学院的TabLayout的Adapter
 */

public class NewSchoolTabAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<String> str;
    private ArrayList<Fragment> list;

    public NewSchoolTabAdapter(FragmentManager fm, Context context, ArrayList<String> str, ArrayList<Fragment> list) {
        super(fm);
        this.context = context;
        this.str = str;
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
        return str.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
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
