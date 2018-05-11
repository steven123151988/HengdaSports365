package com.hengda.hengdasports.json2;

import com.hengda.hengdasports.json2.BaseModel;

/**
 * Description:获取当前用户详情
 * Data：2018/4/14-17:40
 * steven
 */
public class getUserInfo extends BaseModel {


    /**
     * data : {"ID":"153017","UserName":"qqq111","Alias":"","ptopen":"0","md5psw":"5abd06d6f6ef0e022e11b8a41f57ebda","Money":"0"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ID : 153017
         * UserName : qqq111
         * Alias :
         * ptopen : 0
         * md5psw : 5abd06d6f6ef0e022e11b8a41f57ebda
         * Money : 0
         */

        private String ID;
        private String UserName;
        private String Alias;
        private String ptopen;
        private String md5psw;
        private String Money;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public String getPtopen() {
            return ptopen;
        }

        public void setPtopen(String ptopen) {
            this.ptopen = ptopen;
        }

        public String getMd5psw() {
            return md5psw;
        }

        public void setMd5psw(String md5psw) {
            this.md5psw = md5psw;
        }

        public String getMoney() {
            return Money;
        }

        public void setMoney(String Money) {
            this.Money = Money;
        }
    }
}
