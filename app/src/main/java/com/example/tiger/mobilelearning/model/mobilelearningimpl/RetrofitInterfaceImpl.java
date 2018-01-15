package com.example.tiger.mobilelearning.model.mobilelearningimpl;

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
import com.example.tiger.mobilelearning.model.NetWorkManger;
import com.example.tiger.mobilelearning.retrofit.RetrofitUtils;
import com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit.RetrofitUtilsToken;
import com.example.tiger.mobilelearning.retrofit.mobilelearningretrofit.RetrofitUtilsYuFeng;

import java.util.Map;

import io.reactivex.Observer;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/9/14.
 * 实现接口，调用网络请求 把观察者赋值到网络请求工具类的方法中 用于线程调度
 * Rxjava最后要通过被观察者对象的subscribe方法来添加观察者
 */

public class RetrofitInterfaceImpl implements NetWorkManger {

    //获取培训计划列表
    @Override
    public void requestGetTrainingProgram(Observer<TrainingProgramBean> observer, String token) {
        RetrofitUtilsToken.getInstance(token).getTrainingProgram(observer);
    }

    //登录
    @Override
    public void requestPostLogin(Observer<LoginBean> observer, Map<String, String> map) {
        RetrofitUtils.getInstance().postLogin(observer, map);
    }

    //获取培训计划已绑定人员列表
    @Override
    public void requestPostBoundOk(Observer<BoundBean> observer, String token, Map<String, String> map) {
        RetrofitUtilsToken.getInstance(token).getBoundOk(observer, map);
    }

    //获取培训计划未绑定人员列表
    @Override
    public void requestPostBoundNo(Observer<NotBoundBean> observer, String token, Map<String, String> map) {
        RetrofitUtilsToken.getInstance(token).getBoundNo(observer, map);
    }

    //绑定人员(解绑或者绑定)
    @Override
    public void requestPostUnBound(Observer<UnBind> observer, String token, Map<String, String> map) {
        RetrofitUtilsToken.getInstance(token).postUnBind(observer, map);
    }

   /* //解绑
    @Override
    public void requestPostFKUnBound(Observer<UnBind> observer, String token, Map<String, String> map) {
        RetrofitUtilsToken.getInstance(token).postUnFKBind(observer,map);
    }*/

    //我的考试(题类型 内含多选 单选等)
    @Override
    public void requestGetMultipleChoice(Observer<MultipleChoiceBean> observer, String token, int paperId) {
        RetrofitUtilsYuFeng.getInstance(token).getMultipleChoice(observer, paperId);
    }

    //我的考试(开始考试)
    @Override
    public void requestGetStartExam(Observer<StartExamBean> observer, String token, int paperId) {
        RetrofitUtilsYuFeng.getInstance(token).getStartExam(observer, paperId);
    }

    //新手七天
    @Override
    public void requestGetNewSchool(Observer<NewNoviceShoolBean> observer, String token) {
        RetrofitUtilsToken.getInstance(token).getNewShool(observer);
    }

    //考试完成后提交
    @Override
    public void requestSubmitExam(Observer<SubmitExamBean> observer, String token, Map<String, Object> map) {
        RetrofitUtilsYuFeng.getInstance(token).postStartExam(observer, map);
    }

    //修改密码
    @Override
    public void requestUpdatePwd(Observer<UpDatePwdBean> observer, String token, Map map) {
        RetrofitUtilsToken.getInstance(token).postUpdatePwd(observer, map);
    }

    //获取个人学习进度
    @Override
    public void requestPersonalExag(Observer<PersonalExamBean> observer, String token, int paperId) {
        RetrofitUtilsToken.getInstance(token).getPersonalExag(observer, paperId);
    }

    //人工审核线下考试
    @Override
    public void requestOfflineReview(Observer<OfflineReviewBean> observer, String token, Map<String, Object> map) {
        RetrofitUtilsToken.getInstance(token).postOfflineReview(observer, map);
    }

    //看完视频进度上传
    @Override
    public void requestProgressUpload(Observer<ProgressUploadBean> observer, String token, String trainScheduleStr) {
        RetrofitUtilsYuFeng.getInstance(token).postProgressUpload(observer, trainScheduleStr);
    }

    //每次请求课程详细界面查询进度
    @Override
    public void requestProgressQuery(Observer<ProgressQueryBean> observer, String token, Map<String, Object> map) {
        RetrofitUtilsYuFeng.getInstance(token).getProgressQuery(observer, map);
    }

    //考试状态查询
    @Override
    public void requestStatusQuery(Observer<StatusQueryBean> observer, String token, Map<String, Object> map) {
        RetrofitUtilsToken.getInstance(token).getStatusQuery(observer, map);
    }

    //学员查看绑定的训导员
    @Override
    public void requestTrainerName(Observer<TrainerNameBean> observer, String token) {
        RetrofitUtilsToken.getInstance(token).getTrainerName(observer);
    }

    //我的记录中的学习状态
    @Override
    public void requestStudyRecord(Observer<MyStudyRecordBean> observer, String token) {
        RetrofitUtilsYuFeng.getInstance(token).getStudyRecord(observer);
    }

    //我的记录中的问题反馈
    @Override
    public void requestFeedback(Observer<FeedbackBean> observer, String token, String suggestionStr) {
        RetrofitUtilsYuFeng.getInstance(token).getFeedback(observer, suggestionStr);
    }

    //登录界面忘记密码中发送手机验证码
    @Override
    public void requestVerificationCode(Observer<Response<GetVerificationCodeBean>> observer, String phoneNum) {
        RetrofitUtils.getInstance().postVerificationCode(observer, phoneNum);
    }

    //登录界面忘记密码中确定新密码
    @Override
    public void requestPasswordNew(Observer<ForgetPasswordNewBean> observer, String cookie, Map<String, Object> map) {
        RetrofitUtils.getInstance().posPasswordNew(observer, cookie, map);
    }

    //登录成功后判断手机是否绑定 返回0 跳转的绑定手机号页面
    @Override
    public void requestBindPhone(Observer<BindPhoneBean> observer, String token, String cookie, Map<String, Object> map) {
        RetrofitUtilsToken.getInstance(token).postBindPhone(observer, cookie, map);
    }

    //获取我的记录里个人历史记录
    @Override
    public void requestHistoryRecord(Observer<HistoryRecordBean> observer, String token, int paperId) {
        RetrofitUtilsToken.getInstance(token).getHistoryRecord(observer, paperId);
    }
}
