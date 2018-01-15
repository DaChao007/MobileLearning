package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的记录中全店排名页面
 */
public class WholeShopRankingActivity extends BaseActivity {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.rankingListView)
    ListView rankingListView;

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
                titleText.setText("全店排名");
            }
        });
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_whole_shop_ranking;
    }

    @Override
    protected void destroyData() {

    }


    @OnClick(R.id.backButImg)
    public void onViewClicked() {
        this.finish();
    }
}
