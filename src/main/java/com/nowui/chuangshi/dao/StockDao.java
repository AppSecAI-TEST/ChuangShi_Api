package com.nowui.chuangshi.dao;

import java.util.Date;
import java.util.List;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.SqlPara;
import com.nowui.chuangshi.constant.Constant;
import com.nowui.chuangshi.model.Stock;

public class StockDao extends Dao {

    public Integer countByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name(String app_id, String warehouse_id, String stock_type, String stock_batch, String product_name, String user_name) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.PRODUCT_NAME, product_name);
        sqlMap.put(Stock.USER_NAME, user_name);
        SqlPara sqlPara = Db.getSqlPara("stock.countByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name", sqlMap);

        logSql("stock", "countByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name", sqlPara);

        Number count = Db.queryFirst(sqlPara.getSql(), sqlPara.getPara());
        return count.intValue();
    }

    public Integer countByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name(String app_id, String warehouse_id, String stock_type, String stock_batch, String product_name, String user_name) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.PRODUCT_NAME, product_name);
        sqlMap.put(Stock.USER_NAME, user_name);
        SqlPara sqlPara = Db.getSqlPara("stock.countByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name", sqlMap);

        logSql("stock", "countByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_name", sqlPara);

        Number count = Db.queryFirst(sqlPara.getSql(), sqlPara.getPara());
        return count.intValue();
    }
    
    public Integer sumQuantityByApp_idOrWarehouse_idAndObject_idAndProduct_sku_id(String app_id, String warehouse_id, String object_id, String product_sku_id) {
    	Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.OBJECT_ID, object_id);
        sqlMap.put(Stock.PRODUCT_SKU_ID, product_sku_id);
        SqlPara sqlPara = Db.getSqlPara("stock.sumQuantityByApp_idOrWarehouse_idAndObject_idAndProduct_sku_id", sqlMap);

        logSql("stock", "sumQuantityByApp_idOrWarehouse_idAndObject_idAndProduct_sku_id", sqlPara);

        Number count = Db.queryFirst(sqlPara.getSql(), sqlPara.getPara());
        return count.intValue();
    }
    
    public Integer sumQuantityByObject_id(String object_id) {
    	Kv sqlMap = Kv.create();
    	sqlMap.put(Stock.OBJECT_ID, object_id);
    	SqlPara sqlPara = Db.getSqlPara("stock.sumQuantityByObject_id", sqlMap);
    	
    	logSql("stock", "sumQuantityByObject_id", sqlPara);
    	
    	Number count = Db.queryFirst(sqlPara.getSql(), sqlPara.getPara());
    	return count.intValue();
    }

    public List<Stock> listByApp_idAndSystem_create_timeAndLimit(String app_id, Date system_create_time, int m, int n) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.SYSTEM_CREATE_TIME, system_create_time);
        sqlMap.put(Constant.M, m);
        sqlMap.put(Constant.N, n);
        SqlPara sqlPara = Db.getSqlPara("stock.listByApp_idAndSystem_create_timeAndLimit", sqlMap);

        logSql("stock", "listByApp_idAndSystem_create_timeAndLimit", sqlPara);

        return new Stock().find(sqlPara.getSql(), sqlPara.getPara());
    }

    public List<Stock> listByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit(String app_id, String warehouse_id, String stock_type, String stock_batch, String product_name, String user_name, int m, int n) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.PRODUCT_NAME, product_name);
        sqlMap.put(Stock.USER_NAME, user_name);
        sqlMap.put(Constant.M, m);
        sqlMap.put(Constant.N, n);
        SqlPara sqlPara = Db.getSqlPara("stock.listByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit", sqlMap);

        logSql("stock", "listByApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit", sqlPara);

        return new Stock().find(sqlPara.getSql(), sqlPara.getPara());
    }

    public List<Stock> listByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit(String app_id, String warehouse_id, String stock_type, String stock_batch, String product_name, String user_name, int m, int n) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.PRODUCT_NAME, product_name);
        sqlMap.put(Stock.USER_NAME, user_name);
        sqlMap.put(Constant.M, m);
        sqlMap.put(Constant.N, n);
        SqlPara sqlPara = Db.getSqlPara("stock.listByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit", sqlMap);

        logSql("stock", "listByOrApp_idOrWarehouse_idOrStock_typeOrLikeStock_batchOrLikeProduct_nameOrLikeUser_nameAndLimit", sqlPara);

        return new Stock().find(sqlPara.getSql(), sqlPara.getPara());
    }

    public Stock findByStock_id(String stock_id) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.STOCK_ID, stock_id);
        SqlPara sqlPara = Db.getSqlPara("stock.findByStock_id", sqlMap);

        logSql("stock", "findByStock_id", sqlPara);

        List<Stock> stockList = new Stock().find(sqlPara.getSql(), sqlPara.getPara());
        if (stockList.size() == 0) {
            return null;
        } else {
            return stockList.get(0);
        }
    }
    
    public Stock findByWarehouse_idAndObject_idAndProduct_sku_id(String warehouse_id, String object_id, String product_sku_id) {
    	Kv sqlMap = Kv.create();
    	sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
    	sqlMap.put(Stock.OBJECT_ID, object_id);
    	sqlMap.put(Stock.PRODUCT_SKU_ID, product_sku_id);
    	SqlPara sqlPara = Db.getSqlPara("stock.findByWarehouse_idAndObject_idAndProduct_sku_id", sqlMap);
    	
    	logSql("stock", "findByWarehouse_idAndObject_idAndProduct_sku_id", sqlPara);
    	
    	List<Stock> stockList = new Stock().find(sqlPara.getSql(), sqlPara.getPara());
    	if (stockList.size() == 0) {
    		return null;
    	} else {
    		return stockList.get(0);
    	}
    }
    
    public Stock findByStock_idAndStock_type(String stock_id, String stock_type) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.STOCK_ID, stock_id);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        SqlPara sqlPara = Db.getSqlPara("stock.findByStock_idAndStock_type", sqlMap);
        
        logSql("stock", "findByStock_idAndStock_type", sqlPara);
        
        List<Stock> stockList = new Stock().find(sqlPara.getSql(), sqlPara.getPara());
        if (stockList.size() == 0) {
            return null;
        } else {
            return stockList.get(0);
        }
    }

    public Boolean save(String stock_id, String app_id, String warehouse_id, String object_id, String stock_batch, String stock_type, String product_category_id, String product_id, String product_sku_id, Integer stock_quantity, String system_create_user_id) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.STOCK_ID, stock_id);
        sqlMap.put(Stock.APP_ID, app_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.OBJECT_ID, object_id);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.PRODUCT_CATEGORY_ID, product_category_id);
        sqlMap.put(Stock.PRODUCT_ID, product_id);
        sqlMap.put(Stock.PRODUCT_SKU_ID, product_sku_id);
        sqlMap.put(Stock.STOCK_QUANTITY, stock_quantity);
        sqlMap.put(Stock.SYSTEM_CREATE_USER_ID, system_create_user_id);
        sqlMap.put(Stock.SYSTEM_CREATE_TIME, new Date());
        sqlMap.put(Stock.SYSTEM_UPDATE_USER_ID, system_create_user_id);
        sqlMap.put(Stock.SYSTEM_UPDATE_TIME, new Date());
        sqlMap.put(Stock.SYSTEM_VERSION, 0);
        sqlMap.put(Stock.SYSTEM_STATUS, true);
        SqlPara sqlPara = Db.getSqlPara("stock.save", sqlMap);

        logSql("stock", "save", sqlPara);

        return Db.update(sqlPara.getSql(), sqlPara.getPara()) != 0;
    }

    public Boolean update(String stock_id, String warehouse_id, String object_id, String stock_batch, String stock_type, String product_category_id, String product_id, String product_sku_id, Integer stock_quantity, String system_update_user_id, Integer system_version) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.STOCK_ID, stock_id);
        sqlMap.put(Stock.WAREHOUSE_ID, warehouse_id);
        sqlMap.put(Stock.OBJECT_ID, object_id);
        sqlMap.put(Stock.STOCK_BATCH, stock_batch);
        sqlMap.put(Stock.STOCK_TYPE, stock_type);
        sqlMap.put(Stock.PRODUCT_CATEGORY_ID, product_category_id);
        sqlMap.put(Stock.PRODUCT_ID, product_id);
        sqlMap.put(Stock.PRODUCT_SKU_ID, product_sku_id);
        sqlMap.put(Stock.STOCK_QUANTITY, stock_quantity);
        sqlMap.put(Stock.SYSTEM_UPDATE_USER_ID, system_update_user_id);
        sqlMap.put(Stock.SYSTEM_UPDATE_TIME, new Date());
        sqlMap.put(Stock.SYSTEM_VERSION, system_version);
        SqlPara sqlPara = Db.getSqlPara("stock.update", sqlMap);

        logSql("stock", "update", sqlPara);

        return Db.update(sqlPara.getSql(), sqlPara.getPara()) != 0;
    }

    public Boolean deleteByStock_idAndSystem_version(String stock_id, String system_update_user_id, Integer system_version) {
        Kv sqlMap = Kv.create();
        sqlMap.put(Stock.STOCK_ID, stock_id);
        sqlMap.put(Stock.SYSTEM_UPDATE_USER_ID, system_update_user_id);
        sqlMap.put(Stock.SYSTEM_UPDATE_TIME, new Date());
        sqlMap.put(Stock.SYSTEM_VERSION, system_version);
        SqlPara sqlPara = Db.getSqlPara("stock.deleteByStock_idAndSystem_version", sqlMap);

        logSql("stock", "deleteByStock_idAndSystem_version", sqlPara);

        return Db.update(sqlPara.getSql(), sqlPara.getPara()) != 0;
    }
    
    public Boolean batchUpdate(List<Stock> stockList) {
        int[] result = Db.batchUpdate(stockList, Constant.BATCH_SIZE);

        for (int i : result) {
            if (i == 0) {
                throw new RuntimeException("库存记录更新不成功");
            }
        }
        return true;
    }
    
    public Boolean batchSave(List<Stock> stockList) {
        int[] result = Db.batchSave(stockList, Constant.BATCH_SIZE);

        for (int i : result) {
            if (i == 0) {
                throw new RuntimeException("库存记录保存不成功");
            }
        }
        return true;
    }

}