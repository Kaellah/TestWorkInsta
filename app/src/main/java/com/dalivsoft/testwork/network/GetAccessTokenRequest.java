package com.dalivsoft.testwork.network;

import android.content.Context;

import com.google.gson.JsonElement;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class GetAccessTokenRequest extends BaseTokenNetworkMethod<String> {


    public GetAccessTokenRequest(Context context) {
        super(context, NetworkConstants.URL_GET_ACCESS_TOKEN);
    }

    @Override
    protected String onParseResult(JsonElement element) {
        if (element.isJsonNull()) {
            return null;
        }
        return element.toString();
    }

    @Override
    protected TypeMethod getMethod() {
        return TypeMethod.POST;
    }

    @Override
    protected void addParams(List<NameValuePair> params) {

    }
}
