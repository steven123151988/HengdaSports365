package com.hengda.hengdasports.json2;

import java.util.List;

/**
 * Description:
 * Data：2018/5/15-16:37
 * steven
 */
public class BetMenuList  extends BaseModel {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : gq
         * alias : 滚球
         * num : 0
         * paly_method : [{"game":"r","alias":"赌赢/让球/大小"},{"game":"pd","alias":"波胆"},{"game":"hpd","alias":"半场波胆"},{"game":"t","alias":"总入球"},{"game":"f","alias":"半全场"}]
         */

        private String type;
        private String alias;
        private String num;
        private List<PalyMethodBean> paly_method;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public List<PalyMethodBean> getPaly_method() {
            return paly_method;
        }

        public void setPaly_method(List<PalyMethodBean> paly_method) {
            this.paly_method = paly_method;
        }

        public static class PalyMethodBean {
            /**
             * game : r
             * alias : 赌赢/让球/大小
             */

            private String game;
            private String alias;

            public String getGame() {
                return game;
            }

            public void setGame(String game) {
                this.game = game;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }
        }
    }
}
