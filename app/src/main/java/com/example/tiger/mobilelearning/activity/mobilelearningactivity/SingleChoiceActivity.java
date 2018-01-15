package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.RadioAdapter;
import com.example.tiger.mobilelearning.adapter.mobilelearningadapter.SinglePagerAdapter;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MultipleChoiceBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.SubmitExamBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PMultipleChoiceImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PSubmitExamImpl;
import com.example.tiger.mobilelearning.view.NoScrollViewPager;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.MultipleChoiceView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.SubmitExamView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 考试题目详情页：单选
 */
public class SingleChoiceActivity extends BaseActivity implements MultipleChoiceView, SubmitExamView {


    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.singleTypeImg)
    ImageView singleTypeImg;
    @BindView(R.id.singleName)
    TextView singleName;
    @BindView(R.id.singleZongNum)
    TextView singleZongNum;
    public static TextView singleNum;
    public static ImageView upQuestionBut;
    public static ImageView nextQuestionBut;
    @BindView(R.id.countdownText)
    TextView countdownText;

    public static ImageView carryOut;
    @BindView(R.id.singleViewPager)
    NoScrollViewPager singleViewPager;
    RelativeLayout noExamsImg;
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    private SinglePagerAdapter pagerAdapter;
    public static int examnum;
    public static JSONArray jsonArray = new JSONArray();
    private int pagerIndex = 0;
    public static int optionsInt;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    singleViewPager.setCurrentItem(pagerIndex);
                    break;
                case 300:
                    singleViewPager.setCurrentItem(pagerIndex);
                    break;
            }
            singleNum.setText(pagerIndex + 1 + "");
            if (pagerIndex + 1 == 1) {
                upQuestionBut.setVisibility(View.GONE);
            } else {
                upQuestionBut.setVisibility(View.VISIBLE);
            }
            if (examnum == pagerIndex + 1) {
                nextQuestionBut.setVisibility(View.GONE);
                carryOut.setVisibility(View.VISIBLE);
            } else {
                nextQuestionBut.setVisibility(View.VISIBLE);
                carryOut.setVisibility(View.GONE);
            }
        }
    };
    private int minute = 30;//这是分钟
    private int second = 00;//这是分钟后面的秒数。这里是以30分钟为例的，所以，minute是30，second是0
    private Timer timer;
    private TimerTask timerTask;
    //这是接收回来处理的消息
    private Handler handlerTimer = new Handler() {
        public void handleMessage(Message msg) {
            if (minute == 0) {
                if (second == 0) {
                    countdownText.setText("Time out !");
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask = null;
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        countdownText.setText("0" + minute + ":" + second);
                    } else {
                        countdownText.setText("0" + minute + ":0" + second);
                    }
                }
            } else {
                if (second == 0) {
                    second = 59;
                    minute--;
                    if (minute >= 10) {
                        countdownText.setText(minute + ":" + second);
                    } else {
                        countdownText.setText("0" + minute + ":" + second);
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        if (minute >= 10) {
                            countdownText.setText(minute + ":" + second);
                        } else {
                            countdownText.setText("0" + minute + ":" + second);
                        }
                    } else {
                        if (minute >= 10) {
                            countdownText.setText(minute + ":0" + second);
                        } else {
                            countdownText.setText("0" + minute + ":0" + second);
                        }
                    }
                }
            }
        }

    };
    private int paperRecordId;
    private int paperId;


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
                titleText.setText("我的考试");
            }
        });
        examnum = getIntent().getIntExtra("num", 0);
        paperId = getIntent().getIntExtra("paperId", 0);
        singleZongNum.setText("/" + examnum);
        startTimer();
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PMultipleChoiceImpl choice = new PMultipleChoiceImpl(this, user.getString("token", null));
        choice.getSuccess(paperId);
    }

    private void startTimer() {
        countdownText.setText(minute + ":" + second);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0;
                handlerTimer.sendMessage(msg);
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }


    @Override
    protected void onDestroy() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask = null;
        }
        minute = -1;
        second = -1;
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        singleNum = (TextView) findViewById(R.id.singleNum);
        noExamsImg = (RelativeLayout) findViewById(R.id.noExamsImgIn);
        upQuestionBut = (ImageView) findViewById(R.id.upQuestionBut);
        nextQuestionBut = (ImageView) findViewById(R.id.nextQuestionBut);
        carryOut = (ImageView) findViewById(R.id.carryOut);
        singleViewPager.setNoScroll(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_single_choice;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.upQuestionBut, R.id.nextQuestionBut, R.id.carryOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.upQuestionBut:
                pagerIndex--;
                handler.sendEmptyMessage(300);
                break;
            case R.id.nextQuestionBut:
                pagerIndex++;
                handler.sendEmptyMessage(200);
                break;
            case R.id.carryOut:
                SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
                PSubmitExamImpl submitExam = new PSubmitExamImpl(this, user.getString("token", null));
                Map<String, Object> map = new HashMap();
                map.put("paperRecordId", paperRecordId);
                map.put("answers", jsonArray);
                Log.e("TAG", jsonArray.toString());
                Log.e("TAG", paperRecordId + "--");
                submitExam.getSuccess(map);
                break;
        }
    }

    private void startJump(Context context, Class c, SubmitExamBean.DataBean bean) {
        Intent intent = new Intent(context, c);
        intent.putExtra("data", bean);
        startActivity(intent);
    }


    @Override
    public void OnSucceed(MultipleChoiceBean bean) {
//        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        List<MultipleChoiceBean.DataBean.QuestionsBean> questions = bean.getData().getQuestions();
        paperRecordId = bean.getData().getPaperRecordId();
        upQuestionBut.setVisibility(View.GONE);
        if (questions.size() > 0) {
            noExamsImg.setVisibility(View.GONE);
            singleViewPager.setVisibility(View.VISIBLE);
            for (int i = 0; i < questions.size(); i++) {
                MultipleChoiceBean.DataBean.QuestionsBean questionsBean = questions.get(i);
                SingleFragment fragment = new SingleFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", questionsBean.getTitle());
                ArrayList<MultipleChoiceBean.DataBean.QuestionsBean.OptionsBean> options = (ArrayList<MultipleChoiceBean.DataBean.QuestionsBean.OptionsBean>) questionsBean.getOptions();
                bundle.putParcelable("questionsBean", questionsBean);
                bundle.putParcelableArrayList("options", options);
                bundle.putInt("index", i);
                fragment.setArguments(bundle);
                fragments.add(fragment);
            }
        } else {
            noExamsImg.setVisibility(View.VISIBLE);
            singleViewPager.setVisibility(View.GONE);
        }
        pagerAdapter = new SinglePagerAdapter(getSupportFragmentManager(), fragments);
        singleViewPager.setAdapter(pagerAdapter);
        singleViewPager.setOffscreenPageLimit(questions.size());
        singleViewPager.setCurrentItem(0);
    }

    @Override
    public void OnSucceed(SubmitExamBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData().getFalseCount() > 60) {
                startJump(this, PassingTheExamActivity.class, bean.getData());
                this.finish();
            } else {
                startJump(this, TheExamDidNotPassActivity.class, bean.getData());
                this.finish();
            }
        } else {
            Toast.makeText(this, "当前提交错误！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void OnDefeated(String error) {
        Log.e("TAG", "请求失败" + error);
    }

    // 定义一个变量，来标识是否退出

    private static boolean isExit = false;

    Handler mHandler = new Handler() {

        @Override

        public void handleMessage(Message msg) {

            super.handleMessage(msg);

            isExit = false;

        }

    };

    @Override

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            exit();

            return false;

        }

        return super.onKeyDown(keyCode, event);

    }

    private void exit() {

        if (!isExit) {

            isExit = true;

            Toast.makeText(getApplicationContext(), "再按一次您将退出答题界面，当前记录则无法保存！",

                    Toast.LENGTH_SHORT).show();

            // 利用handler延迟发送更改状态信息

            mHandler.sendEmptyMessageDelayed(0, 2000);

        } else {

            finish();

            System.exit(0);

        }

    }

    public static class SingleFragment extends Fragment {

        private TextView singleContent;
        private ListView singListView;
        private RadioAdapter adapter;
        private String title;
        private ArrayList<MultipleChoiceBean.DataBean.QuestionsBean.OptionsBean> options;
        private MultipleChoiceBean.DataBean.QuestionsBean questionsBean;
        private int index;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            final Bundle bundle = getArguments();
            if (bundle != null) {
                title = bundle.getString("title");
                options = bundle.getParcelableArrayList("options");
                questionsBean = bundle.getParcelable("questionsBean");
                index = bundle.getInt("index");
            }
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.item_single, null);
            singleContent = (TextView) view.findViewById(R.id.singleContent);
            singListView = (ListView) view.findViewById(R.id.singListView);
            singleContent.setText(title);
            adapter = new RadioAdapter(getActivity(), options);
            singListView.setAdapter(adapter);
            setinitister();
            return view;
        }

        private void setinitister() {
                    singListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    optionsInt = position;
                    forinitView();
                    ImageView itemExamImg = (ImageView) view.findViewById(R.id.itemExamImg);
                    getImg(itemExamImg, position);
                    adapter.notifyDataSetChanged();
//                    int checkedItemPosition = singListView.getCheckedItemPosition();
//                    Toast.makeText(getActivity(), updataNum(checkedItemPosition), Toast.LENGTH_SHORT).show();
                    JSONObject jsonObject = new JSONObject();
                    SharedPreferences user = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    try {
                        jsonObject.put("userId", user.getInt("uid", 0));
                        jsonObject.put("paperId", 1);
                        jsonObject.put("questionId", questionsBean.getId());
                        jsonObject.put("answerOptionId", options.get(position).getId());
                        jsonObject.put("score", questionsBean.getScore());
                        jsonArray.put(index, jsonObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private void forinitView() {
            for (int i = 0; i < singListView.getChildCount(); i++) {
                View childAt = singListView.getChildAt(i);
                ImageView viewById = (ImageView) childAt.findViewById(R.id.itemExamImg);
                setimg(viewById, i);
            }
        }

        private String updataNum(int checkedItemPosition) {
            switch (checkedItemPosition) {
                case 0:
                    return "您的选择是A";
                case 1:
                    return "您的选择是B";
                case 2:
                    return "您的选择是C";
                case 3:
                    return "您的选择是D";
            }
            return "您当前无选择";
        }


        private void setimg(ImageView view, int position) {
            switch (position) {
                case 0:
                    view.setImageResource(R.drawable.img_ano);
                    break;
                case 1:
                    view.setImageResource(R.drawable.img_bno);
                    break;
                case 2:
                    view.setImageResource(R.drawable.img_cno);
                    break;
                case 3:
                    view.setImageResource(R.drawable.img_dno);
                    break;
            }
        }

        private void getImg(ImageView view, int position) {
            switch (position) {
                case 0:
                    view.setImageResource(R.drawable.img_aok);
                    break;
                case 1:
                    view.setImageResource(R.drawable.img_bok);
                    break;
                case 2:
                    view.setImageResource(R.drawable.img_cok);
                    break;
                case 3:
                    view.setImageResource(R.drawable.img_dok);
                    break;
            }
        }
    }

}
