package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/29.
 * 记录自己在线时长 累计课程 考试通过的bean类
 */

public class MyStudyRecordBean {


    /**
     * data : {"onlineDuring":0,"examPassed":0,"coursesCount":7}
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
        /**
         * onlineDuring : 0
         * examPassed : 0
         * coursesCount : 7
         */

        private int onlineDuring;
        private int examPassed;
        private int coursesCount;

        public int getOnlineDuring() {
            return onlineDuring;
        }

        public void setOnlineDuring(int onlineDuring) {
            this.onlineDuring = onlineDuring;
        }

        public int getExamPassed() {
            return examPassed;
        }

        public void setExamPassed(int examPassed) {
            this.examPassed = examPassed;
        }

        public int getCoursesCount() {
            return coursesCount;
        }

        public void setCoursesCount(int coursesCount) {
            this.coursesCount = coursesCount;
        }
    }
}
