package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/22.
 */

public class ProgressQueryBean {


    @Override
    public String toString() {
        return "ProgressQueryBean{" +
                "data=" + data +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultCode='" + resultCode + '\'' +
                '}';
    }

    /**
     * data : {"id":275,"trainPlanId":"1","trainPlanName":"新手七天散服","courseId":"5","courseName":"第5天","chapterId":7,"chapterName":"工作站","sourceId":49,"sourceName":"05-工作站soc","userId":12544,"viewProgress":"0","finished":0,"startTime":1514518378000,"endTime":1514518378000}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", trainPlanId='" + trainPlanId + '\'' +
                    ", trainPlanName='" + trainPlanName + '\'' +
                    ", courseId='" + courseId + '\'' +
                    ", courseName='" + courseName + '\'' +
                    ", chapterId=" + chapterId +
                    ", chapterName='" + chapterName + '\'' +
                    ", sourceId=" + sourceId +
                    ", sourceName='" + sourceName + '\'' +
                    ", userId=" + userId +
                    ", viewProgress='" + viewProgress + '\'' +
                    ", finished=" + finished +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        /**
         * id : 275
         * trainPlanId : 1
         * trainPlanName : 新手七天散服
         * courseId : 5
         * courseName : 第5天
         * chapterId : 7
         * chapterName : 工作站
         * sourceId : 49
         * sourceName : 05-工作站soc
         * userId : 12544
         * viewProgress : 0
         * finished : 0
         * startTime : 1514518378000
         * endTime : 1514518378000
         */

        private int id;
        private String trainPlanId;
        private String trainPlanName;
        private String courseId;
        private String courseName;
        private int chapterId;
        private String chapterName;
        private int sourceId;
        private String sourceName;
        private int userId;
        private String viewProgress;
        private int finished;
        private long startTime;
        private long endTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTrainPlanId() {
            return trainPlanId;
        }

        public void setTrainPlanId(String trainPlanId) {
            this.trainPlanId = trainPlanId;
        }

        public String getTrainPlanName() {
            return trainPlanName;
        }

        public void setTrainPlanName(String trainPlanName) {
            this.trainPlanName = trainPlanName;
        }

        public String getCourseId() {
            return courseId;
        }

        public void setCourseId(String courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getSourceId() {
            return sourceId;
        }

        public void setSourceId(int sourceId) {
            this.sourceId = sourceId;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getViewProgress() {
            return viewProgress;
        }

        public void setViewProgress(String viewProgress) {
            this.viewProgress = viewProgress;
        }

        public int getFinished() {
            return finished;
        }

        public void setFinished(int finished) {
            this.finished = finished;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }
    }
}
