package com.dalivsoft.testwork.domain.answer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public abstract class BaseAnswer<DATA> implements Serializable {

    private final static String KEY_META = "meta";
    private final static String KEY_DATA = "data";
    private final static String KEY_CODE = "code";

    private String mCode;
    private DATA mData;

    public BaseAnswer() {
    }

    public BaseAnswer(JsonObject jo) {
        if (jo.has(KEY_META)) {
            setCode(jo.get(KEY_META).getAsJsonObject());
        }
        if (jo.has(KEY_DATA)) {
            fillFromJsonNext(jo.get(KEY_DATA).getAsJsonObject());
        }
    }

    protected abstract DATA getDataFromJsonElement(JsonElement je);

    protected abstract void fillFromJsonNext(JsonObject jo);

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

