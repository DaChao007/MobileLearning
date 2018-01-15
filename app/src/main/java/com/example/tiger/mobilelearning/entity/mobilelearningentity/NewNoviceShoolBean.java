package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiger on 2017/12/19.
 */

public class NewNoviceShoolBean {


    /**
     * data : {"planId":1,"courses":[{"id":67,"title":"第一天","type":0,"classId":67,"appScope":"-1","learnMode":0,"content":"","coverUrl":"","summary":"基础技能","auther":"基础技能","needExam":1,"published":0,"creatorId":0,"lastUpdaterId":2,"chapters":[{"id":57,"title":"章节1","courseId":67,"sortNum":1,"deleted":0,"chapterPaperId":null,"sources":[{"id":74,"chapterId":57,"sourceId":18,"sortNum":1,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2},{"id":68,"title":"第二天","type":1,"classId":1,"appScope":"-1","learnMode":0,"content":"","coverUrl":"","summary":"第二天","auther":"第二天","needExam":1,"published":1,"creatorId":2,"lastUpdaterId":2,"chapters":[{"id":54,"title":"餐前","courseId":68,"sortNum":2,"deleted":0,"chapterPaperId":null,"sources":[{"id":67,"chapterId":54,"sourceId":15,"sortNum":2,"deleted":0,"sourceType":1,"sourceTitle":"基础技巧对应的文字内容","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/19a7052cf2dbb5f850f7be16642c2ea6-05-基础技巧对应的文字内容.docx","sourceFileType":"05-基础技巧对应的文字内容.docx","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p>05-基础技巧对应的文字内容<\/p>","sourceOfflineExam":1},{"id":68,"chapterId":54,"sourceId":18,"sortNum":2,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2},{"id":70,"title":"第三天","type":1,"classId":1,"appScope":"-1","learnMode":0,"content":"<p>音频测试素材<\/p>","coverUrl":"","summary":"音频测试素材","auther":"音频测试素材","needExam":1,"published":1,"creatorId":2,"lastUpdaterId":2,"chapters":[{"id":56,"title":"章节1","courseId":70,"sortNum":2,"deleted":0,"chapterPaperId":null,"sources":[{"id":73,"chapterId":56,"sourceId":19,"sortNum":2,"deleted":0,"sourceType":3,"sourceTitle":"音频测试素材","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/6b53005bac1c1dd87da2c318a728b86f-大壮 - 我们不一样.mp3","sourceFileType":"大壮 - 我们不一样.mp3","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p>音频测试素材<\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2}]}
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
         * planId : 1
         * courses : [{"id":67,"title":"第一天","type":0,"classId":67,"appScope":"-1","learnMode":0,"content":"","coverUrl":"","summary":"基础技能","auther":"基础技能","needExam":1,"published":0,"creatorId":0,"lastUpdaterId":2,"chapters":[{"id":57,"title":"章节1","courseId":67,"sortNum":1,"deleted":0,"chapterPaperId":null,"sources":[{"id":74,"chapterId":57,"sourceId":18,"sortNum":1,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2},{"id":68,"title":"第二天","type":1,"classId":1,"appScope":"-1","learnMode":0,"content":"","coverUrl":"","summary":"第二天","auther":"第二天","needExam":1,"published":1,"creatorId":2,"lastUpdaterId":2,"chapters":[{"id":54,"title":"餐前","courseId":68,"sortNum":2,"deleted":0,"chapterPaperId":null,"sources":[{"id":67,"chapterId":54,"sourceId":15,"sortNum":2,"deleted":0,"sourceType":1,"sourceTitle":"基础技巧对应的文字内容","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/19a7052cf2dbb5f850f7be16642c2ea6-05-基础技巧对应的文字内容.docx","sourceFileType":"05-基础技巧对应的文字内容.docx","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p>05-基础技巧对应的文字内容<\/p>","sourceOfflineExam":1},{"id":68,"chapterId":54,"sourceId":18,"sortNum":2,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2},{"id":70,"title":"第三天","type":1,"classId":1,"appScope":"-1","learnMode":0,"content":"<p>音频测试素材<\/p>","coverUrl":"","summary":"音频测试素材","auther":"音频测试素材","needExam":1,"published":1,"creatorId":2,"lastUpdaterId":2,"chapters":[{"id":56,"title":"章节1","courseId":70,"sortNum":2,"deleted":0,"chapterPaperId":null,"sources":[{"id":73,"chapterId":56,"sourceId":19,"sortNum":2,"deleted":0,"sourceType":3,"sourceTitle":"音频测试素材","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/6b53005bac1c1dd87da2c318a728b86f-大壮 - 我们不一样.mp3","sourceFileType":"大壮 - 我们不一样.mp3","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p>音频测试素材<\/p>","sourceOfflineExam":0}]}],"courseFile":null,"coursePaperId":2}]
         */

