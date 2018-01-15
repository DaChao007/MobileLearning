package com.example.tiger.mobilelearning.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.activity.mobilelearningactivity.StartExamActivity;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StatusQueryBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PProgressQueryImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PProgressUploadImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PStatusQueryImpl;
import com.example.tiger.mobilelearning.utils.Netwoke;
import com.example.tiger.mobilelearning.view.JCVideoPlayerVideo;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.ProgressQueryView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.ProgressUploadView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.StatusQueryView;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 带视频 简介目录的课程详情界面
 */
public class CourseDetailsActivity extends BaseActivity implements View.OnClickListener, ProgressQueryView, ProgressUploadView, StatusQueryView {

    private static final String TAG = "CourseDetailsActivity";

    private JCVideoPlayerVideo videoplayer;
    //include标签名字跟后退按钮
/*  private ImageView backButImg;
    private TextView titleText;*/
    //    private PresenterImpl presenter = new PresenterImpl(this);
    private TextView courseName;
    private TextView courseTime;

    private static int paperId;
    private static int typeId;
    private int finished;
    private int sId;
    private ProgressQueryBean.DataBean data;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 456:
                    setDuration();
                    break;
            }
        }
    };
    private ImageView courseExam;
    private TextView videoNum;
    private ListView courseListView;

    private void assignViews() {
       /* backButImg = (ImageView) findViewById(R.id.backButImg);
        titleText = (TextView) findViewById(R.id.titleText);*/
        videoplayer = (JCVideoPlayerVideo) findViewById(R.id.videoplayer);
        courseName = (TextView) findViewById(R.id.courseName);
        courseTime = (TextView) findViewById(R.id.courseTime);
        videoNum = (TextView) findViewById(R.id.videoNum);
        courseExam = (ImageView) findViewById(R.id.courseExam);
        courseListView = (ListView) findViewById(R.id.courseListView);
    }

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
//        backButImg.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data");
                if (sourcesBean != null) {
//                    titleText.setText(sourcesBean.getSourceTitle());
                    paperId = sourcesBean.getSourcePaperId();
                    typeId = sourcesBean.getSourceType();
                    sId = sourcesBean.getId();
                    if (paperId != 0) {
//                        butStartExam.setVisibility(View.VISIBLE);
                    } else {
//                        butStartExam.setVisibility(View.GONE);
                    }
                    Log.e(TAG, paperId + "--");
                    try {
                        String encode = URLEncoder.encode(sourcesBean.getSourceRefLink(), "utf-8");
                        java.net.URLDecoder urlDecoder = new java.net.URLDecoder();
                        String s = urlDecoder.decode(encode, "utf-8");
                        Log.e(TAG, s);
                        videoplayer.setUp(s, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, sourcesBean.getSourceTitle());
                        Glide.with(CourseDetailsActivity.this).load(R.drawable.img_startvideo).into(videoplayer.thumbImageView);
                        courseName.setText(sourcesBean.getSourceTitle());
//                        courseLabel.setText("创建者:" + sourcesBean.getSourceCreator());
                        courseTime.setText("文件时长:" + sourcesBean.getSourceDuration() + "秒");
//                        description.setText(Html.fromHtml(sourcesBean.getSourceContent()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(CourseDetailsActivity.this, "网络连接错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initView() {
        assignViews();
        Toast.makeText(this, Netwoke.getnetwoke(this), Toast.LENGTH_SHORT).show();
        getProgressQuery();
        setTimer();
    }

    private void setTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                handler.sendEmptyMessage(456);
            }
        }, 0, 2000);//0.5秒之后，每隔10秒做一次run()操作
    }

    private void getProgressQuery() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PProgressQueryImpl upload = new PProgressQueryImpl(this, user.getString("token", null));
        Map<String, Object> map = new HashMap<>();
        int pId = getIntent().getIntExtra("pId", 0);
        int kId = getIntent().getIntExtra("kId", 0);
        int zId = getIntent().getIntExtra("zId", 0);
        NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data");
        map.put("pId", pId);
        map.put("kId", kId);
        map.put("zId", zId);
        map.put("sId", sourcesBean.getId());
        map.put("uId", user.getInt("uid", 0));
        Log.e(TAG, pId + "--" + kId + "--" + zId + "--" + sourcesBean.getId() + "--" + user.getInt("uid", 0));
        upload.getSuccess(map);
    }


    private void setDuration() {
        if (videoplayer.getDuration() > 2000) {
            if (videoplayer.getDuration() - 20000 <= videoplayer.getCurrentPositionWhenPlaying()) {
                finished = 1;
                setUp();
            }
        }
        Log.e(TAG, videoplayer.getDuration() + "---" + videoplayer.getCurrentPositionWhenPlaying());
    }

    private void setUp() {
        PProgressUploadImpl upload = new PProgressUploadImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null));
        JSONObject object = new JSONObject();
        int pId = getIntent().getIntExtra("pId", 0);
        int kId = getIntent().getIntExtra("kId", 0);
        int zId = getIntent().getIntExtra("zId", 0);
        NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data");
        try {
            if (data == null) {
                object.put("trainPlanId", pId);
                object.put("courseId", kId);
                object.put("chapterId", zId);
                object.put("sourceId", sourcesBean.getId());
                object.put("userId", getSharedPreferences("user", Context.MODE_PRIVATE).getInt("uid", 0));
                object.put("viewProgress", 0);
                object.put("finished", finished);
                Log.e(TAG, finished + "null");
                object.put("startTime", null);
                object.put("endTime", null);
            } else {
                if (finished == 0) {
                    object.put("id", data.getId());
                    object.put("trainPlanId", data.getTrainPlanId());
                    object.put("courseId", data.getCourseId());
                    object.put("chapterId", data.getChapterId());
                    object.put("sourceId", data.getSourceId());
                    object.put("userId", data.getUserId());
                    object.put("viewProgress", data.getViewProgress());
                    object.put("finished", 0);
                    Log.e(TAG, data.getFinished() + "botnull");
                    object.put("startTime", null);
                    object.put("endTime", null);
                } else {
                    object.put("id", data.getId());
                    object.put("trainPlanId", data.getTrainPlanId());
                    object.put("courseId", data.getCourseId());
                    object.put("chapterId", data.getChapterId());
                    object.put("sourceId", data.getSourceId());
                    object.put("userId", data.getUserId());
                    object.put("viewProgress", data.getViewProgress());
                    object.put("finished", 1);
                    Log.e(TAG, data.getFinished() + "botnull");
                    object.put("startTime", null);
                    object.put("endTime", null);
                }
            }
            upload.getSuccess(object.toString());
            Log.e(TAG, object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_course_details;
    }

    @Override
    protected void destroyData() {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.backButImg:
                this.finish();
                break;*/
            /*case butStartExam:
                setDuration();
                setStatusQuery();
                break;*/
        }
    }

    private void setStatusQuery() {
        PStatusQueryImpl statusQuery = new PStatusQueryImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null));
        Map<String, Object> map = new HashMap<>();
        map.put("courseId", getIntent().getIntExtra("kId", 0));
        map.put("type", 3);
        map.put("typeId", sId);
        statusQuery.getSuccess(map);
    }

    private void startJump(Context context, Class c, int paperId, int typeId) {
        Intent intent = new Intent(context, c);
        intent.putExtra("paperId", paperId);
        intent.putExtra("typeId", typeId);
        intent.putExtra("kId", getIntent().getIntExtra("kId", 0));
        startActivity(intent);
    }

    @Override
    public void OnSucceed(ProgressQueryBean body) {
        if ("0".equals(body.getResultCode())) {
            if (body.getData() != null) {
                data = body.getData();
                finished = data.getFinished();
            } else {
                setUp();
            }
        }
        Log.e(TAG, "query--" + body.toString());
    }

    @Override
    public void OnSucceed(ProgressUploadBean body) {
        if ("0".equals(body.getResultCode())) {
            Log.e(TAG, "upload" + body.toString());
        }
        Log.e(TAG, "upload" + body.toString());
    }

    @Override
    public void OnSucceed(StatusQueryBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData().isPermission() && finished == 1) {
                startJump(CourseDetailsActivity.this, StartExamActivity.class, paperId, typeId);
                Log.e(TAG, bean.toString());
            } else {
                Toast.makeText(this, "您当前无法考试，请先学习！", Toast.LENGTH_SHORT).show();
            }
        } else {
            Log.e(TAG, "请求失败");
        }
        Log.e(TAG, bean.toString());
    }

    @Override
    public void OnDefeated(String error) {
        Log.e(TAG, "请求错误-->" + error);
    }
}
