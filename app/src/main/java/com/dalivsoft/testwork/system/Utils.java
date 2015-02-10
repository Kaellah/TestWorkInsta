package com.dalivsoft.testwork.system;

import android.content.Context;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class Utils implements SharedStrings {

    public static void toLog(String s) {
        if (Constants.DEBUG) {
            try {
                Log.d(Constants.LOG_TAG, s);

            } catch (Exception e) {
                toLog(NULL);
            }
        }
    }

    public static void toLog(Object o) {
        toLog(String.valueOf(o));
    }

    public static void toLog(PointF p) {
        toLog("PointF\tx = " + p.x + "\ty = " + p.y);
    }

    public static void toLog(Throwable e) {
        final StringBuilder sb = new StringBuilder();

        sb.append(e.getMessage());
        sb.append(NEW_LINE_C);
        sb.append(e.getClass().getName());

        for (StackTraceElement s : e.getStackTrace()) {
            sb.append(NEW_LINE_C);
            sb.append(s.toString());
        }

        toLog(sb);
    }

    /**
     * Checks the device to see if Internet is available either through wifi or network.
     *
     * @param context Context. Usually something like Activity.this
     * @return False if there's no connection. True otherwise.
     */
    public static Boolean isInternetAvailable(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo network = connec.getActiveNetworkInfo();
        if (network == null)
            return false;
        return network.isAvailable();
    }
}
