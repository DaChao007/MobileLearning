package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import java.util.List;

/**
 * Created by Tiger on 2017/12/21.
 */

public class PersonalExamBean {


    /**
     * data : [{"courseId":67,"courseTitle":"第一天","coursePaperId":2,"examStatus":2,"chapterExm":[{"chapterId":53,"chapterTitle":"基础技能","chapterPaperId":null,"examStatus":3,"sourceExm":[{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]}]},{"courseId":68,"courseTitle":"第二天","coursePaperId":2,"examStatus":2,"chapterExm":[{"chapterId":54,"chapterTitle":"餐前","chapterPaperId":null,"examStatus":3,"sourceExm":[{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]}]},{"courseId":67,"courseTitle":"第一天","coursePaperId":2,"examStatus":2,"chapterExm":[{"chapterId":53,"chapterTitle":"基础技能","chapterPaperId":null,"examStatus":3,"sourceExm":[{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]}]},{"courseId":68,"courseTitle":"第二天","coursePaperId":2,"examStatus":2,"chapterExm":[{"chapterId":54,"chapterTitle":"餐前","chapterPaperId":null,"examStatus":3,"sourceExm":[{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]}]}]
     * resultMsg : 数据处理成功
     * resultCode : 0
     */

    private String resultMsg;
    private String resultCode;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * courseId : 67
         * courseTitle : 第一天
         * coursePaperId : 2
         * examStatus : 2
         * chapterExm : [{"chapterId":53,"chapterTitle":"基础技能","chapterPaperId":null,"examStatus":3,"sourceExm":[{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]}]
         */

        private int courseId;
        private String courseTitle;
        private int coursePaperId;
        private int examStatus;
        private List<ChapterExmBean> chapterExm;

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public int getCoursePaperId() {
            return coursePaperId;
        }

        public void setCoursePaperId(int coursePaperId) {
            this.coursePaperId = coursePaperId;
        }

        public int getExamStatus() {
            return examStatus;
        }

        public void setExamStatus(int examStatus) {
            this.examStatus = examStatus;
        }

        public List<ChapterExmBean> getChapterExm() {
            return chapterExm;
        }

        public void setChapterExm(List<ChapterExmBean> chapterExm) {
            this.chapterExm = chapterExm;
        }

        public static class ChapterExmBean {
            /**
             * chapterId : 53
             * chapterTitle : 基础技能
             * chapterPaperId : null
             * examStatus : 3
             * sourceExm : [{"sourceId":1,"sourceTitle":null,"sourcePaperId":1,"examStatus":2,"offlinePassed":3},{"sourceId":15,"sourceTitle":"基础技巧对应的文字内容","sourcePaperId":null,"examStatus":3,"offlinePassed":3},{"sourceId":18,"sourceTitle":"拜师仪式","sourcePaperId":null,"examStatus":3,"offlinePassed":3}]
             */

            private int chapterId;
            private String chapterTitle;
            private Object chapterPaperId;
            private int examStatus;
            private List<SourceExmBean> sourceExm;

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterTitle() {
                return chapterTitle;
            }

            public void setChapterTitle(String chapterTitle) {
                this.chapterTitle = chapterTitle;
            }

            public Object getChapterPaperId() {
                return chapterPaperId;
            }

            public void setChapterPaperId(Object chapterPaperId) {
                this.chapterPaperId = chapterPaperId;
            }

            public int getExamStatus() {
                return examStatus;
            }

            public void setExamStatus(int examStatus) {
                this.examStatus = examStatus;
            }

            public List<SourceExmBean> getSourceExm() {
                return sourceExm;
            }

            public void setSourceExm(List<SourceExmBean> sourceExm) {
                this.sourceExm = sourceExm;
            }

            public static class SourceExmBean {
                /**
                 * sourceId : 1
                 * sourceTitle : null
                 * sourcePaperId : 1
                 * examStatus : 2
                 * offlinePassed : 3
                 */

                private int sourceId;
                private String sourceTitle;
                private int sourcePaperId;
                private int examStatus;
                private int offlinePassed;

                public int getSourceId() {
                    return sourceId;
                }

                public void setSourceId(int sourceId) {
                    this.sourceId = sourceId;
                }

                public String getSourceTitle() {
                    return sourceTitle;
                }

                public void setSourceTitle(String sourceTitle) {
                    this.sourceTitle = sourceTitle;
                }

                public int getSourcePaperId() {
                    return sourcePaperId;
                }

                public void setSourcePaperId(int sourcePaperId) {
                    this.sourcePaperId = sourcePaperId;
                }

                public int getExamStatus() {
                    return examStatus;
                }

                public void setExamStatus(int examStatus) {
                    this.examStatus = examStatus;
                }

                public int getOfflinePassed() {
                    return offlinePassed;
                }

                public void setOfflinePassed(int offlinePassed) {
                    this.offlinePassed = offlinePassed;
                }
            }
        }
    }
}