        private int planId;
        private List<CoursesBean> courses;

        public int getPlanId() {
            return planId;
        }

        public void setPlanId(int planId) {
            this.planId = planId;
        }

        public List<CoursesBean> getCourses() {
            return courses;
        }

        public void setCourses(List<CoursesBean> courses) {
            this.courses = courses;
        }

        public static class CoursesBean implements Parcelable {
            /**
             * id : 67
             * title : 第一天
             * type : 0
             * classId : 67
             * appScope : -1
             * learnMode : 0
             * content :
             * coverUrl :
             * summary : 基础技能
             * auther : 基础技能
             * needExam : 1
             * published : 0
             * creatorId : 0
             * lastUpdaterId : 2
             * chapters : [{"id":57,"title":"章节1","courseId":67,"sortNum":1,"deleted":0,"chapterPaperId":null,"sources":[{"id":74,"chapterId":57,"sourceId":18,"sortNum":1,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]}]
             * courseFile : null
             * coursePaperId : 2
             */

            private int id;
            private String title;
            private int type;
            private int classId;
            private String appScope;
            private int learnMode;
            private String content;
            private String coverUrl;
            private String summary;
            private String auther;
            private int needExam;
            private int published;
            private int creatorId;
            private int lastUpdaterId;
            private String courseFile;
            private int coursePaperId;
            private List<ChaptersBean> chapters;

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getClassId() {
                return classId;
            }

            public void setClassId(int classId) {
                this.classId = classId;
            }

            public String getAppScope() {
                return appScope;
            }

            public void setAppScope(String appScope) {
                this.appScope = appScope;
            }

            public int getLearnMode() {
                return learnMode;
            }

