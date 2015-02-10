package com.dalivsoft.testwork.network;

import android.content.Context;

import com.dalivsoft.testwork.application.AppSettings;
import com.dalivsoft.testwork.system.Constants;
import com.dalivsoft.testwork.system.SharedStrings;
import com.dalivsoft.testwork.system.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.octo.android.robospice.request.SpiceRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public abstract class BaseNetworkMethod<T> extends SpiceRequest<T> implements SharedStrings{

    private final JsonParser mJsonParser;
    protected final Context mContext;
    protected final AppSettings mAppSettings;

    protected String mUrl;
//    private LogSender mLogSender;

    public static enum TypeMethod {
        POST, GET;
    }

    protected abstract T onParseResult(JsonElement element);

    protected abstract TypeMethod getMethod();

    protected abstract List<NameValuePair> getParams();

    public BaseNetworkMethod(Context context, Class clazz, String url) {
        super(clazz);
        mContext = context;
        mAppSettings = AppSettings.getInstance(context);
        mJsonParser = new JsonParser();
        mUrl = url;
//        mLogSender = LogSender.getInstance();
    }

    @Override
    public T loadDataFromNetwork() throws Exception {
        InputStream source = retrieveStream(mUrl);
        Reader reader = new InputStreamReader(source);
        JsonElement json = mJsonParser.parse(reader);
//        if (Constants.DEBUG) {
//            Utils.toLog(json.toString());
//        }
//        mLogSender.addToLog(json.toString());
        T response = onParseResult(json);

        return response;
    }

    private InputStream retrieveStream(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        InputStream content;
        try {
            HttpResponse response = null;
            HttpEntity httpEntity;
            switch (getMethod()) {
                case GET:
                    if (getParams() != null) {
                        String paramString = URLEncodedUtils.format(getParams(), HTTP.UTF_8);
                        url += "?" + paramString;
                    }
//                    if (Constants.DEBUG) {
//                        Utils.toLog(url);
//                    }
                    HttpGet httpGet = new HttpGet(url);
                    response = client.execute(httpGet);
                    break;
                case POST:

                    HttpPost httpPost = new HttpPost(url);
                    List<NameValuePair> params = getParams();
                    httpEntity = new UrlEncodedFormEntity(params, HTTP.UTF_8);
                    httpPost.setEntity(httpEntity);
//                    AccessToken token = getAccessToken(client);
//                    httpPost.addHeader(Constants.TOKEN_HEADER_BODY_NAME, token.getTypeToken() + " " + token.getToken());
//                    debugNetwork(params, token);
                    if (Constants.DEBUG) {
                        streamToLogCat(httpEntity.getContent(), true);
                    }
                    response = client.execute(httpPost);
                    break;
            }
            httpEntity = response.getEntity();
            content = httpEntity.getContent();
            return content;
        } catch (UnsupportedEncodingException e) {
//            mLogSender.addToLog(e.getMessage());
            e.printStackTrace();
        } catch (ClientProtocolException e) {
//            mLogSender.addToLog(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
//            mLogSender.addToLog(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

//    private void debugNetwork(List<NameValuePair> params, AccessToken token) {
//        String par = "";
//        if (!params.isEmpty()) {
//            par += "-d\"";
//            for (NameValuePair val : params) {
//                par += val.getName() + "=" + val.getValue() + "&";
//            }
//            par += "\"";
//        }
//        String msg = "curl  --header \"" + Constants.TOKEN_HEADER_BODY_NAME + ": " + token.getTypeToken() + " " + token.getToken() + "\" " + par + " " + mUrl;
//        mLogSender.addToLog(msg);
//        Log.d("netlog", msg);
//    }

//    private AccessToken getAccessToken(DefaultHttpClient client) throws IOException {
//        AccessToken accessToken = mAppSettings.getAccessToken();
//        if (accessToken == null || accessToken.isExpired()) {
//            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//            nameValuePairs.add(new BasicNameValuePair(Constants.TOKEN_GRANT_TYPE_NAME, Constants.TOKEN_GRANT_TYPE_VALUE));
//            nameValuePairs.add(new BasicNameValuePair(Constants.TOKEN_SCOPE_NAME, Constants.TOKEN_SCOPE_VALUE));
//            HttpPost httpPost = new HttpPost(Constants.URL_GET_ACCESS_TOKEN);
//            httpPost.addHeader(Constants.TOKEN_HEADER_BODY_NAME, Constants.TOKEN_HEADER_BODY_VALUE);
//            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//            HttpResponse response = client.execute(httpPost);
//            JsonElement json = mJsonParser.parse(new InputStreamReader(response.getEntity().getContent()));
//            accessToken = new AccessToken(json);
//            mAppSettings.setAccessToken(accessToken);
//        }
//        return accessToken;
//    }

    private void streamToLogCat(InputStream stream, boolean close) throws IOException {
        streamToLogCat(new InputStreamReader(stream), close);
    }

    private void streamToLogCat(InputStreamReader stream, boolean close) throws IOException {
        final BufferedReader reader = new BufferedReader(stream);

        final StringBuilder sb = new StringBuilder();
        if (close) {
            sb.append(mUrl);
            sb.append(SharedStrings.SLASH_C);
        }

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        Utils.toLog(sb);
        if (close) {
            reader.close();
        }
    }
}
