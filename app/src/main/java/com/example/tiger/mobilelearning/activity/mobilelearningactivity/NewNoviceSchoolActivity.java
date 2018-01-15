package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.NewSchoolTabAdapter;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.OneDayAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.base.BaseFragment;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PNewSchoolImpl;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.NewSchoolView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 新手学院模块
 */
public class NewNoviceSchoolActivity extends BaseActivity implements NewSchoolView{

    private static final String TAG = "NewNoviceSchoolActivity";

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.textClassTable)
    TextView textClassTable;
    @BindView(R.id.newTabLayout)
    TabLayout newTabLayout;
    @BindView(R.id.newViewPager)
    NoScrollViewPager newViewPager;

    private ArrayList<String> list_title = new ArrayList<String>();
    private ArrayList<Fragment> list_fragment = new ArrayList<Fragment>();
    private NewSchoolTabAdapter adapter;

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
                titleText.setText("新手学院");
            }
        });
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PNewSchoolImpl school = new PNewSchoolImpl(this,user.getString("token",null));
        school.getSuccess();
    }

    private void ititDataSon() {
        adapter = new NewSchoolTabAdapter(getSupportFragmentManager(),this,list_title,list_fragment);
        newViewPager.setAdapter(adapter);
        newTabLayout.setupWithViewPager(newViewPager);
        newTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_novice_school;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.textClassTable})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.textClassTable:
                break;
        }
    }

    @Override
    public void OnSucceed(NewNoviceShoolBean bean) {
       /* if ("0".equals(bean.getResultCode())){
            Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < bean.getData().size(); i++) {
                NewNoviceShoolBean.DataBean dataBean = bean.getData().get(i);
                list_title.add(dataBean.getTitle());
                list_fragment.add(new NewSchoolFragment());
            }
            ititDataSon();
        }else {
            Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
        }*/
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG,"请求失败"+error);
    }

    public static class NewSchoolFragment extends BaseFragment {


        private ListView oneListView;
        private ArrayList<String> list = new ArrayList<String>();
        private OneDayAdapter adapter;
        private String pageType;

        @Override
        public int getLayout() {
            return R.layout.fragment_one_day;
        }

        @Override
        protected void initListener() {

        }

        @Override
        protected void initData() {

        }

        @Override
        protected void initView(View view) {
            oneListView = (ListView) view.findViewById(R.id.oneListView);
            ArrayList<String> list =new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(pageType);
            }
//            OneDayAdapter oneDayAdapter = new OneDayAdapter(MainApplication.mBaseActivity,list);
//            oneListView.setAdapter(oneDayAdapter);
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle args = getArguments();
            if (args != null) {
                pageType = args.getString("pageType");
            }
        }

    }
}
