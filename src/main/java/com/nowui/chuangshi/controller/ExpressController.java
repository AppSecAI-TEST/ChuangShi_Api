package com.nowui.chuangshi.controller;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.ActionKey;
import com.nowui.chuangshi.constant.Constant;
import com.nowui.chuangshi.constant.Url;
import com.nowui.chuangshi.model.Express;
import com.nowui.chuangshi.service.ExpressService;
import com.nowui.chuangshi.util.Util;

public class ExpressController extends Controller {

    private final ExpressService expressService = new ExpressService();

    @ActionKey(Url.EXPRESS_LIST)
    public void list() {
        validateRequest_app_id();
        validate(Constant.PAGE_SIZE, Constant.FIRST_CREATE_TIME, Constant.LAST_CREATE_TIME);

        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();
        JSONObject jsonObject = getParameterJSONObject();

        authenticateRequest_app_idAndRequest_user_id();

        List<Express> resultList = expressService.listByApp_idAndSystem_create_timeAndLimit(request_app_id, jsonObject.getDate(Constant.LAST_CREATE_TIME), 0, getN(), request_app_id, request_http_id, request_user_id);

        for (Express result : resultList) {
            result.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);
        }

        renderSuccessJson(resultList);
    }

    @ActionKey(Url.EXPRESS_FIND)
    public void find() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());
        authenticateSystem_create_user_id(express.getSystem_create_user_id());

        express.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        renderSuccessJson(express);
    }

    @ActionKey(Url.EXPRESS_SAVE)
    public void save() {
        validateRequest_app_id();
        validate(Express.TRADE_ID, Express.MEMBER_STOCK_ACTION_ID, Express.EXPRESS_SHIPPER_CODE, Express.EXPRESS_NO, Express.EXPRESS_TYPE, Express.EXPRESS_RECEIVER_COMPANY, Express.EXPRESS_RECEIVER_NAME, Express.EXPRESS_RECEIVER_TEL, Express.EXPRESS_RECEIVER_MOBILE, Express.EXPRESS_RECEIVER_POSTCODE, Express.EXPRESS_RECEIVER_PROVINCE, Express.EXPRESS_RECEIVER_CITY, Express.EXPRESS_RECEIVER_AREA, Express.EXPRESS_RECEIVER_ADDRESS, Express.EXPRESS_SENDER_COMPANY, Express.EXPRESS_SENDER_NAME, Express.EXPRESS_SENDER_TEL, Express.EXPRESS_SENDER_MOBILE, Express.EXPRESS_SENDER_POSTCODE, Express.EXPRESS_SENDER_PROVINCE, Express.EXPRESS_SENDER_CITY, Express.EXPRESS_SENDER_AREA, Express.EXPRESS_SENDER_ADDRESS, Express.EXPRESS_COST, Express.EXPRESS_IS_PAY, Express.EXPRESS_PAY_WAY, Express.EXPRESS_START_DATE, Express.EXPRESS_END_DATE, Express.EXPRESS_REMARK);

        Express model = getModel(Express.class);
        String express_id = Util.getRandomUUID();
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Boolean result = expressService.save(express_id, request_app_id, model.getTrade_id(), model.getMember_stock_action_id(), model.getExpress_shipper_code(), model.getExpress_no(), model.getExpress_type(), model.getExpress_receiver_company(), model.getExpress_receiver_name(), model.getExpress_receiver_tel(), model.getExpress_receiver_mobile(), model.getExpress_receiver_postcode(), model.getExpress_receiver_province(), model.getExpress_receiver_city(), model.getExpress_receiver_area(), model.getExpress_receiver_address(), model.getExpress_sender_company(), model.getExpress_sender_name(), model.getExpress_sender_tel(), model.getExpress_sender_mobile(), model.getExpress_sender_postcode(), model.getExpress_sender_province(), model.getExpress_sender_city(), model.getExpress_sender_area(), model.getExpress_sender_address(), model.getExpress_cost(), model.getExpress_is_pay(), model.getExpress_pay_way(), model.getExpress_start_date(), model.getExpress_end_date(), model.getExpress_remark(), request_user_id, request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_UPDATE)
    public void update() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.TRADE_ID, Express.MEMBER_STOCK_ACTION_ID, Express.EXPRESS_SHIPPER_CODE, Express.EXPRESS_NO, Express.EXPRESS_TYPE, Express.EXPRESS_RECEIVER_COMPANY, Express.EXPRESS_RECEIVER_NAME, Express.EXPRESS_RECEIVER_TEL, Express.EXPRESS_RECEIVER_MOBILE, Express.EXPRESS_RECEIVER_POSTCODE, Express.EXPRESS_RECEIVER_PROVINCE, Express.EXPRESS_RECEIVER_CITY, Express.EXPRESS_RECEIVER_AREA, Express.EXPRESS_RECEIVER_ADDRESS, Express.EXPRESS_SENDER_COMPANY, Express.EXPRESS_SENDER_NAME, Express.EXPRESS_SENDER_TEL, Express.EXPRESS_SENDER_MOBILE, Express.EXPRESS_SENDER_POSTCODE, Express.EXPRESS_SENDER_PROVINCE, Express.EXPRESS_SENDER_CITY, Express.EXPRESS_SENDER_AREA, Express.EXPRESS_SENDER_ADDRESS, Express.EXPRESS_COST, Express.EXPRESS_IS_PAY, Express.EXPRESS_PAY_WAY, Express.EXPRESS_START_DATE, Express.EXPRESS_END_DATE, Express.EXPRESS_REMARK, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());
        authenticateSystem_create_user_id(express.getSystem_create_user_id());

        Boolean result = expressService.updateValidateSystem_version(model.getExpress_id(), model.getTrade_id(), model.getMember_stock_action_id(), model.getExpress_shipper_code(), model.getExpress_no(), model.getExpress_type(), model.getExpress_receiver_company(), model.getExpress_receiver_name(), model.getExpress_receiver_tel(), model.getExpress_receiver_mobile(), model.getExpress_receiver_postcode(), model.getExpress_receiver_province(), model.getExpress_receiver_city(), model.getExpress_receiver_area(), model.getExpress_receiver_address(), model.getExpress_sender_company(), model.getExpress_sender_name(), model.getExpress_sender_tel(), model.getExpress_sender_mobile(), model.getExpress_sender_postcode(), model.getExpress_sender_province(), model.getExpress_sender_city(), model.getExpress_sender_area(), model.getExpress_sender_address(), model.getExpress_cost(), model.getExpress_is_pay(), model.getExpress_pay_way(), model.getExpress_start_date(), model.getExpress_end_date(), model.getExpress_remark(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_DELETE)
    public void delete() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());
        authenticateSystem_create_user_id(express.getSystem_create_user_id());

        Boolean result = expressService.deleteByExpress_idAndSystem_update_user_idValidateSystem_version(model.getExpress_id(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_ADMIN_LIST)
    public void adminList() {
        validateRequest_app_id();
        validate(Express.EXPRESS_NO, Constant.PAGE_INDEX, Constant.PAGE_SIZE);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Integer total = expressService.countByApp_idOrLikeExpress_no(request_app_id, model.getExpress_no(), request_app_id, request_http_id, request_user_id);
        List<Express> resultList = expressService.listByApp_idOrLikeExpress_noAndLimit(request_app_id, model.getExpress_no(), getM(), getN(), request_app_id, request_http_id, request_user_id);

        for (Express result : resultList) {
            result.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);
        }

        renderSuccessJson(total, resultList);
    }

    @ActionKey(Url.EXPRESS_ADMIN_FIND)
    public void adminFind() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());

        express.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        renderSuccessJson(express);
    }

    @ActionKey(Url.EXPRESS_ADMIN_SAVE)
    public void adminSave() {
        save();
    }

    @ActionKey(Url.EXPRESS_ADMIN_UPDATE)
    public void adminUpdate() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.TRADE_ID, Express.MEMBER_STOCK_ACTION_ID, Express.EXPRESS_SHIPPER_CODE, Express.EXPRESS_NO, Express.EXPRESS_TYPE, Express.EXPRESS_RECEIVER_COMPANY, Express.EXPRESS_RECEIVER_NAME, Express.EXPRESS_RECEIVER_TEL, Express.EXPRESS_RECEIVER_MOBILE, Express.EXPRESS_RECEIVER_POSTCODE, Express.EXPRESS_RECEIVER_PROVINCE, Express.EXPRESS_RECEIVER_CITY, Express.EXPRESS_RECEIVER_AREA, Express.EXPRESS_RECEIVER_ADDRESS, Express.EXPRESS_SENDER_COMPANY, Express.EXPRESS_SENDER_NAME, Express.EXPRESS_SENDER_TEL, Express.EXPRESS_SENDER_MOBILE, Express.EXPRESS_SENDER_POSTCODE, Express.EXPRESS_SENDER_PROVINCE, Express.EXPRESS_SENDER_CITY, Express.EXPRESS_SENDER_AREA, Express.EXPRESS_SENDER_ADDRESS, Express.EXPRESS_COST, Express.EXPRESS_IS_PAY, Express.EXPRESS_PAY_WAY, Express.EXPRESS_START_DATE, Express.EXPRESS_END_DATE, Express.EXPRESS_REMARK, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());

        Boolean result = expressService.updateValidateSystem_version(model.getExpress_id(), model.getTrade_id(), model.getMember_stock_action_id(), model.getExpress_shipper_code(), model.getExpress_no(), model.getExpress_type(), model.getExpress_receiver_company(), model.getExpress_receiver_name(), model.getExpress_receiver_tel(), model.getExpress_receiver_mobile(), model.getExpress_receiver_postcode(), model.getExpress_receiver_province(), model.getExpress_receiver_city(), model.getExpress_receiver_area(), model.getExpress_receiver_address(), model.getExpress_sender_company(), model.getExpress_sender_name(), model.getExpress_sender_tel(), model.getExpress_sender_mobile(), model.getExpress_sender_postcode(), model.getExpress_sender_province(), model.getExpress_sender_city(), model.getExpress_sender_area(), model.getExpress_sender_address(), model.getExpress_cost(), model.getExpress_is_pay(), model.getExpress_pay_way(), model.getExpress_start_date(), model.getExpress_end_date(), model.getExpress_remark(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_ADMIN_DELETE)
    public void adminDelete() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        authenticateRequest_app_idAndRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        authenticateApp_id(express.getApp_id());

        Boolean result = expressService.deleteByExpress_idAndSystem_update_user_idValidateSystem_version(model.getExpress_id(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_SYSTEM_LIST)
    public void systemList() {
        validateRequest_app_id();
        validate(Express.APP_ID, Constant.PAGE_INDEX, Constant.PAGE_SIZE);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        Integer total = expressService.countByOrApp_idOrLikeExpress_no(model.getApp_id(), model.getExpress_no(), request_app_id, request_http_id, request_user_id);
        List<Express> resultList = expressService.listByOrApp_idOrLikeExpress_noAndLimit(model.getApp_id(), model.getExpress_no(), getM(), getN(), request_app_id, request_http_id, request_user_id);

        for (Express result : resultList) {
            result.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);
        }

        renderSuccessJson(total, resultList);
    }

    @ActionKey(Url.EXPRESS_SYSTEM_FIND)
    public void systemFind() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        Express express = expressService.findByExpress_id(model.getExpress_id(), request_app_id, request_http_id, request_user_id);

        express.keep(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        renderSuccessJson(express);
    }

    @ActionKey(Url.EXPRESS_SYSTEM_SAVE)
    public void systemSave() {
        validateRequest_app_id();
        validate(Express.APP_ID, Express.TRADE_ID, Express.MEMBER_STOCK_ACTION_ID, Express.EXPRESS_SHIPPER_CODE, Express.EXPRESS_NO, Express.EXPRESS_TYPE, Express.EXPRESS_RECEIVER_COMPANY, Express.EXPRESS_RECEIVER_NAME, Express.EXPRESS_RECEIVER_TEL, Express.EXPRESS_RECEIVER_MOBILE, Express.EXPRESS_RECEIVER_POSTCODE, Express.EXPRESS_RECEIVER_PROVINCE, Express.EXPRESS_RECEIVER_CITY, Express.EXPRESS_RECEIVER_AREA, Express.EXPRESS_RECEIVER_ADDRESS, Express.EXPRESS_SENDER_COMPANY, Express.EXPRESS_SENDER_NAME, Express.EXPRESS_SENDER_TEL, Express.EXPRESS_SENDER_MOBILE, Express.EXPRESS_SENDER_POSTCODE, Express.EXPRESS_SENDER_PROVINCE, Express.EXPRESS_SENDER_CITY, Express.EXPRESS_SENDER_AREA, Express.EXPRESS_SENDER_ADDRESS, Express.EXPRESS_COST, Express.EXPRESS_IS_PAY, Express.EXPRESS_PAY_WAY, Express.EXPRESS_START_DATE, Express.EXPRESS_END_DATE, Express.EXPRESS_REMARK);

        Express model = getModel(Express.class);
        String express_id = Util.getRandomUUID();
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        Boolean result = expressService.save(express_id, model.getApp_id(), model.getTrade_id(), model.getMember_stock_action_id(), model.getExpress_shipper_code(), model.getExpress_no(), model.getExpress_type(), model.getExpress_receiver_company(), model.getExpress_receiver_name(), model.getExpress_receiver_tel(), model.getExpress_receiver_mobile(), model.getExpress_receiver_postcode(), model.getExpress_receiver_province(), model.getExpress_receiver_city(), model.getExpress_receiver_area(), model.getExpress_receiver_address(), model.getExpress_sender_company(), model.getExpress_sender_name(), model.getExpress_sender_tel(), model.getExpress_sender_mobile(), model.getExpress_sender_postcode(), model.getExpress_sender_province(), model.getExpress_sender_city(), model.getExpress_sender_area(), model.getExpress_sender_address(), model.getExpress_cost(), model.getExpress_is_pay(), model.getExpress_pay_way(), model.getExpress_start_date(), model.getExpress_end_date(), model.getExpress_remark(), request_user_id, request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_SYSTEM_UPDATE)
    public void systemUpdate() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.TRADE_ID, Express.MEMBER_STOCK_ACTION_ID, Express.EXPRESS_SHIPPER_CODE, Express.EXPRESS_NO, Express.EXPRESS_TYPE, Express.EXPRESS_RECEIVER_COMPANY, Express.EXPRESS_RECEIVER_NAME, Express.EXPRESS_RECEIVER_TEL, Express.EXPRESS_RECEIVER_MOBILE, Express.EXPRESS_RECEIVER_POSTCODE, Express.EXPRESS_RECEIVER_PROVINCE, Express.EXPRESS_RECEIVER_CITY, Express.EXPRESS_RECEIVER_AREA, Express.EXPRESS_RECEIVER_ADDRESS, Express.EXPRESS_SENDER_COMPANY, Express.EXPRESS_SENDER_NAME, Express.EXPRESS_SENDER_TEL, Express.EXPRESS_SENDER_MOBILE, Express.EXPRESS_SENDER_POSTCODE, Express.EXPRESS_SENDER_PROVINCE, Express.EXPRESS_SENDER_CITY, Express.EXPRESS_SENDER_AREA, Express.EXPRESS_SENDER_ADDRESS, Express.EXPRESS_COST, Express.EXPRESS_IS_PAY, Express.EXPRESS_PAY_WAY, Express.EXPRESS_START_DATE, Express.EXPRESS_END_DATE, Express.EXPRESS_REMARK, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        Boolean result = expressService.updateValidateSystem_version(model.getExpress_id(), model.getTrade_id(), model.getMember_stock_action_id(), model.getExpress_shipper_code(), model.getExpress_no(), model.getExpress_type(), model.getExpress_receiver_company(), model.getExpress_receiver_name(), model.getExpress_receiver_tel(), model.getExpress_receiver_mobile(), model.getExpress_receiver_postcode(), model.getExpress_receiver_province(), model.getExpress_receiver_city(), model.getExpress_receiver_area(), model.getExpress_receiver_address(), model.getExpress_sender_company(), model.getExpress_sender_name(), model.getExpress_sender_tel(), model.getExpress_sender_mobile(), model.getExpress_sender_postcode(), model.getExpress_sender_province(), model.getExpress_sender_city(), model.getExpress_sender_area(), model.getExpress_sender_address(), model.getExpress_cost(), model.getExpress_is_pay(), model.getExpress_pay_way(), model.getExpress_start_date(), model.getExpress_end_date(), model.getExpress_remark(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

    @ActionKey(Url.EXPRESS_SYSTEM_DELETE)
    public void systemDelete() {
        validateRequest_app_id();
        validate(Express.EXPRESS_ID, Express.SYSTEM_VERSION);

        Express model = getModel(Express.class);
        String request_app_id = getRequest_app_id();
        String request_http_id = getRequest_http_id();
        String request_user_id = getRequest_user_id();

        Boolean result = expressService.deleteByExpress_idAndSystem_update_user_idValidateSystem_version(model.getExpress_id(), request_user_id, model.getSystem_version(), request_app_id, request_http_id, request_user_id);

        renderSuccessJson(result);
    }

}