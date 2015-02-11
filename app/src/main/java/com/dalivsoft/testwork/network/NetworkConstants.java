package com.dalivsoft.testwork.network;

import org.apache.http.protocol.HTTP;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class NetworkConstants {

    /**
     * Instagram API values
     */
    public final static String CLIENT_ID = "1aa0d112cfce486ea902f3202706088d";
    public final static String CLIENT_SECRET = "434eefa9561c4c3fb32b6ff4c3f937f6";
    public final static String REDIRECT_URI = "http://localhost";

    /**
     * URL`s
     */
    public static final String URL_AUTH = "https://api.instagram.com/oauth/authorize/";
    public static final String URL_TOKEN = "https://api.instagram.com/oauth/access_token";
    public static final String URL_API = "https://api.instagram.com/v1";
    public static final String URL_SEARCH = URL_API + "/users/search";
    public static final String URL_PHOTOS = "https://api.instagram.com/v1/users/{user-id}/media/recent";

    public final static String client_id = "client_id";
    public final static String client_secret = "client_secret";
    public final static String grant_type = "grant_type";
    public final static String authorization_code = "authorization_code";
    public final static String code = "code";
    public final static String redirect_uri = "redirect_uri";
    public final static String response_type = "response_type";

    public static final String HTTP_Header = "HTTP Header: X-Insta-Forwarded-For";

    public static final String URL_GET_ACCESS_TOKEN = URL_AUTH + "?" + client_id + "=" + CLIENT_ID + "&" +
            redirect_uri + "=" + REDIRECT_URI + "&" + response_type + "=token";

}
