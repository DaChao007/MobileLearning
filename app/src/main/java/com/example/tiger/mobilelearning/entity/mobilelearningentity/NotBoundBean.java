package com.example.tiger.mobilelearning.entity.mobilelearningentity;

import java.util.List;

/**
 * Created by Tiger on 2017/12/13.
 */

public class NotBoundBean {


    /**
     * data : [{"id":1,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"110400129","employeeName":"连方钞","employeeMobile":"12313","employeePosition":"初级员工","dateCreated":1513072855000,"lastUpdated":1513579956000,"lastEntryDate":"2011-04-14"},{"id":4,"orgId":2,"accountType":1,"statusCode":1,"statusDesc":"在职","employeeCode":"010400014","employeeName":"曲振国","employeeMobile":"12345","employeePosition":"初级员工","dateCreated":1513311167000,"lastUpdated":1513582625000,"lastEntryDate":"2001-04-01"}]
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
         * employeeCode : 110400129
         * employeeName : 连方钞
         * employeeMobile : 12313
         * employeePosition : 初级员工
         * dateCreated : 1513072855000
         * lastUpdated : 1513579956000
         * lastEntryDate : 2011-04-14
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
