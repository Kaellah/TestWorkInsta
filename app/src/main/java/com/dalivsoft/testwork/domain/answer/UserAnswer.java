package com.dalivsoft.testwork.domain.answer;

import com.dalivsoft.testwork.domain.User;
import com.dalivsoft.testwork.utitly.JsonArrayParser;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class UserAnswer implements Serializable {

    private final static String KEY_META = "meta";
    private final static String KEY_DATA = "data";
    private final static String KEY_CODE = "code";

    private String mCode;
    private List<User> mUserList;

    public UserAnswer() {
    }

    public UserAnswer(JsonElement je) {
        JsonObject jo = je.getAsJsonObject();
        if (jo.has(KEY_META)) {
            setCode(jo.get(KEY_META).getAsJsonObject());
        }
        if (jo.has(KEY_DATA)) {
            if (jo.get(KEY_DATA).isJsonArray()) {
                mUserList = new ArrayList<>();
                JsonArray jsonArray = jo.get(KEY_DATA).getAsJsonArray();
                List<User> list = new JsonArrayParser<User>().parse(jsonArray, new JsonArrayParser.ClassFactory<User>() {
                    @Override
                    public User createObject(JsonElement jsonElement) {
                        return new User(jsonElement);
                    }
                });
                setUserList(list);
            }
        }
    }

    public String getCode() {
        return mCode;
    }

    public void setCode(JsonObject jo) {
        if (jo.has(KEY_CODE)) {
            mCode = jo.get(KEY_CODE).getAsString();
        }
    }

    public List<User> getUserList() {
        return mUserList;
    }

    public void setUserList(List<User> userList) {
        mUserList = userList;
    }
}
