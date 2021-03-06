package com.nowui.chuangshi.type;

public enum StockType {
    APP("APP", "应用"),
    MEMBER("MEMBER", "会员");

    private String key;
    private String value;

    private StockType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
