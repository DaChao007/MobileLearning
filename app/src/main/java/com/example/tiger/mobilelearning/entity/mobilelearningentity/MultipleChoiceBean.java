package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Tiger on 2017/12/18.
 */

public class MultipleChoiceBean {

    /**
     * data : {"questions":[{"typeName":"N/A","id":1,"title":"散服伙伴为顾客点菜时，我们通常建议点菜数量为________(不含主食、小吃、饮品）。","score":"40","type":1,"options":[{"id":1,"title":"人数+1","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":2,"title":"人数+2","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":3,"title":"人数+3","questionId":1,"answerMark":1,"creatorId":1,"dateCreated":1513567825000,"lastUpdaterId":1,"lastUpdated":1513567825000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":4,"title":"人数+4","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567826000,"lastUpdaterId":1,"lastUpdated":1513567826000,"deleted":0,"status":0,"label":null,"indexKey":null}],"bankId":"1"},{"typeName":"N/A","id":2,"title":"西贝承诺（三代店）________分钟内上齐所有菜品","score":"60","type":1,"options":[{"id":38,"title":"20","questionId":2,"answerMark":0,"creatorId":1,"dateCreated":1513569706000,"lastUpdaterId":1,"lastUpdated":1513569706000,"deleted":0,"status":0,"label":"选项B","indexKey":null},{"id":39,"title":"25","questionId":2,"answerMark":1,"creatorId":1,"dateCreated":1513569716000,"lastUpdaterId":1,"lastUpdated":1513569716000,"deleted":0,"status":0,"label":"选项C","indexKey":null},{"id":40,"title":"30","questionId":2,"answerMark":0,"creatorId":1,"dateCreated":1513569744000,"lastUpdaterId":1,"lastUpdated":1513569744000,"deleted":0,"status":0,"label":"选项D","indexKey":null},{"id":41,"title":"35","questionId":2,"answerMark":1,"creatorId":1,"dateCreated":1513567819000,"lastUpdaterId":1,"lastUpdated":1513567819000,"deleted":0,"status":0,"label":null,"indexKey":null}],"bankId":"1"}],"paperRecordId":128}
     * resultCode : 0
     * resultMsg : 数据处理成功
     */

    private DataBean data;
    private String resultCode;
    private String resultMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * questions : [{"typeName":"N/A","id":1,"title":"散服伙伴为顾客点菜时，我们通常建议点菜数量为________(不含主食、小吃、饮品）。","score":"40","type":1,"options":[{"id":1,"title":"人数+1","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":2,"title":"人数+2","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":3,"title":"人数+3","questionId":1,"answerMark":1,"creatorId":1,"dateCreated":1513567825000,"lastUpdaterId":1,"lastUpdated":1513567825000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":4,"title":"人数+4","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567826000,"lastUpdaterId":1,"lastUpdated":1513567826000,"deleted":0,"status":0,"label":null,"indexKey":null}],"bankId":"1"},{"typeName":"N/A","id":2,"title":"西贝承诺（三代店）________分钟内上齐所有菜品","score":"60","type":1,"options":[{"id":38,"title":"20","questionId":2,"answerMark":0,"creatorId":1,"dateCreated":1513569706000,"lastUpdaterId":1,"lastUpdated":1513569706000,"deleted":0,"status":0,"label":"选项B","indexKey":null},{"id":39,"title":"25","questionId":2,"answerMark":1,"creatorId":1,"dateCreated":1513569716000,"lastUpdaterId":1,"lastUpdated":1513569716000,"deleted":0,"status":0,"label":"选项C","indexKey":null},{"id":40,"title":"30","questionId":2,"answerMark":0,"creatorId":1,"dateCreated":1513569744000,"lastUpdaterId":1,"lastUpdated":1513569744000,"deleted":0,"status":0,"label":"选项D","indexKey":null},{"id":41,"title":"35","questionId":2,"answerMark":1,"creatorId":1,"dateCreated":1513567819000,"lastUpdaterId":1,"lastUpdated":1513567819000,"deleted":0,"status":0,"label":null,"indexKey":null}],"bankId":"1"}]
         * paperRecordId : 128
         */

        private int paperRecordId;
        private List<QuestionsBean> questions;

        public int getPaperRecordId() {
            return paperRecordId;
        }

        public void setPaperRecordId(int paperRecordId) {
            this.paperRecordId = paperRecordId;
        }

        public List<QuestionsBean> getQuestions() {
            return questions;
        }

        public void setQuestions(List<QuestionsBean> questions) {
            this.questions = questions;
        }

