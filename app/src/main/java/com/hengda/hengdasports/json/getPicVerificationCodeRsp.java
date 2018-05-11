package com.hengda.hengdasports.json;

import com.hengda.hengdasports.json2.BaseModel;

/**
 * Description:
 * Data：2018/4/13-17:04
 * steven
 */
public class getPicVerificationCodeRsp extends BaseModel {


    /**
     * data : {"src":"http://118.184.29.2:8080/member/register/generate_captcha"}
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
         * src : http://118.184.29.2:8080/member/register/generate_captcha
         */

        private String src;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}
