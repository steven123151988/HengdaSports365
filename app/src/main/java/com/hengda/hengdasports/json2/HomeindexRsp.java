package com.hengda.hengdasports.json2;

import java.util.List;

/**
 * Description:
 * Data：2018/5/8-14:53
 * steven
 */
public class HomeindexRsp extends BaseModel {


    /**
     * data : {"notice":"欢迎光临-敬请注意!!如有会员利用非法程式下注,所下注注单将被注销！","member":null,"slide":[{"img":"http://192.168.254.108/Public/images/ad1.jpg","url":"http://192.168.254.108/index.php/Help/promotion11?act=app"},{"img":"http://192.168.254.108/Public/images/ad2.jpg","url":"http://192.168.254.108/index.php/Help/promotion31?act=app"},{"img":"http://192.168.254.108/Public/images/ad3.jpg","url":"http://192.168.254.108/index.php/Help/promotion32?act=app"}],"ft_nums":0,"bk_nums":0}
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
         * notice : 欢迎光临-敬请注意!!如有会员利用非法程式下注,所下注注单将被注销！
         * member : null
         * slide : [{"img":"http://192.168.254.108/Public/images/ad1.jpg","url":"http://192.168.254.108/index.php/Help/promotion11?act=app"},{"img":"http://192.168.254.108/Public/images/ad2.jpg","url":"http://192.168.254.108/index.php/Help/promotion31?act=app"},{"img":"http://192.168.254.108/Public/images/ad3.jpg","url":"http://192.168.254.108/index.php/Help/promotion32?act=app"}]
         * ft_nums : 0
         * bk_nums : 0
         */

        private String notice;
        private Object member;
        private int ft_nums;
        private int bk_nums;
        private List<SlideBean> slide;

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public Object getMember() {
            return member;
        }

        public void setMember(Object member) {
            this.member = member;
        }

        public int getFt_nums() {
            return ft_nums;
        }

        public void setFt_nums(int ft_nums) {
            this.ft_nums = ft_nums;
        }

        public int getBk_nums() {
            return bk_nums;
        }

        public void setBk_nums(int bk_nums) {
            this.bk_nums = bk_nums;
        }

        public List<SlideBean> getSlide() {
            return slide;
        }

        public void setSlide(List<SlideBean> slide) {
            this.slide = slide;
        }

        public static class SlideBean {
            /**
             * img : http://192.168.254.108/Public/images/ad1.jpg
             * url : http://192.168.254.108/index.php/Help/promotion11?act=app
             */

            private String img;
            private String url;

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
