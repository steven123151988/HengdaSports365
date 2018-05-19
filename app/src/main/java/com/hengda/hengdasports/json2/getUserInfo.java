package com.hengda.hengdasports.json2;

/**
 * Description:获取当前用户详情
 * Data：2018/4/14-17:40
 * steven
 */
public class getUserInfo extends BaseModel {


    /**
     * data : {"ID":"153017","uid":"4d155363dc5abd06d6f6ra8","UserName":"qqq111","LoginName":"qqq111","Language":"zh-cn","Alias":"","LoginDate":"2018-05-19","LoginTime":"2018-05-19 04:52:30","OnlineTime":"2018-05-19 04:52:30","LoginIP":"110.54.250.139","Url":"http://118.184.29.2/"}
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
         * uid : 4d155363dc5abd06d6f6ra8
         * UserName : qqq111
         * LoginName : qqq111
         * Language : zh-cn
         * Alias :
         * LoginDate : 2018-05-19
         * LoginTime : 2018-05-19 04:52:30
         * OnlineTime : 2018-05-19 04:52:30
         * LoginIP : 110.54.250.139
         * Url : http://118.184.29.2/
         */

        private String ID;
        private String uid;
        private String UserName;
        private String LoginName;
        private String Language;
        private String Alias;
        private String LoginDate;
        private String LoginTime;
        private String OnlineTime;
        private String LoginIP;
        private String Url;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getLoginName() {
            return LoginName;
        }

        public void setLoginName(String LoginName) {
            this.LoginName = LoginName;
        }

        public String getLanguage() {
            return Language;
        }

        public void setLanguage(String Language) {
            this.Language = Language;
        }

        public String getAlias() {
            return Alias;
        }

        public void setAlias(String Alias) {
            this.Alias = Alias;
        }

        public String getLoginDate() {
            return LoginDate;
        }

        public void setLoginDate(String LoginDate) {
            this.LoginDate = LoginDate;
        }

        public String getLoginTime() {
            return LoginTime;
        }

        public void setLoginTime(String LoginTime) {
            this.LoginTime = LoginTime;
        }

        public String getOnlineTime() {
            return OnlineTime;
        }

        public void setOnlineTime(String OnlineTime) {
            this.OnlineTime = OnlineTime;
        }

        public String getLoginIP() {
            return LoginIP;
        }

        public void setLoginIP(String LoginIP) {
            this.LoginIP = LoginIP;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }
    }
}