        public static class QuestionsBean implements Parcelable {
            /**
             * typeName : N/A
             * id : 1
             * title : 散服伙伴为顾客点菜时，我们通常建议点菜数量为________(不含主食、小吃、饮品）。
             * score : 40
             * type : 1
             * options : [{"id":1,"title":"人数+1","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":2,"title":"人数+2","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567824000,"lastUpdaterId":1,"lastUpdated":1513567824000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":3,"title":"人数+3","questionId":1,"answerMark":1,"creatorId":1,"dateCreated":1513567825000,"lastUpdaterId":1,"lastUpdated":1513567825000,"deleted":0,"status":0,"label":null,"indexKey":null},{"id":4,"title":"人数+4","questionId":1,"answerMark":0,"creatorId":1,"dateCreated":1513567826000,"lastUpdaterId":1,"lastUpdated":1513567826000,"deleted":0,"status":0,"label":null,"indexKey":null}]
             * bankId : 1
             */

            private String typeName;
            private int id;
            private String title;
            private String score;
            private int type;
            private String bankId;
            private List<OptionsBean> options;

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

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

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getBankId() {
                return bankId;
            }

            public void setBankId(String bankId) {
                this.bankId = bankId;
            }

            public List<OptionsBean> getOptions() {
                return options;
            }

            public void setOptions(List<OptionsBean> options) {
                this.options = options;
            }

            public static class OptionsBean implements Parcelable {
                /**
                 * id : 1
                 * title : 人数+1
                 * questionId : 1
                 * answerMark : 0
                 * creatorId : 1
                 * dateCreated : 1513567824000
                 * lastUpdaterId : 1
                 * lastUpdated : 1513567824000
                 * deleted : 0
                 * status : 0
                 * label : null
                 * indexKey : null
                 */

                private int id;
                private String title;
                private int questionId;
                private int answerMark;
                private int creatorId;
                private long dateCreated;
                private int lastUpdaterId;
                private long lastUpdated;
                private int deleted;
                private int status;
                private Object label;
                private Object indexKey;

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

                public int getQuestionId() {
                    return questionId;
                }

                public void setQuestionId(int questionId) {
                    this.questionId = questionId;
                }

                public int getAnswerMark() {
                    return answerMark;
                }

                public void setAnswerMark(int answerMark) {
                    this.answerMark = answerMark;
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

                public int getDeleted() {
                    return deleted;
                }

                public void setDeleted(int deleted) {
                    this.deleted = deleted;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public Object getLabel() {
                    return label;
                }

                public void setLabel(Object label) {
                    this.label = label;
                }

                public Object getIndexKey() {
                    return indexKey;
                }

                public void setIndexKey(Object indexKey) {
                    this.indexKey = indexKey;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.id);
                    dest.writeString(this.title);
                    dest.writeInt(this.questionId);
                    dest.writeInt(this.answerMark);
                    dest.writeInt(this.creatorId);
                    dest.writeLong(this.dateCreated);
                    dest.writeInt(this.lastUpdaterId);
                    dest.writeLong(this.lastUpdated);
                    dest.writeInt(this.deleted);
                    dest.writeInt(this.status);
                }

                public OptionsBean() {
                }

                protected OptionsBean(Parcel in) {
                    this.id = in.readInt();
                    this.title = in.readString();
                    this.questionId = in.readInt();
                    this.answerMark = in.readInt();
                    this.creatorId = in.readInt();
                    this.dateCreated = in.readLong();
                    this.lastUpdaterId = in.readInt();
                    this.lastUpdated = in.readLong();
                    this.deleted = in.readInt();
                    this.status = in.readInt();
                    this.label = in.readParcelable(Object.class.getClassLoader());
                    this.indexKey = in.readParcelable(Object.class.getClassLoader());
                }

                public static final Parcelable.Creator<OptionsBean> CREATOR = new Parcelable.Creator<OptionsBean>() {
                    @Override
                    public OptionsBean createFromParcel(Parcel source) {
                        return new OptionsBean(source);
                    }

                    @Override
                    public OptionsBean[] newArray(int size) {
                        return new OptionsBean[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.typeName);
                dest.writeInt(this.id);
                dest.writeString(this.title);
                dest.writeString(this.score);
                dest.writeInt(this.type);
                dest.writeString(this.bankId);
                dest.writeTypedList(this.options);
            }

            public QuestionsBean() {
            }

            protected QuestionsBean(Parcel in) {
                this.typeName = in.readString();
                this.id = in.readInt();
                this.title = in.readString();
                this.score = in.readString();
                this.type = in.readInt();
                this.bankId = in.readString();
                this.options = in.createTypedArrayList(OptionsBean.CREATOR);
            }

            public static final Parcelable.Creator<QuestionsBean> CREATOR = new Parcelable.Creator<QuestionsBean>() {
                @Override
                public QuestionsBean createFromParcel(Parcel source) {
                    return new QuestionsBean(source);
                }

                @Override
                public QuestionsBean[] newArray(int size) {
                    return new QuestionsBean[size];
                }
            };
        }
    }
}