            public void setLearnMode(int learnMode) {
                this.learnMode = learnMode;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public String getSummary() {
                return summary;
            }

            public void setSummary(String summary) {
                this.summary = summary;
            }

            public String getAuther() {
                return auther;
            }

            public void setAuther(String auther) {
                this.auther = auther;
            }

            public int getNeedExam() {
                return needExam;
            }

            public void setNeedExam(int needExam) {
                this.needExam = needExam;
            }

            public int getPublished() {
                return published;
            }

            public void setPublished(int published) {
                this.published = published;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public int getLastUpdaterId() {
                return lastUpdaterId;
            }

            public void setLastUpdaterId(int lastUpdaterId) {
                this.lastUpdaterId = lastUpdaterId;
            }

            public String getCourseFile() {
                return courseFile;
            }

            public void setCourseFile(String courseFile) {
                this.courseFile = courseFile;
            }

            public int getCoursePaperId() {
                return coursePaperId;
            }

            public void setCoursePaperId(int coursePaperId) {
                this.coursePaperId = coursePaperId;
            }

            public List<ChaptersBean> getChapters() {
                return chapters;
            }

            public void setChapters(List<ChaptersBean> chapters) {
                this.chapters = chapters;
            }

            public static class ChaptersBean implements Parcelable {
                /**
                 * id : 57
                 * title : 章节1
                 * courseId : 67
                 * sortNum : 1
                 * deleted : 0
                 * chapterPaperId : null
                 * sources : [{"id":74,"chapterId":57,"sourceId":18,"sortNum":1,"deleted":0,"sourceType":3,"sourceTitle":"拜师仪式","sourceRefLink":"https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4","sourceFileType":"参考视频-拜师仪式.mp4","sourcePaperId":2,"sourceDuration":null,"sourceCreator":"杨艳霞","sourceContent":"<p><span style=\"background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);\">拜师仪式<\/span><\/p>","sourceOfflineExam":0}]
                 */

                private int id;
                private String title;
                private int courseId;
                private int sortNum;
                private int deleted;
                private int chapterPaperId;
                private List<SourcesBean> sources;

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

                public int getCourseId() {
                    return courseId;
                }

                public void setCourseId(int courseId) {
                    this.courseId = courseId;
                }

                public int getSortNum() {
                    return sortNum;
                }

                public void setSortNum(int sortNum) {
                    this.sortNum = sortNum;
                }

                public int getDeleted() {
                    return deleted;
                }

                public void setDeleted(int deleted) {
                    this.deleted = deleted;
                }

                public int getChapterPaperId() {
                    return chapterPaperId;
                }

                public void setChapterPaperId(int chapterPaperId) {
                    this.chapterPaperId = chapterPaperId;
                }

                public List<SourcesBean> getSources() {
                    return sources;
                }

                public void setSources(List<SourcesBean> sources) {
                    this.sources = sources;
                }

                public static class SourcesBean implements Parcelable {
                    /**
                     * id : 74
                     * chapterId : 57
                     * sourceId : 18
                     * sortNum : 1
                     * deleted : 0
                     * sourceType : 3
                     * sourceTitle : 拜师仪式
                     * sourceRefLink : https://hrtop.oss-cn-qingdao.aliyuncs.com/71628f5a31f1fd22550687eb2f159226-参考视频-拜师仪式.mp4
                     * sourceFileType : 参考视频-拜师仪式.mp4
                     * sourcePaperId : 2
                     * sourceDuration : null
                     * sourceCreator : 杨艳霞
                     * sourceContent : <p><span style="background-color: rgb(245, 247, 250); color: rgb(90, 94, 102);">拜师仪式</span></p>
                     * sourceOfflineExam : 0
                     */

                    private int id;
                    private int chapterId;
                    private int sourceId;
                    private int sortNum;
                    private int deleted;
                    private int sourceType;
                    private String sourceTitle;
                    private String sourceRefLink;
                    private String sourceFileType;
                    private int sourcePaperId;
                    private int sourceDuration;
                    private String sourceCreator;
                    private String sourceContent;
                    private int sourceOfflineExam;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getChapterId() {
                        return chapterId;
                    }

                    public void setChapterId(int chapterId) {
                        this.chapterId = chapterId;
                    }

                    public int getSourceId() {
                        return sourceId;
                    }

                    public void setSourceId(int sourceId) {
                        this.sourceId = sourceId;
                    }

                    public int getSortNum() {
                        return sortNum;
                    }

                    public void setSortNum(int sortNum) {
                        this.sortNum = sortNum;
                    }

                    public int getDeleted() {
                        return deleted;
                    }

                    public void setDeleted(int deleted) {
                        this.deleted = deleted;
                    }

                    public int getSourceType() {
                        return sourceType;
                    }

                    public void setSourceType(int sourceType) {
                        this.sourceType = sourceType;
                    }

                    public String getSourceTitle() {
                        return sourceTitle;
                    }

                    public void setSourceTitle(String sourceTitle) {
                        this.sourceTitle = sourceTitle;
                    }

                    public String getSourceRefLink() {
                        return sourceRefLink;
                    }

                    public void setSourceRefLink(String sourceRefLink) {
                        this.sourceRefLink = sourceRefLink;
                    }

                    public String getSourceFileType() {
                        return sourceFileType;
                    }

                    public void setSourceFileType(String sourceFileType) {
                        this.sourceFileType = sourceFileType;
                    }

                    public int getSourcePaperId() {
                        return sourcePaperId;
                    }

                    public void setSourcePaperId(int sourcePaperId) {
                        this.sourcePaperId = sourcePaperId;
                    }

                    public int getSourceDuration() {
                        return sourceDuration;
                    }

                    public void setSourceDuration(int sourceDuration) {
                        this.sourceDuration = sourceDuration;
                    }

                    public String getSourceCreator() {
                        return sourceCreator;
                    }

                    public void setSourceCreator(String sourceCreator) {
                        this.sourceCreator = sourceCreator;
                    }

                    public String getSourceContent() {
                        return sourceContent;
                    }

                    public void setSourceContent(String sourceContent) {
                        this.sourceContent = sourceContent;
                    }

                    public int getSourceOfflineExam() {
                        return sourceOfflineExam;
                    }

                    public void setSourceOfflineExam(int sourceOfflineExam) {
                        this.sourceOfflineExam = sourceOfflineExam;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(this.id);
                        dest.writeInt(this.chapterId);
                        dest.writeInt(this.sourceId);
                        dest.writeInt(this.sortNum);
                        dest.writeInt(this.deleted);
                        dest.writeInt(this.sourceType);
                        dest.writeString(this.sourceTitle);
                        dest.writeString(this.sourceRefLink);
                        dest.writeString(this.sourceFileType);
                        dest.writeInt(this.sourcePaperId);
                        dest.writeInt(this.sourceDuration);
                        dest.writeString(this.sourceCreator);
                        dest.writeString(this.sourceContent);
                        dest.writeInt(this.sourceOfflineExam);
                    }

                    public SourcesBean() {
                    }

                    protected SourcesBean(Parcel in) {
                        this.id = in.readInt();
                        this.chapterId = in.readInt();
                        this.sourceId = in.readInt();
                        this.sortNum = in.readInt();
                        this.deleted = in.readInt();
                        this.sourceType = in.readInt();
                        this.sourceTitle = in.readString();
                        this.sourceRefLink = in.readString();
                        this.sourceFileType = in.readString();
                        this.sourcePaperId = in.readInt();
                        this.sourceDuration = in.readInt();
                        this.sourceCreator = in.readString();
                        this.sourceContent = in.readString();
                        this.sourceOfflineExam = in.readInt();
                    }

                    public static final Creator<SourcesBean> CREATOR = new Creator<SourcesBean>() {
                        @Override
                        public SourcesBean createFromParcel(Parcel source) {
                            return new SourcesBean(source);
                        }

                        @Override
                        public SourcesBean[] newArray(int size) {
                            return new SourcesBean[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.id);
                    dest.writeString(this.title);
                    dest.writeInt(this.courseId);
                    dest.writeInt(this.sortNum);
                    dest.writeInt(this.deleted);
                    dest.writeInt(this.chapterPaperId);
                    dest.writeList(this.sources);
                }

                public ChaptersBean() {
                }

                protected ChaptersBean(Parcel in) {
                    this.id = in.readInt();
                    this.title = in.readString();
                    this.courseId = in.readInt();
                    this.sortNum = in.readInt();
                    this.deleted = in.readInt();
                    this.chapterPaperId = in.readInt();
                    this.sources = new ArrayList<SourcesBean>();
                    in.readList(this.sources, SourcesBean.class.getClassLoader());
                }

                public static final Creator<ChaptersBean> CREATOR = new Creator<ChaptersBean>() {
                    @Override
                    public ChaptersBean createFromParcel(Parcel source) {
                        return new ChaptersBean(source);
                    }

                    @Override
                    public ChaptersBean[] newArray(int size) {
                        return new ChaptersBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.title);
                dest.writeInt(this.type);
                dest.writeInt(this.classId);
                dest.writeString(this.appScope);
                dest.writeInt(this.learnMode);
                dest.writeString(this.content);
                dest.writeString(this.coverUrl);
                dest.writeString(this.summary);
                dest.writeString(this.auther);
                dest.writeInt(this.needExam);
                dest.writeInt(this.published);
                dest.writeInt(this.creatorId);
                dest.writeInt(this.lastUpdaterId);
                dest.writeString(this.courseFile);
                dest.writeInt(this.coursePaperId);
                dest.writeList(this.chapters);
            }

            public CoursesBean() {
            }

            protected CoursesBean(Parcel in) {
                this.id = in.readInt();
                this.title = in.readString();
                this.type = in.readInt();
                this.classId = in.readInt();
                this.appScope = in.readString();
                this.learnMode = in.readInt();
                this.content = in.readString();
                this.coverUrl = in.readString();
                this.summary = in.readString();
                this.auther = in.readString();
                this.needExam = in.readInt();
                this.published = in.readInt();
                this.creatorId = in.readInt();
                this.lastUpdaterId = in.readInt();
                this.courseFile = in.readString();
                this.coursePaperId = in.readInt();
                this.chapters = new ArrayList<ChaptersBean>();
                in.readList(this.chapters, ChaptersBean.class.getClassLoader());
            }

            public static final Parcelable.Creator<CoursesBean> CREATOR = new Parcelable.Creator<CoursesBean>() {
                @Override
                public CoursesBean createFromParcel(Parcel source) {
                    return new CoursesBean(source);
                }

                @Override
                public CoursesBean[] newArray(int size) {
                    return new CoursesBean[size];
                }
            };
        }
    }
}
