package com.nowui.chuangshi.model;

import com.nowui.chuangshi.constant.Column;
import com.nowui.chuangshi.type.ColumnType;

public class App extends Model<App> {

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "应用编号")
    public static final String APP_ID = "app_id";

    @Column(type = ColumnType.VARCHAR, length = 100, comment = "应用名称")
    public static final String APP_NAME = "app_name";

    @Column(type = ColumnType.VARCHAR, length = 100, comment = "应用密钥")
    public static final String APP_SECRET = "app_secret";

    @Column(type = ColumnType.VARCHAR, length = 18, comment = "wechat_app_id")
    public static final String WECHAT_APP_ID = "wechat_app_id";

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "wechat_app_secret")
    public static final String WECHAT_APP_SECRET = "wechat_app_secret";

    @Column(type = ColumnType.VARCHAR, length = 10, comment = "wechat_mch_id")
    public static final String WECHAT_MCH_ID = "wechat_mch_id";

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "wechat_mch_key")
    public static final String WECHAT_MCH_KEY = "wechat_mch_key";

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "wechat_token")
    public static final String WECHAT_TOKEN = "wechat_token";

    @Column(type = ColumnType.VARCHAR, length = 43, comment = "wechat_encoding_aes_key")
    public static final String WECHAT_ENCODING_AES_KEY = "wechat_encoding_aes_key";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "是否建仓库")
    public static final String APP_IS_CREATE_WAREHOUSE = "app_is_create_warehouse";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "是否发货")
    public static final String APP_IS_DELIVERY = "app_is_delivery";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "是否审核会员")
    public static final String APP_IS_AUDIT_MEMBER = "app_is_audit_member";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "是否分成")
    public static final String APP_IS_COMMISSION = "app_is_commission";

    @Column(type = ColumnType.INT, length = 5, comment = "参与分成的上级层数")
    public static final String APP_COMMISSION_LEVEL = "app_commission_level";

    public String getApp_id() {
        return getStr(APP_ID);
    }

    public void setApp_id(String app_id) {
        set(APP_ID, app_id);
    }

    public String getApp_name() {
        return getStr(APP_NAME);
    }

    public void setApp_name(String app_name) {
        set(APP_NAME, app_name);
    }

    public String getApp_secret() {
        return getStr(APP_SECRET);
    }

    public void setApp_secret(String app_secret) {
        set(APP_SECRET, app_secret);
    }

    public String getWechat_app_id() {
        return getStr(WECHAT_APP_ID);
    }

    public void setWechat_app_id(String wechat_app_id) {
        set(WECHAT_APP_ID, wechat_app_id);
    }

    public String getWechat_app_secret() {
        return getStr(WECHAT_APP_SECRET);
    }

    public void setWechat_app_secret(String wechat_app_secret) {
        set(WECHAT_APP_SECRET, wechat_app_secret);
    }

    public String getWechat_mch_id() {
        return getStr(WECHAT_MCH_ID);
    }

    public void setWechat_mch_id(String wechat_mch_id) {
        set(WECHAT_MCH_ID, wechat_mch_id);
    }

    public String getWechat_mch_key() {
        return getStr(WECHAT_MCH_KEY);
    }

    public void setWechat_mch_key(String wechat_mch_key) {
        set(WECHAT_MCH_KEY, wechat_mch_key);
    }

    public String getWechat_token() {
        return getStr(WECHAT_TOKEN);
    }

    public void setWechat_token(String wechat_token) {
        set(WECHAT_TOKEN, wechat_token);
    }

    public String getWechat_encoding_aes_key() {
        return getStr(WECHAT_ENCODING_AES_KEY);
    }

    public void setWechat_encoding_aes_key(String wechat_encoding_aes_key) {
        set(WECHAT_ENCODING_AES_KEY, wechat_encoding_aes_key);
    }

    public Boolean getApp_is_create_warehouse() {
        return getBoolean(APP_IS_CREATE_WAREHOUSE);
    }

    public void setApp_is_create_warehouse(Boolean app_is_create_warehouse) {
        set(APP_IS_CREATE_WAREHOUSE, app_is_create_warehouse);
    }

    public Boolean getApp_is_delivery() {
        return getBoolean(APP_IS_DELIVERY);
    }

    public void setApp_is_delivery(Boolean app_is_delivery) {
        set(APP_IS_DELIVERY, app_is_delivery);
    }

    public Boolean getApp_is_audit_member() {
        return getBoolean(APP_IS_AUDIT_MEMBER);
    }

    public void setApp_is_audit_member(Boolean app_is_audit_member) {
        set(APP_IS_AUDIT_MEMBER, app_is_audit_member);
    }

    public Boolean getApp_is_commission() {
        return getBoolean(APP_IS_COMMISSION);
    }

    public void setApp_is_commission(Boolean app_is_commission) {
        set(APP_IS_COMMISSION, app_is_commission);
    }

    public Integer getApp_commission_level() {
        return getInt(APP_COMMISSION_LEVEL);
    }

    public void setApp_commission_level(Integer app_commission_level) {
        set(APP_COMMISSION_LEVEL, app_commission_level);
    }

}