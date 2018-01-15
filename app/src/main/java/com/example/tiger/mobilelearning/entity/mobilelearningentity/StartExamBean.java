package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/18.
 */

public class StartExamBean {


    /**
     * data : {"paper":{"id":1,"title":"测试","categoryId":2,"type":1,"rule":null,"examMode":1,"score":100,"passScore":60,"status":null,"timLimit":90,"creatorId":1,"dateCreated":1513771261000,"lastUpdaterId":1,"lastUpdated":1513842436000},"getcountPaperId":3}
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
         * paper : {"id":1,"title":"测试","categoryId":2,"type":1,"rule":null,"examMode":1,"score":100,"passScore":60,"status":null,"timLimit":90,"creatorId":1,"dateCreated":1513771261000,"lastUpdaterId":1,"lastUpdated":1513842436000}
         * getcountPaperId : 3
         */

        private PaperBean paper;
        private int getcountPaperId;

        public PaperBean getPaper() {
            return paper;
        }

        public void setPaper(PaperBean paper) {
            this.paper = paper;
        }

        public int getGetcountPaperId() {
            return getcountPaperId;
        }

        public void setGetcountPaperId(int getcountPaperId) {
            this.getcountPaperId = getcountPaperId;
        }

        public static class PaperBean {
            /**
             * id : 1
             * title : 测试
             * categoryId : 2
             * type : 1
             * rule : null
             * examMode : 1
             * score : 100
             * passScore : 60
             * status : null
             * timLimit : 90
             * creatorId : 1
             * dateCreated : 1513771261000
             * lastUpdaterId : 1
             * lastUpdated : 1513842436000
             */

            private int id;
            private String title;
            private int categoryId;
            private int type;
            private Object rule;
            private int examMode;
            private int score;
            private int passScore;
            private Object status;
            private int timLimit;
            private int creatorId;
            private long dateCreated;
            private int lastUpdaterId;
            private long lastUpdated;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getRule() {
                return rule;
            }

            public void setRule(Object rule) {
                this.rule = rule;
            }

            public int getExamMode() {
                return examMode;
            }

            public void setExamMode(int examMode) {
                this.examMode = examMode;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getPassScore() {
                return passScore;
            }

            public void setPassScore(int passScore) {
                this.passScore = passScore;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public int getTimLimit() {
                return timLimit;
            }

            public void setTimLimit(int timLimit) {
                this.timLimit = timLimit;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public long getDateCreated() {
                return dateCreated;
            }

            public void setDateCreated(long dateCreated) {
                this.dateCreated = dateCreated;
            }

            public int getLastUpdaterId() {
                return lastUpdaterId;
            }

            public void setLastUpdaterId(int lastUpdaterId) {
                this.lastUpdaterId = lastUpdaterId;
            }

            public long getLastUpdated() {
                return lastUpdated;
            }

            public void setLastUpdated(long lastUpdated) {
                this.lastUpdated = lastUpdated;
            }
        }
    }
}
