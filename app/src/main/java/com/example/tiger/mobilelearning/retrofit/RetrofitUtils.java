package com.example.tiger.mobilelearning.retrofit;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.ForgetPasswordNewBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.LoginBean;
import com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit.RetrofitAPIServices;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tiger on 2017/12/5.
 * 网络请求的主要工具类
 */

public class RetrofitUtils {

    private static final int MAXTIME = 5;
    private static RetrofitUtils retrofitUtils;
    private RetrofitAPIServices apiServices;

    private RetrofitUtils() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .build();

        apiServices = new Retrofit.Builder()
                .client(client)
//                .baseUrl("http://117.107.154.179:8080/")
                .baseUrl("http://192.168.3.62:8080/")
//                .baseUrl("http://192.168.3.9:8080/")
//                .baseUrl("http://114.215.16.200:8081/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitAPIServices.class);
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }

    //登录
    public void postLogin(Observer<LoginBean> observer, Map<String, String> map) {
        Observable<LoginBean> observable = apiServices.sendLoginPost(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //登录界面忘记密码中发送手机验证码
    public void postVerificationCode(Observer<Response<GetVerificationCodeBean>> observer, String phoneNum) {
        Observable<Response<GetVerificationCodeBean>> observable = apiServices.sendVerificationCodePost(phoneNum);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    //登录界面忘记密码中确定新密码
    public void posPasswordNew(Observer<ForgetPasswordNewBean> observer,String cookie, Map<String,Object> map) {
        Observable<ForgetPasswordNewBean> observable = apiServices.sendPasswordNewPost(cookie,map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }
}
