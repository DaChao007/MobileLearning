package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.NewSchoolPageAdapter;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.OneDayAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PNewSchoolImpl;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.NewSchoolView;

import java.util.ArrayList;


/**
 * 新手学院 新手七天页面
 */
public class NoviceSchoolActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, NewSchoolView {

    private static final String TAG = "NoviceSchoolActivity";

    //include标签名字跟后退按钮
    private ImageView backButImg;
    private TextView titleText;
    private RadioGroup noviceRadioGroup;
    private TextView textClassTable;
    private NoScrollViewPager schoolNoScrollViewPager;
    private RadioButton radioButton;

    private ArrayList<NewSchoolFragment> list = new ArrayList<NewSchoolFragment>();
    private ArrayList<Integer> list_id = new ArrayList<Integer>();
    private ArrayList<NewNoviceShoolBean.DataBean.CoursesBean> list_tablestr = new ArrayList<>();
    public static NewNoviceShoolBean.DataBean.CoursesBean coursesBean;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        backButImg.setOnClickListener(this);
        noviceRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                titleText.setText("新手学院");
            }
        });
        setNewWork();
    }

    private void setNewWork() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PNewSchoolImpl school = new PNewSchoolImpl(this, user.getString("token", null));
        Log.e(TAG, user.getString("token", null));
        school.getSuccess();
    }

    @Override
    protected void initView() {
        backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);
        textClassTable = (TextView) findViewById(R.id.textClassTable);
        noviceRadioGroup = (RadioGroup) findViewById(R.id.noviceRadioGroup);
        schoolNoScrollViewPager = (NoScrollViewPager) findViewById(R.id.schoolNoScrollViewPager);
        schoolNoScrollViewPager.setNoScroll(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_novice_school;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        for (int i = 0; i < list_id.size(); i++) {
            int a = list_id.get(i);
            if (checkedId == a) {
                coursesBean = list_tablestr.get(checkedId);
                schoolNoScrollViewPager.setCurrentItem(a);
            }
        }
    }

    private void startJump(Context context, Class c) {
        Intent intent = new Intent(context, c);
        startActivity(intent);
    }

    @Override
    public void OnSucceed(NewNoviceShoolBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData() != null) {
                Log.e(TAG, "请求成功");
                for (int i = 0; i < bean.getData().getCourses().size(); i++) {
                    NewNoviceShoolBean.DataBean.CoursesBean coursesBean = bean.getData().getCourses().get(i);
                    setRadioButton(coursesBean.getTitle(), i);
                    list_id.add(i);
                    list_tablestr.add(coursesBean);
                    ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean> chapters = (ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean>) coursesBean.getChapters();
                    NewSchoolFragment fragment = new NewSchoolFragment().newInstance(coursesBean, chapters, bean.getData().getPlanId(), coursesBean.getId());
                    list.add(i, fragment);
                }
                if (list.size() > 0) {
                    NewSchoolPageAdapter adapter = new NewSchoolPageAdapter(getSupportFragmentManager(), list);
                    schoolNoScrollViewPager.setAdapter(adapter);
                    schoolNoScrollViewPager.setOffscreenPageLimit(bean.getData().getCourses().size());
                    schoolNoScrollViewPager.setCurrentItem(0);
                    coursesBean = list_tablestr.get(0);
                }
            } else {
                Toast.makeText(this, "没有训导员绑定你嘛？", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e(TAG, "请求失败");
        }
    }

    private void setRadioButton(String title, int id) {
        radioButton = new RadioButton(this);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 0);
        radioButton.setLayoutParams(layoutParams);
        radioButton.setId(id);
        radioButton.setText(title);
        radioButton.setTextSize(16);
//        radioButton.setButtonDrawable(android.R.color.transparent);//隐藏单选圆形按钮
        radioButton.setGravity(Gravity.CENTER);
        radioButton.setPadding(0, 50, 0, 50);
        radioButton.setTextColor(getResources().getColorStateList(R.color.black));//设置选中/未选中的文字颜色
        radioButton.setBackground(getResources().getDrawable(R.drawable.novicesevenbackground));//设置按钮选中/未选中的背景
        radioButton.setButtonDrawable(R.drawable.radiobut_newseven);
        noviceRadioGroup.addView(radioButton);//将单选按钮添加到RadioGroup中
        if (id == 0) {
            radioButton.setChecked(true);
        }
    }


    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求失败" + error);
    }

    public static class NewSchoolFragment extends Fragment {

        private ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean> aroptions;
        private OneDayAdapter adapter;
        private ListView oneListView;
        public static Button bigExam;
        private int pId;
        private int kId;
        private ImageView noExamsImgIn;
        private ImageView textClassTableImg;
        private NewNoviceShoolBean.DataBean.CoursesBean courses;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle args = getArguments();
            if (args != null) {
                courses = args.getParcelable("courses");
                aroptions = args.getParcelableArrayList("options");
                pId = args.getInt("pId");
                kId = args.getInt("kId");
            }
        }

        public static NewSchoolFragment newInstance(NewNoviceShoolBean.DataBean.CoursesBean courses, ArrayList<NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean> aroptions, int planId, int kid) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("courses", courses);
            bundle.putParcelableArrayList("options", aroptions);
            bundle.putInt("pId", planId);
            bundle.putInt("kId", kid);
            NewSchoolFragment testFm = new NewSchoolFragment();
            testFm.setArguments(bundle);
            return testFm;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_one_day, null);
            initView(view);
            initData();
            initister();
            return view;
        }

        private void initister() {
            textClassTableImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (coursesBean != null) {
                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("data", coursesBean);
                        startActivity(intent);
                    }
                }
            });
            bigExam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (courses != null) {
                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("paperId", courses.getCoursePaperId());
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "当前课程没有考试!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        private void initView(View view) {
            oneListView = (ListView) view.findViewById(R.id.oneListView);
            bigExam = (Button) view.findViewById(R.id.bigExam);
            noExamsImgIn = (ImageView) view.findViewById(R.id.noExamsImgIn);
            textClassTableImg = (ImageView) view.findViewById(R.id.textClassTableImg);
        }

        private void initData() {
            if (aroptions != null) {
                noExamsImgIn.setVisibility(View.GONE);
                adapter = new OneDayAdapter(getActivity(), aroptions, pId, kId);
                oneListView.setAdapter(adapter);
                textClassTableImg.setVisibility(View.VISIBLE);
                bigExam.setVisibility(View.VISIBLE);
            } else {
                noExamsImgIn.setVisibility(View.VISIBLE);
                textClassTableImg.setVisibility(View.GONE);
                bigExam.setVisibility(View.GONE);
            }
        }
    }
}
