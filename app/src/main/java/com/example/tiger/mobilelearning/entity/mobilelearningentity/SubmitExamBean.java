package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tiger on 2017/12/21.
 */

public class SubmitExamBean implements Parcelable {


    /**
     * data : {"scoreCount":40,"inTime":"3小时21分5秒","falseCount":2,"trueCount":1,"countNum":3}
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

    public static class DataBean implements Parcelable {
        /**
         * scoreCount : 40
         * inTime : 3小时21分5秒
         * falseCount : 2
         * trueCount : 1
         * countNum : 3
         */

        private int scoreCount;
        private String inTime;
        private int falseCount;
        private int trueCount;
        private int countNum;

        public int getScoreCount() {
            return scoreCount;
        }

        public void setScoreCount(int scoreCount) {
            this.scoreCount = scoreCount;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public int getFalseCount() {
            return falseCount;
        }

        public void setFalseCount(int falseCount) {
            this.falseCount = falseCount;
        }

        public int getTrueCount() {
            return trueCount;
        }

        public void setTrueCount(int trueCount) {
            this.trueCount = trueCount;
        }

        public int getCountNum() {
            return countNum;
        }

        public void setCountNum(int countNum) {
            this.countNum = countNum;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.scoreCount);
            dest.writeString(this.inTime);
            dest.writeInt(this.falseCount);
            dest.writeInt(this.trueCount);
            dest.writeInt(this.countNum);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.scoreCount = in.readInt();
            this.inTime = in.readString();
            this.falseCount = in.readInt();
            this.trueCount = in.readInt();
            this.countNum = in.readInt();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
        dest.writeString(this.resultMsg);
        dest.writeString(this.resultCode);
    }

    public SubmitExamBean() {
    }

    protected SubmitExamBean(Parcel in) {
        this.data = in.readParcelable(DataBean.class.getClassLoader());
        this.resultMsg = in.readString();
        this.resultCode = in.readString();
    }

    public static final Parcelable.Creator<SubmitExamBean> CREATOR = new Parcelable.Creator<SubmitExamBean>() {
        @Override
        public SubmitExamBean createFromParcel(Parcel source) {
            return new SubmitExamBean(source);
        }

        @Override
        public SubmitExamBean[] newArray(int size) {
            return new SubmitExamBean[size];
        }
    };
}
