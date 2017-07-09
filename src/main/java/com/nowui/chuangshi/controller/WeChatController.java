package com.nowui.chuangshi.controller;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.jfinal.core.ActionKey;
import com.jfinal.kit.HttpKit;
import com.jfinal.weixin.sdk.kit.PaymentKit;
import com.nowui.chuangshi.constant.Constant;
import com.nowui.chuangshi.constant.Url;
import com.nowui.chuangshi.model.App;
import com.nowui.chuangshi.model.Trade;
import com.nowui.chuangshi.service.AppService;
import com.nowui.chuangshi.service.TradeService;
import com.nowui.chuangshi.type.PayType;
import com.nowui.chuangshi.util.MQUtil;

public class WeChatController extends Controller {

    private final TradeService tradeService = new TradeService();
    private final AppService appService = new AppService();

    @ActionKey(Url.WECHAT_API_NOTIFY)
    public void notifyUrl() {
        String result = HttpKit.readData(getRequest());

        Map<String, String> map = PaymentKit.xmlToMap(result);

        String appid = (String) map.get("appid");
        String bank_type = (String) map.get("bank_type");
        String cash_fee = (String) map.get("cash_fee");
        String fee_type = (String) map.get("fee_type");
        String is_subscribe = (String) map.get("is_subscribe");
        String mch_id = (String) map.get("mch_id");
        String nonce_str = (String) map.get("nonce_str");
        String openid = (String) map.get("openid");
        String out_trade_no = (String) map.get("out_trade_no");
        String result_code = (String) map.get("result_code");
        String return_code = (String) map.get("return_code");
        String sign = (String) map.get("sign");
        String time_end = (String) map.get("time_end");
        String total_fee = (String) map.get("total_fee");
        String trade_type = (String) map.get("trade_type");
        String transaction_id = (String) map.get("transaction_id");

        SortedMap<String, String> parameter = new TreeMap<String, String>();
        parameter.put("appid", appid);
        parameter.put("bank_type", bank_type);
        parameter.put("cash_fee", cash_fee);
        parameter.put("fee_type", fee_type);
        parameter.put("is_subscribe", is_subscribe);
        parameter.put("mch_id", mch_id);
        parameter.put("nonce_str", nonce_str);
        parameter.put("openid", openid);
        parameter.put("out_trade_no", out_trade_no);
        parameter.put("result_code", result_code);
        parameter.put("return_code", return_code);
        parameter.put("time_end", time_end);
        parameter.put("total_fee", total_fee);
        parameter.put("trade_type", trade_type);
        parameter.put("transaction_id", transaction_id);

        // 根据订单号查询订单
        Trade trade = tradeService.findByTrade_number(out_trade_no);
        if (trade == null) {
            renderText(Constant.WX_FAIL_MSG);
        }
        App app = appService.findByApp_id(trade.getApp_id());
        if (app == null) {
            renderText(Constant.WX_FAIL_MSG);
        }
        String wx_app_id = app.getWechat_app_id();
        if (!appid.equals(wx_app_id)) {
            renderText(Constant.WX_FAIL_MSG);
        }
        String mch_key = app.getWechat_mch_key();

        String endsign = PaymentKit.createSign(parameter, mch_key);

        if (sign.equals(endsign)) {
            BigDecimal trade_amount = new BigDecimal(total_fee).divide(BigDecimal.valueOf(100));
            String trade_pay_type = PayType.WECHAT.getKey();
            String trade_pay_number = transaction_id;
            String trade_pay_account = openid;
            String trade_pay_time = time_end;
            String trade_pay_result = result;
            Boolean trade_status = true;

            boolean is_update = tradeService.updateSend(trade.getTrade_id(), trade.getUser_id(), trade_amount, trade_pay_type, trade_pay_number, trade_pay_account, trade_pay_time, trade_pay_result,
                    trade_status, trade.getSystem_version());

            if (is_update) {
                // TODO 消息队列通知计算账单和分成
                /*
                 * Map<String, Object> mqMap = new HashMap<String, Object>();
                 * mqMap.put(Trade.TRADE_ID, trade.getTrade_id());
                 * MQUtil.sendSync("tradePay", JSON.toJSONString(mqMap));
                 */
                MQUtil.sendSync("tradePay", trade.getTrade_id());
                renderText("");
            } else {
                renderText("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[]]></return_msg></xml>");
            }

        } else {
            renderText("<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[]]></return_msg></xml>");
        }
    }

}
