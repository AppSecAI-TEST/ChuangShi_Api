package com.nowui.chuangshi.service;

import com.nowui.chuangshi.cache.CustomerCache;
import com.nowui.chuangshi.model.Customer;

import java.util.Date;
import java.util.List;

public class CustomerService extends Service {

    private CustomerCache customerCache = new CustomerCache();

    public Integer countByApp_idOrLikeCustomer_name(String app_id, String customer_name, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.countByApp_idOrLikeCustomer_name(app_id, customer_name, request_app_id, request_http_id, request_user_id);
    }

    public Integer countByOrApp_idOrLikeCustomer_name(String app_id, String customer_name, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.countByOrApp_idOrLikeCustomer_name(app_id, customer_name, request_app_id, request_http_id, request_user_id);
    }

    public List<Customer> listByApp_idAndSystem_create_timeAndLimit(String app_id, Date system_create_time, int m, int n, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.listByApp_idAndSystem_create_timeAndLimit(app_id, system_create_time, m, n, request_app_id, request_http_id, request_user_id);
    }

    public List<Customer> listByApp_idOrLikeCustomer_nameAndLimit(String app_id, String customer_name, int m, int n, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.listByApp_idOrLikeCustomer_nameAndLimit(app_id, customer_name, m, n, request_app_id, request_http_id, request_user_id);
    }

    public List<Customer> listByOrApp_idOrLikeCustomer_nameAndLimit(String app_id, String customer_name, int m, int n, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.listByOrApp_idOrLikeCustomer_nameAndLimit(app_id, customer_name, m, n, request_app_id, request_http_id, request_user_id);
    }

    public Customer findByCustomer_id(String customer_id, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.findByCustomer_id(customer_id, request_app_id, request_http_id, request_user_id);
    }

    public Boolean save(String customer_id, String app_id, String customer_name, String customer_phone, String customer_birthday, String customer_city, String customer_sex, String customer_id_card, String system_create_user_id, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.save(customer_id, app_id, customer_name, customer_phone, customer_birthday, customer_city, customer_sex, customer_id_card, system_create_user_id, request_app_id, request_http_id, request_user_id);
    }

    public Boolean updateValidateSystem_version(String customer_id, String customer_name, String customer_phone, String customer_birthday, String customer_city, String customer_sex, String customer_id_card, String system_update_user_id, Integer system_version, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.updateValidateSystem_version(customer_id, customer_name, customer_phone, customer_birthday, customer_city, customer_sex, customer_id_card, system_update_user_id, system_version, request_app_id, request_http_id, request_user_id);
    }

    public Boolean deleteByCustomer_idAndSystem_update_user_idValidateSystem_version(String customer_id, String system_update_user_id, Integer system_version, String request_app_id, String request_http_id, String request_user_id) {
        return customerCache.deleteByCustomer_idAndSystem_update_user_idValidateSystem_version(customer_id, system_update_user_id, system_version, request_app_id, request_http_id, request_user_id);
    }

}