package com.nowui.chuangshi.dao;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.SqlPara;
import com.nowui.chuangshi.constant.Constant;
import com.nowui.chuangshi.model.ProductSkuPrice;
import com.nowui.chuangshi.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSkuPriceDao extends Dao {

    public List<ProductSkuPrice> listByProduct_sku_id(String product_sku_id, String request_app_id, String request_http_id, String request_user_id) {
        Kv sqlMap = Kv.create();
        sqlMap.put(ProductSkuPrice.PRODUCT_SKU_ID, product_sku_id);
        SqlPara sqlPara = Db.getSqlPara("product_sku_price.listByProduct_sku_id", sqlMap);

        logSql(request_app_id, request_http_id, "table_product_sku_price", "listByProduct_sku_id", sqlPara, request_user_id);

        return new ProductSkuPrice().find(sqlPara.getSql(), sqlPara.getPara());
    }

    public Boolean save(List<ProductSkuPrice> productSkuPriceList, String request_app_id, String request_http_id, String request_user_id) {
        if (productSkuPriceList.size() == 0) {
            return false;
        }

        Kv map = Kv.create();
        SqlPara sqlPara = Db.getSqlPara("product_sku_price.save", map);

        List<Object[]> parameterList = new ArrayList<Object[]>();
        for(ProductSkuPrice productSkuPrice : productSkuPriceList) {
            List<Object> objectList = new ArrayList<Object>();
            objectList.add(productSkuPrice.getProduct_sku_id());
            objectList.add(productSkuPrice.getMember_level_id());
            objectList.add(productSkuPrice.getMember_level_name());
            objectList.add(productSkuPrice.getProduct_sku_price());
            objectList.add(request_user_id);
            objectList.add(new Date());
            objectList.add(request_user_id);
            objectList.add(new Date());
            objectList.add(0);
            objectList.add(true);
            parameterList.add(objectList.toArray());
        }

        int[] result = Db.batch(sqlPara.getSql(), Util.getObjectArray(parameterList), Constant.BATCH_SIZE);

        for (int i : result) {
            if (i == 0) {
                throw new RuntimeException("SKU价格保存不成功");
            }
        }

        logSql(request_app_id, request_http_id, "table_product_sku_price", "save", sqlPara, request_user_id);

        return true;
    }

    public Boolean delete(List<String> productSkuIdList, String request_app_id, String request_http_id, String request_user_id) {
        if (productSkuIdList.size() == 0) {
            return false;
        }

        Kv map = Kv.create();
        SqlPara sqlPara = Db.getSqlPara("product_sku_price.delete", map);

        List<Object[]> parameterList = new ArrayList<Object[]>();
        for(String product_sku_id : productSkuIdList) {
            List<Object> objectList = new ArrayList<Object>();
            objectList.add(request_user_id);
            objectList.add(new Date());
            objectList.add(product_sku_id);
            parameterList.add(objectList.toArray());
        }

        int[] result = Db.batch(sqlPara.getSql(), Util.getObjectArray(parameterList), Constant.BATCH_SIZE);

        for (int i : result) {
            if (i == 0) {
                throw new RuntimeException("SKU价格删除不成功");
            }
        }

        logSql(request_app_id, request_http_id, "table_product_sku_price", "delete", sqlPara, request_user_id);

        return true;
    }

}