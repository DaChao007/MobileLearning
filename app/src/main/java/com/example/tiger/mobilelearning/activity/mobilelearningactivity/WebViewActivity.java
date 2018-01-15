package com.example.tiger.mobilelearning.activity.mobilelearningactivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiger.mobilelearning.R;
import com.example.tiger.mobilelearning.base.BaseActivity;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import im.delight.android.webview.AdvancedWebView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.tiger.mobilelearning.R.id.titleText;

public class WebViewActivity extends BaseActivity implements AdvancedWebView.Listener {

    private static final String TAG = "WebViewActivity";
    private static final int RESTULT_COTE = 300;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    @BindView(R.id.myWebView)
    AdvancedWebView myWebView;
    @BindView(R.id.myWebLayout)
    LinearLayout myWebLayout;
    @BindView(R.id.backButImg)
    ImageView backButImg;
    @BindView(titleText)
    TextView titleText1;
    @BindView(R.id.pdfView)
    PDFView pdfView;

    @Override
    protected void resumeData() {

    }

    @Override
    protected void initListener() {
        myWebView.setListener(this, this);
    }

    @Override
    protected void initData() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                NewNoviceShoolBean.DataBean.CoursesBean.ChaptersBean.SourcesBean sourcesBean = getIntent().getParcelableExtra("data1");
                if (sourcesBean != null) {
                    try {
                        titleText1.setText(sourcesBean.getSourceTitle());
                        titleText1.setTextSize(15);
                        String encode = URLEncoder.encode(sourcesBean.getSourceRefLink(), "utf-8");
                        URLDecoder urlDecoder = new URLDecoder();
                        String s = urlDecoder.decode(encode, "utf-8");
                        Log.e(TAG, sourcesBean.getSourceRefLink());
                        if (sourcesBean.getSourceRefLink().endsWith(".pdf")) {
                            myWebView.setVisibility(View.GONE);
                            pdfView.setVisibility(View.VISIBLE);
                            OkHttpClient client = new OkHttpClient();
                            client.newCall(new Request.Builder().url(s).build()).enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    Toast.makeText(WebViewActivity.this, "页面错误！", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    pdfView.fromStream(response.body().byteStream()).load();
                                }
                            });
                        } else if (sourcesBean.getSourceRefLink().endsWith(".png")||sourcesBean.getSourceRefLink().endsWith(".jpg")) {
                            pdfView.setVisibility(View.GONE);
                            myWebView.setVisibility(View.VISIBLE);
                            myWebView.loadUrl(s);
                        } else {
                            pdfView.setVisibility(View.GONE);
                            myWebView.setVisibility(View.VISIBLE);
                            myWebView.loadUrl("https://view.officeapps.live.com/op/view.aspx?src=" + s);
//                            myWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + s);
                        }
//                        myWebView.loadUrl("https://view.officeapps.live.com/op/view.aspx?src=https://hrtop.oss-cn-qingdao.aliyuncs.com/8dbff16c49e3630b364f2e1470613de0-%E8%A5%BF%E8%B4%9D%E5%9F%B9%E8%AE%AD-%E9%9C%80%E6%B1%82%E8%A7%84%E6%A0%BC%E8%AF%B4%E6%98%8E%E4%B9%A6V0.5(1).docx");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                NewNoviceShoolBean.DataBean.CoursesBean coursesBean = getIntent().getParcelableExtra("data");
                if (coursesBean != null) {
                    titleText1.setText("课程表");
                    titleText1.setTextSize(15);
                    try {
                        String encode1 = URLEncoder.encode(coursesBean.getCourseFile(), "utf-8");
                        URLDecoder urlDecoder = new URLDecoder();
                        String s1 = urlDecoder.decode(encode1, "utf-8");
                        if (coursesBean.getCourseFile().endsWith(".pdf")) {
                            myWebView.setVisibility(View.GONE);
                            pdfView.setVisibility(View.VISIBLE);
                            OkHttpClient client = new OkHttpClient();
                            client.newCall(new Request.Builder().url(s1).build()).enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    Toast.makeText(WebViewActivity.this, "页面错误！", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    pdfView.fromStream(response.body().byteStream()).load();
                                }
                            });
                            Log.e(TAG, "加载失败");
                        } else if (coursesBean.getCourseFile().endsWith(".png")||coursesBean.getCourseFile().endsWith(".jpg")) {
                            pdfView.setVisibility(View.GONE);
                            myWebView.setVisibility(View.VISIBLE);
                            myWebView.loadUrl(s1);
                        } else {
                            pdfView.setVisibility(View.GONE);
                            myWebView.setVisibility(View.VISIBLE);
                            myWebView.loadUrl("https://view.officeapps.live.com/op/view.aspx?src=" + s1);
//                            myWebView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + s1);
                            Log.e(TAG, "加载成功");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    /**
     * 获取动态权限
     */
    public void getPermission() {
        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(WebViewActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(WebViewActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Log.d("yx", "get permission");
                ActivityCompat.requestPermissions(WebViewActivity.this,
                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
            Log.d("yx", "get permission2");
            ActivityCompat.requestPermissions(WebViewActivity.this,
                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
        Log.d("yx", "wait for PERMISSION_GRANTED");
        while ((ContextCompat.checkSelfPermission(WebViewActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
        }
        Log.d("yx", "wait for PERMISSION_GRANTED finish");
    }


    @Override
    protected void initView() {
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        getPermission();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void destroyData() {

    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        myWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        myWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        myWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!myWebView.onBackPressed()) {
            return;
        }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
    }

    @Override
    public void onPageFinished(String url) {
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
    }

    @Override
    public void onExternalPageRequest(String url) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myWebLayout.removeView(myWebView);
        myWebView.destroy();
    }

    @OnClick({R.id.backButImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.backButImg:
                Intent intent = new Intent();
                intent.putExtra("finished", 1);
                setResult(RESTULT_COTE, intent);
                this.finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
