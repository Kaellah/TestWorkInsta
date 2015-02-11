package com.dalivsoft.testwork.network;

import android.content.Context;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTokenNetworkMethod<T> extends BaseNetworkMethod<T> {


    public BaseTokenNetworkMethod(Context context, String url) {
        super(context, Boolean.class, url);
    }

    @Override
    protected TypeMethod getMethod() {
        return TypeMethod.POST;
    }

    @Override
    protected List<NameValuePair> getParams() {
        List<NameValuePair> params = new ArrayList<>();
        addParams(params);
        return params;
    }

    protected abstract void addParams(List<NameValuePair> params);


}
