package com.dalivsoft.testwork.domain;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class AccessToken implements Serializable {

    private String mToken;
    private int mExpiresIn;
    private long mExpiresTime;
    private String mTypeToken;
    private String mScope;

    public AccessToken() {
    }

    public AccessToken(JsonElement je) {
        JsonObject jo = je.getAsJsonObject();
//        if (jo.has("access_token")) {
//            if (!jo.get("access_token").isJsonNull()) {
//                setToken(jo.get("access_token").getAsString());
//            }
//        }
//
//        if (jo.has("expires_in")) {
//            if (!jo.get("expires_in").isJsonNull()) {
//                setExpiresIn(jo.get("expires_in").getAsInt());
//                setExpiresTime(System.currentTimeMillis());
//            }
//        }
//
//        if (jo.has("token_type")) {
//            if (!jo.get("token_type").isJsonNull()) {
//                setTypeToken(jo.get("token_type").getAsString());
//            }
//        }
//
//        if (jo.has("scope")) {
//            if (!jo.get("scope").isJsonNull()) {
//                setScope(jo.get("scope").getAsString());
//            }
//        }
    }

    public boolean isExpired() {
        if (System.currentTimeMillis() > (mExpiresTime * 1000) + mExpiresIn) {
            return true;
        } else {
            return false;
        }
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public int getExpiresIn() {
        return mExpiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        mExpiresIn = expiresIn;
    }

    public String getTypeToken() {
        return mTypeToken;
    }

    public void setTypeToken(String typeToken) {
        mTypeToken = typeToken;
    }

    public String getScope() {
        return mScope;
    }

    public void setScope(String scope) {
        mScope = scope;
    }

    public long getExpiresTime() {
        return mExpiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        mExpiresTime = expiresTime;
    }
}
