package com.example.tiger.mobilelearning.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.tiger.mobilelearning.application.MainApplication;

/**
 * 王龙
 * Fragment的管理类
 *
 */

public class FragmentBuilder {

    private static FragmentBuilder fragmentBuilder;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private int id;
    private String name;
    private BaseFragment nowFragment;

    public FragmentBuilder() {
        init();
    }

    //初始化Fragmentmanager 和transaction
    public FragmentBuilder init() {
        fragmentManager = MainApplication.mBaseActivity.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        return this;
    }

    //设置一个Fragment的容器
    public FragmentBuilder initContainId(int id){
        this.id=id;
        return this;
    }


    //参数fragment相当于你需要传递一个Fragment1.class
    public FragmentBuilder add(Class<? extends  BaseFragment> fragment){
        name = fragment.getSimpleName();
        nowFragment = (BaseFragment) fragmentManager.findFragmentByTag(name);
        if (nowFragment ==null){
            try {
                //获取Fragment的对象
                nowFragment = fragment.newInstance();
                //把Fragment添加到事物里面去
                fragmentTransaction.add(id, nowFragment,name);

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //隐藏fragment
        if (MainApplication.mBaseFragment != null) {
            fragmentTransaction.hide(MainApplication.mBaseFragment);
        }
        //显示当前的Fragment
        if ( nowFragment != null) {
            fragmentTransaction.show(nowFragment);
        }
        return this;
    }

    public static FragmentBuilder getInstance() {
        if (fragmentBuilder == null) {
            synchronized (FragmentBuilder.class) {
                fragmentBuilder = new FragmentBuilder();
            }
        }
        return fragmentBuilder;
    }

    //添加到回退栈并提交transaction
    public void build(){
        fragmentTransaction.addToBackStack(name);
        MainApplication.mBaseFragment = nowFragment;
        fragmentTransaction.commit();
    }
}
