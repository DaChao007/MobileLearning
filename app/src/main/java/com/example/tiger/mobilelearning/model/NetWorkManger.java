package com.example.tiger.mobilelearning.model;

/**
 * Created by Administrator on 2017/9/14.
 */

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

import io.reactivex.Observer;
import retrofit2.Response;

/**
 * 定义接口，方法写入参入观察者
 */
public interface NetWorkManger {

    //获取培训计划列表
    void requestGetTrainingProgram(Observer<TrainingProgramBean> observer, String token);

    //登录
    void requestPostLogin(Observer<LoginBean> observer, Map<String, String> map);

    //获取培训已绑定人员列表
    void requestPostBoundOk(Observer<BoundBean> observer, String token, Map<String, String> map);

    //获取培训未绑定人员列表
    void requestPostBoundNo(Observer<NotBoundBean> observer, String token, Map<String, String> map);

    //绑定人员(解绑或者绑定)
    void requestPostUnBound(Observer<UnBind> observer, String token, Map<String, String> map);

    //我的考试(题类型 内含多选 单选等)
    void requestGetMultipleChoice(Observer<MultipleChoiceBean> observer, String token, int paperId);

    //我的考试(开始考试)
    void requestGetStartExam(Observer<StartExamBean> observer, String token, int paperId);

    //新手七天请求
    void requestGetNewSchool(Observer<NewNoviceShoolBean> observer, String token);

    //考试完成后提交
    void requestSubmitExam(Observer<SubmitExamBean> observer, String token, Map<String, Object> map);

    //修改密码
    void requestUpdatePwd(Observer<UpDatePwdBean> observer, String token, Map map);

    //获取个人学习进度
    void requestPersonalExag(Observer<PersonalExamBean> observer, String token, int paperId);

    //人工审核线下考试
    void requestOfflineReview(Observer<OfflineReviewBean> observer, String token, Map<String, Object> map);

    //看完视频进度上传
    void requestProgressUpload(Observer<ProgressUploadBean> observer, String token, String trainScheduleStr);

    //每次请求课程详细界面查询进度
    void requestProgressQuery(Observer<ProgressQueryBean> observer, String token, Map<String, Object> map);

    //考试状态查询
    void requestStatusQuery(Observer<StatusQueryBean> observer, String token, Map<String, Object> map);

    //学员查看绑定的训导员
    void requestTrainerName(Observer<TrainerNameBean> observer, String token);

    //我的记录中的学习状态
    void requestStudyRecord(Observer<MyStudyRecordBean> observer, String token);

    //我的记录中的问题反馈
    void requestFeedback(Observer<FeedbackBean> observer, String token, String suggestionStr);

    //登录界面忘记密码中发送手机验证码
    void requestVerificationCode(Observer<Response<GetVerificationCodeBean>> observer, String phoneNum);

    //登录界面忘记密码中确定新密码
    void requestPasswordNew(Observer<ForgetPasswordNewBean> observer, String cookie, Map<String, Object> map);

    //登录成功后判断手机是否绑定 返回0 跳转的绑定手机号页面
    void requestBindPhone(Observer<BindPhoneBean> observer, String token, String cookie, Map<String, Object> map);

    //获取我的记录里个人历史记录
    void requestHistoryRecord(Observer<HistoryRecordBean> observer, String token, int paperId);
}
