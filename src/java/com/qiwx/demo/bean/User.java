package com.qiwx.demo.bean;

public class User {

    /**
     * id : e7e04614d531537c35518d404e3e583d
     * url_token : qiwx2012
     * name : qiwx2012
     * use_default_avatar : true
     * avatar_url : https://pic4.zhimg.com/da8e974dc_is.jpg
     * avatar_url_template : https://pic4.zhimg.com/da8e974dc_{size}.jpg
     * is_org : false
     * type : people
     * url : https://www.zhihu.com/people/qiwx2012
     * user_type : people
     * headline :
     * gender : 1
     * is_advertiser : false
     * vip_info : {"is_vip":false,"rename_days":"60"}
     */

    private String id;
    private String url_token;
    private String name;
    private boolean use_default_avatar;
    private String avatar_url;
    private String avatar_url_template;
    private boolean is_org;
    private String type;
    private String url;
    private String user_type;
    private String headline;
    private int gender;
    private boolean is_advertiser;
    private VipInfoBean vip_info;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl_token() {
        return url_token;
    }

    public void setUrl_token(String url_token) {
        this.url_token = url_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUse_default_avatar() {
        return use_default_avatar;
    }

    public void setUse_default_avatar(boolean use_default_avatar) {
        this.use_default_avatar = use_default_avatar;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAvatar_url_template() {
        return avatar_url_template;
    }

    public void setAvatar_url_template(String avatar_url_template) {
        this.avatar_url_template = avatar_url_template;
    }

    public boolean isIs_org() {
        return is_org;
    }

    public void setIs_org(boolean is_org) {
        this.is_org = is_org;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isIs_advertiser() {
        return is_advertiser;
    }

    public void setIs_advertiser(boolean is_advertiser) {
        this.is_advertiser = is_advertiser;
    }

    public VipInfoBean getVip_info() {
        return vip_info;
    }

    public void setVip_info(VipInfoBean vip_info) {
        this.vip_info = vip_info;
    }

    public static class VipInfoBean {
        /**
         * is_vip : false
         * rename_days : 60
         */

        private boolean is_vip;
        private String rename_days;

        public boolean isIs_vip() {
            return is_vip;
        }

        public void setIs_vip(boolean is_vip) {
            this.is_vip = is_vip;
        }

        public String getRename_days() {
            return rename_days;
        }

        public void setRename_days(String rename_days) {
            this.rename_days = rename_days;
        }
    }
}
