package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/29.
 * 问题反馈的Bean
 */

public class FeedbackBean {

    /**
     * data : {"id":1,"type":3,"content":"问题反馈内容","adviserId":12544,"adviserName":"崔晓明","dateCreated":1514541957356,"answerContent":null,"answerId":null,"answerName":null,"answerDate":null,"phoneOrEmail":"12112121"}
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

    @Override
    public String toString() {
        return "FeedbackBean{" +
                "data=" + data +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }

    public static class DataBean {
        /**
         * id : 1
         * type : 3
         * content : 问题反馈内容
         * adviserId : 12544
         * adviserName : 崔晓明
         * dateCreated : 1514541957356
         * answerContent : null
         * answerId : null
         * answerName : null
         * answerDate : null
         * phoneOrEmail : 12112121
         */

        private int id;
        private int type;
        private String content;
        private int adviserId;
        private String adviserName;
        private long dateCreated;
        private Object answerContent;
        private Object answerId;
        private Object answerName;
        private Object answerDate;
        private String phoneOrEmail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getAdviserId() {
            return adviserId;
        }

        public void setAdviserId(int adviserId) {
            this.adviserId = adviserId;
        }

        public String getAdviserName() {
            return adviserName;
        }

        public void setAdviserName(String adviserName) {
            this.adviserName = adviserName;
        }

        public long getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(long dateCreated) {
            this.dateCreated = dateCreated;
        }

        public Object getAnswerContent() {
            return answerContent;
        }

        public void setAnswerContent(Object answerContent) {
            this.answerContent = answerContent;
        }

        public Object getAnswerId() {
            return answerId;
        }

        public void setAnswerId(Object answerId) {
            this.answerId = answerId;
        }

        public Object getAnswerName() {
            return answerName;
        }

        public void setAnswerName(Object answerName) {
            this.answerName = answerName;
        }

        public Object getAnswerDate() {
            return answerDate;
        }

        public void setAnswerDate(Object answerDate) {
            this.answerDate = answerDate;
        }

        public String getPhoneOrEmail() {
            return phoneOrEmail;
        }

        public void setPhoneOrEmail(String phoneOrEmail) {
            this.phoneOrEmail = phoneOrEmail;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", type=" + type +
                    ", content='" + content + '\'' +
                    ", adviserId=" + adviserId +
                    ", adviserName='" + adviserName + '\'' +
                    ", dateCreated=" + dateCreated +
                    ", answerContent=" + answerContent +
                    ", answerId=" + answerId +
                    ", answerName=" + answerName +
                    ", answerDate=" + answerDate +
                    ", phoneOrEmail='" + phoneOrEmail + '\'' +
                    '}';
        }
    }
}
