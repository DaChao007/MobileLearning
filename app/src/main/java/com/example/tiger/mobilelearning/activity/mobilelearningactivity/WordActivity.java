package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StatusQueryBean;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PProgressQueryImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PProgressUploadImpl;
import com.example.tiger.mobilelearning.personter.mobilelearningimpl.PStatusQueryImpl;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.ProgressQueryView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.ProgressUploadView;
import com.example.tiger.mobilelearning.viewinterface.mobilelearningface.StatusQueryView;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WordActivity extends BaseActivity implements ProgressQueryView, ProgressUploadView, StatusQueryView {

    private static final String TAG = "WordActivity";
    private static final int RESTULT_COTE = 300;

    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(R.id.titleText)
    TextView titleText;
    @BindView(R.id.startLearn)
    ImageView startLearn;
    @BindView(R.id.courseWordName)
    TextView courseWordName;
    @BindView(R.id.courseWordObject)
    TextView courseWordObject;
    @BindView(R.id.courseWordLabel)
    TextView courseWordLabel;
    @BindView(R.id.courseWordTime)
    TextView courseWordTime;
    @BindView(R.id.descriptionWord)
    TextView descriptionWord;
    @BindView(R.id.butWordStartExam)
    Button butWordStartExam;


    private int paperId;
    private int typeId;
    private int sId;
    private int finished ;
    private ProgressQueryBean.DataBean data;

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
                NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data1");
                if (sourcesBean != null) {
                    paperId = sourcesBean.getSourcePaperId();
                    typeId = sourcesBean.getSourceType();
                    sId = sourcesBean.getId();
                    if (paperId != 0) {
                        butWordStartExam.setVisibility(View.VISIBLE);
                    } else {
                        butWordStartExam.setVisibility(View.GONE);
                    }
                    courseWordName.setText(sourcesBean.getSourceTitle());
                    titleText.setText(sourcesBean.getSourceTitle());
                    courseWordLabel.setText("创建者:" + sourcesBean.getSourceCreator());
                    courseWordTime.setText("文件时长:" + sourcesBean.getSourceDuration() + "秒");
                    descriptionWord.setText(Html.fromHtml(sourcesBean.getSourceContent()));
                } else {
                    Toast.makeText(WordActivity.this, "网络连接错误！", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getProgressQuery();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_word;
    }

    @Override
    protected void destroyData() {

    }

    @OnClick({R.id.backButImg, R.id.startLearn, R.id.butWordStartExam})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                this.finish();
                break;
            case R.id.startLearn:
                Intent intent = new Intent(this, WebViewActivity.class);
                intent.putExtra("data1", getIntent().getParcelableExtra("data1"));
                startActivityForResult(intent, RESTULT_COTE);
                break;
            case R.id.butWordStartExam:
                getProgressQuery();
                setStatusQuery();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESTULT_COTE:
                finished = data.getIntExtra("finished",0);
                Log.e(TAG,"回传的"+finished);
                getProgressQuery();
                setUp();
                break;
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

    private void getProgressQuery() {
        SharedPreferences user = getSharedPreferences("user", Context.MODE_PRIVATE);
        PProgressQueryImpl upload = new PProgressQueryImpl(this, user.getString("token", null));
        Map<String, Object> map = new HashMap<>();
        int pId = getIntent().getIntExtra("pId", 0);
        int kId = getIntent().getIntExtra("kId", 0);
        int zId = getIntent().getIntExtra("zId", 0);
        NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data1");
        map.put("pId", pId);
        map.put("kId", kId);
        map.put("zId", zId);
        map.put("sId", sourcesBean.getId());
        map.put("uId", user.getInt("uid", 0));
        Log.e(TAG, pId + "--" + kId + "--" + zId + "--" + sourcesBean.getId() + "--" + user.getInt("uid", 0)+"--"+user.getString("token", null));
        upload.getSuccess(map);
    }

    private void setUp() {
        PProgressUploadImpl upload = new PProgressUploadImpl(this, getSharedPreferences("user", Context.MODE_PRIVATE).getString("token", null));
        JSONObject object = new JSONObject();
        int pId = getIntent().getIntExtra("pId", 0);
        int kId = getIntent().getIntExtra("kId", 0);
        int zId = getIntent().getIntExtra("zId", 0);
        NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data1");
        try {
            if (data ==null) {
                object.put("trainPlanId", pId);
                object.put("courseId", kId);
                object.put("chapterId", zId);
                object.put("sourceId", sourcesBean.getId());
                object.put("userId", getSharedPreferences("user", Context.MODE_PRIVATE).getInt("uid", 0));
                object.put("viewProgress", 0);
                object.put("finished", finished);
                Log.e(TAG,finished+"null");
                object.put("startTime", null);
                object.put("endTime", null);
            } else {
                if (finished==0){
                    object.put("id",data.getId());
                    object.put("trainPlanId", data.getTrainPlanId());
                    object.put("courseId", data.getCourseId());
                    object.put("chapterId", data.getChapterId());
                    object.put("sourceId", data.getSourceId());
                    object.put("userId", data.getUserId());
                    object.put("viewProgress", data.getViewProgress());
                    object.put("finished",0);
                    Log.e(TAG,data.getFinished()+"botnull");
                    object.put("startTime", null);
                    object.put("endTime", null);
                }else {
                    object.put("id",data.getId());
                    object.put("trainPlanId", data.getTrainPlanId());
                    object.put("courseId", data.getCourseId());
                    object.put("chapterId", data.getChapterId());
                    object.put("sourceId", data.getSourceId());
                    object.put("userId", data.getUserId());
                    object.put("viewProgress", data.getViewProgress());
                    object.put("finished",1);
                    Log.e(TAG,data.getFinished()+"botnull");
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
    public void OnSucceed(ProgressQueryBean body) {
        if ("0".equals(body.getResultCode())) {
            if (body.getData()!=null){
                data = body.getData();
                finished = data.getFinished();
            }else {
                setUp();
            }
        }
        Log.e(TAG, "query--" + body.toString());
    }

    @Override
    public void OnSucceed(StatusQueryBean bean) {
        if ("0".equals(bean.getResultCode())) {
            if (bean.getData().isPermission()&&finished==1) {
                startJump(this, StartExamActivity.class, paperId, typeId);
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
        Log.e(TAG, "请求错误" + error);
    }

    @Override
    public void OnSucceed(ProgressUploadBean body) {
        if ("0".equals(body.getResultCode())) {
            Log.e(TAG, "upload" + body.toString());
        }
        Log.e(TAG, "upload-->" + body.toString());
    }
}
