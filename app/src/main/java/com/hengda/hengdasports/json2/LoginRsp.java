package com.hengda.hengdasports.json2;


public class LoginRsp extends BaseModel {
    /**
     * data : {"uid":"6cc39f9c1b236621347era2"}
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
         * uid : 6cc39f9c1b236621347era2
         */

        private String uid;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }


    /**
     * code : 0
     * msg : 尊敬的会员们，本公司因业务需要，暂时停止使用工商银行(朱文香)(王银)农业银行(潘小芳)(杜小琴)，请联系客服查看最新存款账户！
     * ifo : 46f1ddeb482b829ec14bra7
     */


}
