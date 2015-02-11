package com.dalivsoft.testwork.domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class BaseDomain<DATA> implements Serializable {

    private final static String KEY_META = "meta";
    private final static String KEY_DATA = "data";
    private final static String KEY_CODE = "code";

    protected String mCode;
    protected DATA mData;

    public BaseDomain() {
    }

    public BaseDomain(JsonElement element) {
        JsonObject jo = element.getAsJsonObject();
        if (jo.has(KEY_META)) {
            setCode(jo.get(KEY_META).getAsJsonObject());
        }

//        setData(jo.get(KEY_DATA));
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(JsonObject jo) {
        if (jo.has(KEY_CODE)) {
            mCode = jo.get(KEY_CODE).getAsString();
        }
    }

    public DATA getData() {
        return mData;
    }

    public void setData(DATA data) {
        mData = data;
    }
}
