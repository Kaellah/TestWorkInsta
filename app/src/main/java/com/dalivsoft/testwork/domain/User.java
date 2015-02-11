package com.dalivsoft.testwork.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class User implements Serializable {

    private final static String ID = "id";
    private final static String USER_NAME = "username";
    private final static String BIO = "bio";
    private final static String FULL_NAME = "full_name";
    private final static String PROFILE_PICTURE = "profile_picture";

    private String mId;
    private String mUserName;

    public User() {
    }

    public User(JsonElement je) {
        JsonObject jo = je.getAsJsonObject();
        if (jo.has(ID)) {
            setId(jo.get(ID).getAsString());
        }
        if (jo.has(USER_NAME)) {
            setUserName(jo.get(USER_NAME).getAsString());
        }
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }
}
