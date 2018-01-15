package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 消息通知界面
 */
public class NotificationActivity extends BaseActivity {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.notificationBanner)
    Banner notificationBanner;
    @BindView(R.id.notificationRecyc)
    RecyclerView notificationRecyc;
    private ArrayList<String> list;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("消息通知");
            }
        });
        //设置图片加载器
        notificationBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        list = new ArrayList<String>();
        //设置banner样式
        notificationBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        getImages();
        notificationBanner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        notificationBanner.start();
    }

    private void getImages() {
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512380762231&di=384821d5da10fb6a75c7dd1bb7d95581&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Feac4b74543a98226f509a4bb8182b9014b90eb66.jpg");
        list.add("https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=a144a274b73eb1355bc7b1bb961fa8cb/7a899e510fb30f2463e9629fc395d143ad4b033e.jpg");
        list.add("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=b911c9ecd6c451dae9f60aeb86fc52a5/dbb44aed2e738bd411d8e383aa8b87d6267ff983.jpg");
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_notification;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }
}
