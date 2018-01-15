package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/25.
 */

public class StatusQueryBean {


    /**
     * data : {"permission":true}
     * resultMsg : 数据处理成功
     * resultCode : 0
     */

    private DataBean data;
    private String resultMsg;
    private String resultCode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StatusQueryBean{" +
                "data=" + data +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }

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

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "permission=" + permission +
                    '}';
        }

        /**
         * permission : true
         */

        private boolean permission;

        public boolean isPermission() {
            return permission;
        }

        public void setPermission(boolean permission) {
            this.permission = permission;
        }
    }
}
