package com.nowui.chuangshi.service;

import com.nowui.chuangshi.cache.MenuApiCache;
import com.nowui.chuangshi.model.MenuApi;

import java.util.List;

public class MenuApiService extends Service {

    private MenuApiCache menuApiCache = new MenuApiCache();

    public Integer countByApp_idAndApi_id(String app_id, String api_id, String request_app_id, String request_http_id, String request_user_id) {
        return menuApiCache.countByApp_idAndApi_id(app_id, api_id, request_app_id, request_http_id, request_user_id);
    }

    public List<MenuApi> listByMenu_id(String menu_id, String request_app_id, String request_http_id, String request_user_id) {
        return menuApiCache.listByMenu_id(menu_id, request_app_id, request_http_id, request_user_id);
    }

    public Boolean save(String app_id, String menu_id, String api_id, Integer menu_api_sort, String system_create_user_id, String request_app_id, String request_http_id, String request_user_id) {
        return menuApiCache.save(app_id, menu_id, api_id, menu_api_sort, system_create_user_id, request_app_id, request_http_id, request_user_id);
    }

    public Boolean deleteByMenu_id(String menu_id, String system_update_user_id, String request_app_id, String request_http_id, String request_user_id) {
        return menuApiCache.deleteByMenu_id(menu_id, system_update_user_id, request_app_id, request_http_id, request_user_id);
    }

    public Boolean deleteByMenu_idAndApi_id(String menu_id, String api_id, String system_update_user_id, String request_app_id, String request_http_id, String request_user_id) {
        return menuApiCache.deleteByMenu_idAndApi_id(menu_id, api_id, system_update_user_id, request_app_id, request_http_id, request_user_id);
    }

}