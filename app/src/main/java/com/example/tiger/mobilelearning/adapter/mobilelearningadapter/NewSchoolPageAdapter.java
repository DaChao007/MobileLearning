package com.example.tiger.mobilelearning.adapter.mobilelearningadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import com.example.tiger.mobilelearning.activity.mobilelearningactivity.NoviceSchoolActivity;

import java.util.ArrayList;

/**
 * Created by Tiger on 2017/12/20.
 */

public class NewSchoolPageAdapter extends FragmentPagerAdapter {
    private ArrayList<NoviceSchoolActivity.NewSchoolFragment> fragments;
    private FragmentManager fm;
    public NewSchoolPageAdapter(FragmentManager fm, ArrayList<NoviceSchoolActivity.NewSchoolFragment> fragments) {
        super(fm);
        this.fm = fm;
        this.fragments = fragments;
    }

    public void setFragments(ArrayList<NoviceSchoolActivity.NewSchoolFragment> fragments) {
        if(this.fragments != null){
            FragmentTransaction ft = fm.beginTransaction();
            for(Fragment f:this.fragments){
                ft.remove(f);
            }
            ft.commit();
            ft=null;
            fm.executePendingTransactions();
        }
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragments.get(arg0);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
