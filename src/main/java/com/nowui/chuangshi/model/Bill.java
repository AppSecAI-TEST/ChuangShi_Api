package com.nowui.chuangshi.model;

import java.math.BigDecimal;
import java.util.Date;

import com.nowui.chuangshi.constant.Column;
import com.nowui.chuangshi.type.ColumnType;

public class Bill extends Model<Bill> {

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "账单编号")
    public static final String BILL_ID = "bill_id";

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "应用编号")
    public static final String APP_ID = "app_id";

    @Column(type = ColumnType.VARCHAR, length = 32, comment = "用户编号")
    public static final String USER_ID = "user_id";

    @Column(type = ColumnType.VARCHAR, length = 10, comment = "账单类型")
    public static final String BILL_TYPE = "bill_type";

    @Column(type = ColumnType.VARCHAR, length = 100, comment = "账单图片")
    public static final String BILL_IMAGE = "bill_image";

    @Column(type = ColumnType.VARCHAR, length = 100, comment = "账单名称")
    public static final String BILL_NAME = "bill_name";

    @Column(type = ColumnType.DECIMAL, length = 0, comment = "账单金额")
    public static final String BILL_AMOUNT = "bill_amount";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "是否收入")
    public static final String BILL_IS_INCOME = "bill_is_income";

    @Column(type = ColumnType.DATETIME, length = 0, comment = "账单时间")
    public static final String BILL_TIME = "bill_time";

    @Column(type = ColumnType.VARCHAR, length = 10, comment = "账单流程")
    public static final String BILL_FLOW = "bill_flow";

    @Column(type = ColumnType.TINYINT, length = 1, comment = "账单状态")
    public static final String BILL_STATUS = "bill_status";

    public String getBill_id() {
        return getStr(BILL_ID);
    }

    public void setBill_id(String bill_id) {
        set(BILL_ID, bill_id);
    }

    public String getApp_id() {
        return getStr(APP_ID);
    }

    public void setApp_id(String app_id) {
        set(APP_ID, app_id);
    }

    public String getUser_id() {
        return getStr(USER_ID);
    }

    public void setUser_id(String user_id) {
        set(USER_ID, user_id);
    }

    public String getBill_type() {
        return getStr(BILL_TYPE);
    }

    public void setBill_type(String bill_type) {
        set(BILL_TYPE, bill_type);
    }

    public String getBill_image() {
        return getStr(BILL_IMAGE);
    }

    public void setBill_image(String bill_image) {
        set(BILL_IMAGE, bill_image);
    }

    public String getBill_name() {
        return getStr(BILL_NAME);
    }

    public void setBill_name(String bill_name) {
        set(BILL_NAME, bill_name);
    }

    public BigDecimal getBill_amount() {
        return getBigDecimal(BILL_AMOUNT);
    }

    public void setBill_amount(BigDecimal bill_amount) {
        set(BILL_AMOUNT, bill_amount);
    }

    public Boolean getBill_is_income() {
        return getBoolean(BILL_IS_INCOME);
    }

    public void setBill_is_income(Boolean bill_is_income) {
        set(BILL_IS_INCOME, bill_is_income);
    }

    public Date getBill_time() {
        return getDate(BILL_TIME);
    }

    public void setBill_time(Date bill_time) {
        set(BILL_TIME, bill_time);
    }

    public String getBill_flow() {
        return getStr(BILL_FLOW);
    }

    public void setBill_flow(String bill_flow) {
        set(BILL_FLOW, bill_flow);
    }

    public Boolean getBill_status() {
        return getBoolean(BILL_STATUS);
    }

    public void setBill_status(Boolean bill_status) {
        set(BILL_STATUS, bill_status);
    }

}