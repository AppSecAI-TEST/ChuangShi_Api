package com.nowui.chuangshi.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nowui.chuangshi.cache.ExpressCache;
import com.nowui.chuangshi.model.Express;

public class ExpressService extends Service {

    private ExpressCache expressCache = new ExpressCache();

    public Integer countByApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_name(String app_id, String express_no, String express_receiver_name, String express_sender_name) {
        return expressCache.countByApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_name(app_id, express_no, express_receiver_name, express_sender_name);
    }

    public Integer countByOrApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_name(String app_id, String express_no, String express_receiver_name, String express_sender_name) {
        return expressCache.countByOrApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_name(app_id, express_no, express_receiver_name, express_sender_name);
    }

    public List<Express> listByApp_idAndSystem_create_timeAndLimit(String app_id, Date system_create_time, int m, int n) {
        return expressCache.listByApp_idAndSystem_create_timeAndLimit(app_id, system_create_time, m, n);
    }

    public List<Express> listByApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_nameAndLimit(String app_id, String express_no, String express_receiver_name, String express_sender_name, int m, int n) {
        return expressCache.listByApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_nameAndLimit(app_id, express_no, express_receiver_name, express_sender_name, m, n);
    }

    public List<Express> listByOrApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_nameAndLimit(String app_id, String express_no, String express_receiver_name, String express_sender_name, int m, int n) {
        return expressCache.listByOrApp_idOrLikeExpress_noOrLikeExpress_receiver_nameOrLikeExpress_sender_nameAndLimit(app_id, express_no, express_receiver_name, express_sender_name, m, n);
    }

    public Express findByExpress_id(String express_id) {
        return expressCache.findByExpress_id(express_id);
    }

    public Boolean save(String express_id, String app_id, String trade_id, String stock_id, String express_receiver_user_id, String express_sender_user_id, String express_shipper_code, String express_no, String express_type, String express_receiver_company, String express_receiver_name, String express_receiver_tel, String express_receiver_mobile, String express_receiver_postcode, String express_receiver_province, String express_receiver_city, String express_receiver_area, String express_receiver_address, String express_sender_company, String express_sender_name, String express_sender_tel, String express_sender_mobile, String express_sender_postcode, String express_sender_province, String express_sender_city, String express_sender_area, String express_sender_address, BigDecimal express_cost, Boolean express_is_pay, String express_pay_way, String express_start_date, String express_end_date, String express_logistics, String express_status, String express_remark, String system_create_user_id) {
        return expressCache.save(express_id, app_id, trade_id, stock_id, express_receiver_user_id, express_sender_user_id, express_shipper_code, express_no, express_type, express_receiver_company, express_receiver_name, express_receiver_tel, express_receiver_mobile, express_receiver_postcode, express_receiver_province, express_receiver_city, express_receiver_area, express_receiver_address, express_sender_company, express_sender_name, express_sender_tel, express_sender_mobile, express_sender_postcode, express_sender_province, express_sender_city, express_sender_area, express_sender_address, express_cost, express_is_pay, express_pay_way, express_start_date, express_end_date, express_logistics, express_status, express_remark, system_create_user_id);
    }

    public Boolean updateValidateSystem_version(String express_id, String trade_id, String stock_id, String express_receiver_user_id, String express_sender_user_id, String express_shipper_code, String express_no, String express_type, String express_receiver_company, String express_receiver_name, String express_receiver_tel, String express_receiver_mobile, String express_receiver_postcode, String express_receiver_province, String express_receiver_city, String express_receiver_area, String express_receiver_address, String express_sender_company, String express_sender_name, String express_sender_tel, String express_sender_mobile, String express_sender_postcode, String express_sender_province, String express_sender_city, String express_sender_area, String express_sender_address, BigDecimal express_cost, Boolean express_is_pay, String express_pay_way, String express_start_date, String express_end_date, String express_logistics, String express_status, String express_remark, String system_update_user_id, Integer system_version) {
        return expressCache.updateValidateSystem_version(express_id, trade_id, stock_id, express_receiver_user_id, express_sender_user_id, express_shipper_code, express_no, express_type, express_receiver_company, express_receiver_name, express_receiver_tel, express_receiver_mobile, express_receiver_postcode, express_receiver_province, express_receiver_city, express_receiver_area, express_receiver_address, express_sender_company, express_sender_name, express_sender_tel, express_sender_mobile, express_sender_postcode, express_sender_province, express_sender_city, express_sender_area, express_sender_address, express_cost, express_is_pay, express_pay_way, express_start_date, express_end_date, express_logistics, express_status, express_remark, system_update_user_id, system_version);
    }
    
    public Boolean updateExpress_noAndExpress_costAndExpress_remarkByExpress_idValidateSystem_version(String express_id, String express_no, BigDecimal express_cost, String express_remark, String system_update_user_id, Integer system_version) {
        return expressCache.updateExpress_noAndExpress_costAndExpress_remarkByExpress_idValidateSystem_version(express_id, express_no, express_cost, express_remark, system_update_user_id, system_version);
    }

    public Boolean deleteByExpress_idAndSystem_update_user_idValidateSystem_version(String express_id, String system_update_user_id, Integer system_version) {
        return expressCache.deleteByExpress_idAndSystem_update_user_idValidateSystem_version(express_id, system_update_user_id, system_version);
    }

    public List<Express> listByTrade_id(String trade_id) {
        return expressCache.listByTrade_id(trade_id);
    }

}