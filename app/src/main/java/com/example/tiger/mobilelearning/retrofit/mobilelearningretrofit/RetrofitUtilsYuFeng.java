package com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.FeedbackBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MultipleChoiceBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MyStudyRecordBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StartExamBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.SubmitExamBean;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tiger on 2017/12/5.
 * 网络请求的主要工具类
 */

public class RetrofitUtilsYuFeng {

    private static final int MAXTIME = 5;
    private static RetrofitUtilsYuFeng retrofitUtils;
    private RetrofitAPIServices apiServices;

    private RetrofitUtilsYuFeng(final String token) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("token", token)
                        .build();
                return chain.proceed(request);
            }
        })
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .build();

        apiServices = new Retrofit.Builder()
                .client(client)
//                .baseUrl("http://117.107.154.179:8080/")
                .baseUrl("http://192.168.3.62:8080/")
//                .baseUrl("http://114.215.16.200:8081/")
//                .baseUrl("http://192.168.3.9:8080/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPIServices.class);
    }

    public static RetrofitUtilsYuFeng getInstance(String token) {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtilsYuFeng.class) {
                retrofitUtils = new RetrofitUtilsYuFeng(token);
            }
        }
        return retrofitUtils;
    }

    //我的考试(题类型 内含多选 单选等)
    public void getMultipleChoice(Observer<MultipleChoiceBean> observer, int paperId) {
        Observable<MultipleChoiceBean> observable = apiServices.sendMultipleChoice(paperId);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //我的考试(开始考试)
    public void getStartExam(Observer<StartExamBean> observer, int paperId) {
        Observable<StartExamBean> observable = apiServices.sendStartExam(paperId);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //我的考试(开始考试)
    public void postStartExam(Observer<SubmitExamBean> observer, Map<String, Object> map) {
        Observable<SubmitExamBean> observable = apiServices.sendSubmitExam(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //看完视频进度上传
    public void postProgressUpload(Observer<ProgressUploadBean> observer, String trainScheduleStr) {
        Observable<ProgressUploadBean> observable = apiServices.sendProgressUploadPost(trainScheduleStr);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //每次请求课程详细界面查询进度
    public void getProgressQuery(Observer<ProgressQueryBean> observer, Map<String, Object> map) {
        Observable<ProgressQueryBean> observable = apiServices.sendProgressQueryGet(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //我的记录中的学习状态
    public void getStudyRecord(Observer<MyStudyRecordBean> observer) {
        Observable<MyStudyRecordBean> observable = apiServices.sendStudyRecordGet();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //我的记录中的问题反馈
    public void getFeedback(Observer<FeedbackBean> observer, String suggestionStr) {
        Observable<FeedbackBean> observable = apiServices.sendFeedbackGet(suggestionStr);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
