package com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.BindPhoneBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.BoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NotBoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.OfflineReviewBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StatusQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainerNameBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainingProgramBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UnBind;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UpDatePwdBean;
import com.example.tiger.mobilelearning.retrofit.RetrofitUtils;

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
 * Created by Tiger on 2017/12/13.
 */

public class RetrofitUtilsToken {

    private static final int MAXTIME = 5;
    private static RetrofitUtilsToken retrofitUtils;
    private RetrofitAPIServices apiServices;

    private RetrofitUtilsToken(final String token) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
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

    public static synchronized RetrofitUtilsToken getInstance(String token) {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null)
                    retrofitUtils = new RetrofitUtilsToken(token);
            }
        }
        return retrofitUtils;
    }

    //修改密码
    public void postUpdatePwd(Observer<UpDatePwdBean> observer, Map map) {
        Observable<UpDatePwdBean> observable = apiServices.sendUpdatePwdPost(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //获取培训计划列表
    public void getTrainingProgram(Observer<TrainingProgramBean> observer) {
        Observable<TrainingProgramBean> observable = apiServices.sendTrainingProgramGet();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //获取已绑定人员列表
    public synchronized void getBoundOk(Observer<BoundBean> observer, Map<String, String> map) {
        Observable<BoundBean> observable = apiServices.sendBoundOkGet(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //获取未绑定人员列表
    public synchronized void getBoundNo(Observer<NotBoundBean> observer, Map<String, String> map) {
        Observable<NotBoundBean> observable = apiServices.sendBoundNoGet(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //绑定人员(绑定解绑)一个接口
    public synchronized void postUnBind(Observer<UnBind> observer, Map<String, String> map) {
        Observable<UnBind> observabUnBindle = apiServices.sendUnbindPost(map);
        observabUnBindle.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //新手七天
    public void getNewShool(Observer<NewNoviceShoolBean> observer) {
        Observable<NewNoviceShoolBean> observable = apiServices.sendNewShoolGet();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //获取个人学习进度
    public synchronized void getPersonalExag(Observer<PersonalExamBean> observer, int userId) {
        Observable<PersonalExamBean> observable = apiServices.sendPersonalExagGet(userId);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //人工审核线下考试
    public void postOfflineReview(Observer<OfflineReviewBean> observer, Map<String, Object> map) {
        Observable<OfflineReviewBean> observable = apiServices.sendOfflineReview(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //考试状态查询
    public void getStatusQuery(Observer<StatusQueryBean> observer, Map<String, Object> map) {
        Observable<StatusQueryBean> observable = apiServices.sendStatusQueryGet(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //考试状态查询
    public void getTrainerName(Observer<TrainerNameBean> observer) {
        Observable<TrainerNameBean> observable = apiServices.sendTrainerNameGet();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //登录成功后判断手机是否绑定 返回0 跳转的绑定手机号页面
    public void postBindPhone(Observer<BindPhoneBean> observer, String cookie, Map<String, Object> map) {
        Observable<BindPhoneBean> observable = apiServices.sendBindPhone(cookie, map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //获取我的记录里个人历史记录
    public void getHistoryRecord(Observer<HistoryRecordBean> observer,int userId) {
        Observable<HistoryRecordBean> observable = apiServices.sendHistoryRecordGet(userId);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
