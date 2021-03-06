package com.nowui.chuangshi.controller;

import java.util.List;

import com.jfinal.core.ActionKey;
import com.nowui.chuangshi.constant.Url;
import com.nowui.chuangshi.util.CacheUtil;

public class CacheController extends Controller {

    @ActionKey(Url.REMOVE_ALL_CACHE)
    public void removeAllCache() {
        validateRequest_app_id();

        List<String> keyList = CacheUtil.getKeys(CacheUtil.CACHE_NAME_CACHE);

        for (String key : keyList) {
            CacheUtil.removeAll(key);
        }

        renderSuccessJson(true);
    }

}
