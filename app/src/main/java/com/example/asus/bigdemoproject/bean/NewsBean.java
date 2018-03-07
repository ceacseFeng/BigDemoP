package com.example.asus.bigdemoproject.bean;

import java.util.List;

/**
 * Created by ASUS on 2017/12/27.
 */

public class NewsBean {

    /**
     * uniquekey : 29680e8866b2a8ff44acb6ef56750d47
     * title : 涓婃捣鍦伴搧棣栨潯鑳惰疆璺建閾鸿瀹屾垚
     * date : 2017-06-13 16:03
     * category : 澶存潯
     * type : 0
     * author_name : 鏂板崕绀�
     * url : http://mini.eastday.com/mobile/170613160333931.html
     * pic : [{"thumbnail_pic":"http://04.imgmini.eastday.com/mobile/20170613/20170613160333_c07be6f5d9115a59011588018d7baabb_3_mwpm_03200403.jpeg"},{"thumbnail_pic":"http://04.imgmini.eastday.com/mobile/20170613/20170613160333_feaec68c0b2dc908738ef5a637f858e2_2_mwpm_03200403.jpeg"},{"thumbnail_pic":"http://04.imgmini.eastday.com/mobile/20170613/20170613160333_66da4dba16aa70c785134b7bec6a9e1b_1_mwpm_03200403.jpeg"}]
     */

    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private int type;
    private String author_name;
    private String url;
    private List<PicBean> pic;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    public static class PicBean {
        /**
         * thumbnail_pic : http://04.imgmini.eastday.com/mobile/20170613/20170613160333_c07be6f5d9115a59011588018d7baabb_3_mwpm_03200403.jpeg
         */

        private String thumbnail_pic;

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public void setThumbnail_pic(String thumbnail_pic) {
            this.thumbnail_pic = thumbnail_pic;
        }
    }
}
