package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2018/1/6.
 * 获取验证码
 */

public class GetVerificationCodeBean {

    @Override
    public String toString() {
        return "GetVerificationCodeBean{" +
                "resultMsg='" + resultMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }

    /**
     * resultMsg : 数据处理成功
     * resultCode : 0
     */

    private String resultMsg;
    private String resultCode;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
}
