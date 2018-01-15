package com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit;

import com.example.tiger.mobilelearning.entity.mobilelearningentity.BindPhoneBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.BoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.FeedbackBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ForgetPasswordNewBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.GetVerificationCodeBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.HistoryRecordBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.LoginBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MultipleChoiceBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.MyStudyRecordBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NewNoviceShoolBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.NotBoundBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.OfflineReviewBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.PersonalExamBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.ProgressUploadBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StartExamBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.StatusQueryBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.SubmitExamBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainerNameBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.TrainingProgramBean;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UnBind;
import com.example.tiger.mobilelearning.entity.mobilelearningentity.UpDatePwdBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Tiger on 2017/12/5.
 * Retrofit接口类
 */

public interface RetrofitAPIServices {

    //获取培训计划列表
    @GET("elearning-app/train/plan/list.htm")
    Observable<TrainingProgramBean> sendTrainingProgramGet();

    //登录
    @FormUrlEncoded
    @POST("elearning-app/login/login.htm")
    Observable<LoginBean> sendLoginPost(@FieldMap Map<String, String> map);

    //培训计划已绑定人员
    @GET("elearning-app/train/plan/binduser.htm")
    Observable<BoundBean> sendBoundOkGet(@QueryMap Map<String, String> map);

    //培训计划未绑定人员
    @GET("elearning-app/train/plan/notbinduser.htm")
    Observable<NotBoundBean> sendBoundNoGet(@QueryMap Map<String, String> map);

    //绑定人员(绑定解绑一个接口)
    @FormUrlEncoded
    @POST("elearning-app/train/plan/user/bind.htm")
    Observable<UnBind> sendUnbindPost(@FieldMap Map<String, String> map);

    //我的考试(题类型 内含多选 单选等)
    @GET("elearning-app/exam/paper/start.htm")
    Observable<MultipleChoiceBean> sendMultipleChoice(@Query("paperId") int paperId);

    //我的考试(开始考试)
    @GET("elearning-app/exam/paper/show.htm")
    Observable<StartExamBean> sendStartExam(@Query("paperId") int paperId);

    //新手七天请求
    @GET("elearning-app//exam/plan/courses.htm")
    Observable<NewNoviceShoolBean> sendNewShoolGet();

    //考试完成后试卷结果上传
    @FormUrlEncoded
    @POST("elearning-app/exam/paper/submit.htm")
    Observable<SubmitExamBean> sendSubmitExam(@FieldMap Map<String, Object> map);

    //修改密码
    @FormUrlEncoded
    @POST("elearning-app/user/updatePwd.htm")
    Observable<UpDatePwdBean> sendUpdatePwdPost(@FieldMap Map<String, String> map);

    //获取个人学习进度
    @GET("elearning-app/exam/paper/progress.htm")
    Observable<PersonalExamBean> sendPersonalExagGet(@Query("userId") int userId);

    //人工审核线下考试
    @FormUrlEncoded
    @POST("elearning-app/course/plan/examine.htm")
    Observable<OfflineReviewBean> sendOfflineReview(@FieldMap Map<String, Object> map);

    //看完视频进度上传
    @FormUrlEncoded
    @POST("elearning-app/trainScheduleControl/trainSchedule.htm")
    Observable<ProgressUploadBean> sendProgressUploadPost(@Field("trainScheduleStr") String trainScheduleStr);

    //每次请求课程详细界面查询进度
    @GET("elearning-app/trainScheduleControl/queryByXXX.htm")
    Observable<ProgressQueryBean> sendProgressQueryGet(@QueryMap Map<String, Object> map);

    //考试状态查询
    @GET("elearning-app/course/plan/examstatus.htm")
    Observable<StatusQueryBean> sendStatusQueryGet(@QueryMap Map<String, Object> map);

    //员工绑定的当前训导员
    @GET("elearning-app/exam/plan/teacher.htm")
    Observable<TrainerNameBean> sendTrainerNameGet();

    //我的记录中的学习状态
    @GET("elearning-app/footprint/studystatus.htm")
    Observable<MyStudyRecordBean> sendStudyRecordGet();

    //我的记录中的问题反馈
    @FormUrlEncoded
    @POST("elearning-app/suggestionControl/merge.htm")
    Observable<FeedbackBean> sendFeedbackGet(@Field("suggestionStr") String suggestionStr);

    //登录界面忘记密码中发送手机验证码
    @FormUrlEncoded
    @POST("elearning-app/pwdHand/getPhoneCode.htm")
    Observable<Response<GetVerificationCodeBean>> sendVerificationCodePost(@Field("phoneNum") String phoneNum);

    //登录界面忘记密码中确定新密码
    @FormUrlEncoded
    @POST("elearning-app/pwdHand/resetPwd.htm")
    Observable<ForgetPasswordNewBean> sendPasswordNewPost(@Header("cookie") String cookie, @FieldMap Map<String, Object> map);

    //登录成功后判断手机是否绑定 返回0 跳转的绑定手机号页面
    @FormUrlEncoded
    @POST("elearning-app/user/log/initial.htm")
    Observable<BindPhoneBean> sendBindPhone(@Header("cookie") String cookie, @FieldMap Map<String, Object> map);

    //获取我的记录里个人历史记录
    @GET("elearning-app/trainScheduleControl/queryByUserId.htm")
    Observable<HistoryRecordBean> sendHistoryRecordGet(@Query("userId") int userId);
}
