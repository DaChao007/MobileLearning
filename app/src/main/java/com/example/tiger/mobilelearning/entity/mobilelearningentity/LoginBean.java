package com.example.tiger.mobilelearning.entity.mobilelearningentity;

/**
 * Created by Tiger on 2017/12/13.
 */

public class LoginBean {


    /**
     * resultCode : 0
     * data : {"uid":12491,"eid":45522,"ucode":"130200029","uname":"王召弟","pname":"初级员工","gender":"女","orgId":2,"orgName":"北京六里桥店","token":"8e8bd4597b13d24458c32de733e408b6","expireTime":"2018-01-13 22:29","phone":"18518302090","loggedOn":1}
     * resultMsg : 数据处理成功
     */

    private String resultCode;
    private DataBean data;
    private String resultMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

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

    public static class DataBean {
        /**
         * uid : 12491
         * eid : 45522
         * ucode : 130200029
         * uname : 王召弟
         * pname : 初级员工
         * gender : 女
         * orgId : 2
         * orgName : 北京六里桥店
         * token : 8e8bd4597b13d24458c32de733e408b6
         * expireTime : 2018-01-13 22:29
         * phone : 18518302090
         * loggedOn : 1
         */

        private int uid;
        private int eid;
        private String ucode;
        private String uname;
        private String pname;
        private String gender;
        private int orgId;
        private String orgName;
        private String token;
        private String expireTime;
        private String phone;
        private int loggedOn;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public String getUcode() {
            return ucode;
        }

        public void setUcode(String ucode) {
            this.ucode = ucode;
        }

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public String getPname() {
            return pname;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getExpireTime() {
            return expireTime;
        }

        public void setExpireTime(String expireTime) {
            this.expireTime = expireTime;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getLoggedOn() {
            return loggedOn;
        }

        public void setLoggedOn(int loggedOn) {
            this.loggedOn = loggedOn;
        }
    }
}
