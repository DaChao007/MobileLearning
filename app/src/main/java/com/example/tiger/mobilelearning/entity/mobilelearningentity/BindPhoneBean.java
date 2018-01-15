package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2018/1/8.
 */

public class BindPhoneBean {


    @Override
    public String toString() {
        return "BindPhoneBean{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                '}';
    }

    /**
     * resultCode : 0
     * resultMsg : 数据处理成功
     */

    private String resultCode;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
