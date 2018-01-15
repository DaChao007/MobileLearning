package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import java.util.List;

/**
 * Created by Tiger on 2017/12/13.
 * 培训计划列表的bean
 */

public class TrainingProgramBean {


    /**
     * data : [{"courses":[{"courseId":1,"creatorId":0,"dateCreated":1513236971000,"deleted":0,"id":1,"lastUpdated":1513236976000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":1,"trainPlanId":1},{"courseId":1,"creatorId":0,"dateCreated":1513237267000,"deleted":0,"id":2,"lastUpdated":1513237269000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":2,"trainPlanId":1},{"courseId":1,"creatorId":0,"dateCreated":1513237281000,"deleted":0,"id":3,"lastUpdated":1513237305000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":3,"trainPlanId":1}],"creatorId":0,"dateCreated":1513066986000,"deleted":0,"frontTrainId":0,"id":1,"lastUpdated":1513169272000,"lastUpdaterId":0,"scope":"初级员工,星级员工","status":0,"title":"新手7天(散服)","trainMode":0},{"creatorId":0,"dateCreated":1513067445000,"deleted":0,"frontTrainId":0,"id":2,"lastUpdated":1513169272000,"lastUpdaterId":0,"scope":"初级员工,星级员工","status":0,"title":"新手7天(传菜撤菜)","trainMode":0}]
     * resultCode : 0
     * resultMsg : 数据处理成功
     */

    private String resultCode;
    private String resultMsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * courses : [{"courseId":1,"creatorId":0,"dateCreated":1513236971000,"deleted":0,"id":1,"lastUpdated":1513236976000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":1,"trainPlanId":1},{"courseId":1,"creatorId":0,"dateCreated":1513237267000,"deleted":0,"id":2,"lastUpdated":1513237269000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":2,"trainPlanId":1},{"courseId":1,"creatorId":0,"dateCreated":1513237281000,"deleted":0,"id":3,"lastUpdated":1513237305000,"lastUpdaterId":0,"name":"课程标题1 修改后","sortNum":3,"trainPlanId":1}]
         * creatorId : 0
         * dateCreated : 1513066986000
         * deleted : 0
         * frontTrainId : 0
         * id : 1
         * lastUpdated : 1513169272000
         * lastUpdaterId : 0
         * scope : 初级员工,星级员工
         * status : 0
         * title : 新手7天(散服)
         * trainMode : 0
         */

        private int creatorId;
        private long dateCreated;
        private int deleted;
        private int frontTrainId;
        private int id;
        private long lastUpdated;
        private int lastUpdaterId;
        private String scope;
        private int status;
        private String title;
        private int trainMode;
        private List<CoursesBean> courses;

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

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int getFrontTrainId() {
            return frontTrainId;
        }

        public void setFrontTrainId(int frontTrainId) {
            this.frontTrainId = frontTrainId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(long lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public int getLastUpdaterId() {
            return lastUpdaterId;
        }

        public void setLastUpdaterId(int lastUpdaterId) {
            this.lastUpdaterId = lastUpdaterId;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTrainMode() {
            return trainMode;
        }

        public void setTrainMode(int trainMode) {
            this.trainMode = trainMode;
        }

        public List<CoursesBean> getCourses() {
            return courses;
        }

        public void setCourses(List<CoursesBean> courses) {
            this.courses = courses;
        }

        public static class CoursesBean {
            /**
             * courseId : 1
             * creatorId : 0
             * dateCreated : 1513236971000
             * deleted : 0
             * id : 1
             * lastUpdated : 1513236976000
             * lastUpdaterId : 0
             * name : 课程标题1 修改后
             * sortNum : 1
             * trainPlanId : 1
             */

            private int courseId;
            private int creatorId;
            private long dateCreated;
            private int deleted;
            private int id;
            private long lastUpdated;
            private int lastUpdaterId;
            private String name;
            private int sortNum;
            private int trainPlanId;

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
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

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getLastUpdated() {
                return lastUpdated;
            }

            public void setLastUpdated(long lastUpdated) {
                this.lastUpdated = lastUpdated;
            }

            public int getLastUpdaterId() {
                return lastUpdaterId;
            }

            public void setLastUpdaterId(int lastUpdaterId) {
                this.lastUpdaterId = lastUpdaterId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSortNum() {
                return sortNum;
            }

            public void setSortNum(int sortNum) {
                this.sortNum = sortNum;
            }

            public int getTrainPlanId() {
                return trainPlanId;
            }

            public void setTrainPlanId(int trainPlanId) {
                this.trainPlanId = trainPlanId;
            }
        }
    }
}
