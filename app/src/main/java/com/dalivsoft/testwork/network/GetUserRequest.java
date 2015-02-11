package com.dalivsoft.testwork.network;

import android.content.Context;

import com.dalivsoft.testwork.domain.answer.BaseAnswer;
import com.dalivsoft.testwork.domain.answer.UserAnswer;
import com.google.gson.JsonElement;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class GetUserRequest extends BaseTokenNetworkMethod<UserAnswer> {

    private final static String USER_NAME = "q";

    private String mUserName;

    public GetUserRequest(Context context, String userName) {
        super(context, NetworkConstants.URL_SEARCH);
        mUserName = userName;
    }

    @Override
    protected TypeMethod getMethod() {
        return TypeMethod.GET;
    }

    @Override
    protected void addParams(List<NameValuePair> params) {
        params.add(new BasicNameValuePair(USER_NAME, mUserName));
        params.add(new BasicNameValuePair(NetworkConstants.client_id, NetworkConstants.CLIENT_ID));
    }

    @Override
    protected UserAnswer onParseResult(JsonElement element) {
        return new UserAnswer(element);
    }
}
