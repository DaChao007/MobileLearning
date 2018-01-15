package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import java.util.List;

/**
 * Created by Tiger on 2017/12/13.
 */

public class BoundBean {


    /**
     * data : [{"id":1,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"161000650","employeeName":"连方钞","employeeMobile":"12313","employeePosition":"初级员工","dateCreated":1513072855000,"lastUpdated":1513865309000,"lastEntryDate":"2016-10-03"},{"id":4,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"010400014","employeeName":"曲振国","employeeMobile":"12345","employeePosition":"初级员工","dateCreated":1513311167000,"lastUpdated":1513839702000,"lastEntryDate":null},{"id":12245,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"000900010","employeeName":"牛红燕","employeeMobile":"13161375034","employeePosition":"初级员工","dateCreated":1513839600000,"lastUpdated":1513839919000,"lastEntryDate":null},{"id":12248,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"030600015","employeeName":"赵凯杰","employeeMobile":"13126561586","employeePosition":"初级员工","dateCreated":1513839600000,"lastUpdated":1513839919000,"lastEntryDate":null},{"id":12250,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"030100024","employeeName":"陈秀荣","employeeMobile":"15210057397","employeePosition":"初级员工","dateCreated":1513839600000,"lastUpdated":1513839919000,"lastEntryDate":null},{"id":12251,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"090900309","employeeName":"刘难楠","employeeMobile":"18211073086","employeePosition":"初级员工","dateCreated":1513839600000,"lastUpdated":1513839919000,"lastEntryDate":null},{"id":12257,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"130300563","employeeName":"韩东明","employeeMobile":"18810283227","employeePosition":"初级员工","dateCreated":1513839600000,"lastUpdated":1513839919000,"lastEntryDate":null},{"id":12485,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"admin","employeeName":"admin","employeeMobile":"","employeePosition":"初级员工","dateCreated":1513839604000,"lastUpdated":1513839874000,"lastEntryDate":null},{"id":12486,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"1000","employeeName":"10000","employeeMobile":"","employeePosition":"初级员工","dateCreated":1513839604000,"lastUpdated":1513839874000,"lastEntryDate":null}]
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
         * id : 1
         * orgId : 2
         * accountType : 1
         * statusCode : 1
         * statusDesc : 在职
         * employeeCode : 161000650
         * employeeName : 连方钞
         * employeeMobile : 12313
         * employeePosition : 初级员工
         * dateCreated : 1513072855000
         * lastUpdated : 1513865309000
         * lastEntryDate : 2016-10-03
         */

        private int id;
        private int orgId;
        private int accountType;
        private int statusCode;
        private String statusDesc;
        private String employeeCode;
        private String employeeName;
        private String employeeMobile;
        private String employeePosition;
        private long dateCreated;
        private long lastUpdated;
        private String lastEntryDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOrgId() {
            return orgId;
        }

        public void setOrgId(int orgId) {
            this.orgId = orgId;
        }

        public int getAccountType() {
            return accountType;
        }

        public void setAccountType(int accountType) {
            this.accountType = accountType;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
        }

        public String getEmployeeCode() {
            return employeeCode;
        }

        public void setEmployeeCode(String employeeCode) {
            this.employeeCode = employeeCode;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeMobile() {
            return employeeMobile;
        }

        public void setEmployeeMobile(String employeeMobile) {
            this.employeeMobile = employeeMobile;
        }

        public String getEmployeePosition() {
            return employeePosition;
        }

        public void setEmployeePosition(String employeePosition) {
            this.employeePosition = employeePosition;
        }

        public long getDateCreated() {
            return dateCreated;
        }

        public void setDateCreated(long dateCreated) {
            this.dateCreated = dateCreated;
        }

        public long getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(long lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public String getLastEntryDate() {
            return lastEntryDate;
        }

        public void setLastEntryDate(String lastEntryDate) {
            this.lastEntryDate = lastEntryDate;
        }
    }
}
