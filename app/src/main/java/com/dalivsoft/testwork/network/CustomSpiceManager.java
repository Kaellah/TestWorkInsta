package com.dalivsoft.testwork.network;

import android.content.Context;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.activity.BaseActivity;
import com.dalivsoft.testwork.system.Utils;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.request.CachedSpiceRequest;
import com.octo.android.robospice.request.SpiceRequest;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class CustomSpiceManager extends SpiceManager {

    private Context mContext;

    public CustomSpiceManager(Class<? extends SpiceService> spiceServiceClass, Context context) {
        super(spiceServiceClass);
        mContext = context;
    }

    @Override
    public <T> void execute(SpiceRequest<T> request, RequestListener<T> requestListener) {
        if (Utils.isInternetAvailable(mContext)) {
            super.execute(request, requestListener);
        } else {
            ((BaseActivity) mContext).showMessage(R.string.setf_network_error);
        }
    }

    @Override
    public <T> void execute(CachedSpiceRequest<T> cachedSpiceRequest, RequestListener<T> requestListener) {
        if (Utils.isInternetAvailable(mContext)) {
            super.execute(cachedSpiceRequest, requestListener);
        } else {
            ((BaseActivity) mContext).showMessage(R.string.setf_network_error);
        }
    }

    @Override
    public <T> void execute(SpiceRequest<T> request, Object requestCacheKey, long cacheExpiryDuration, RequestListener<T> requestListener) {
        if (Utils.isInternetAvailable(mContext)) {
            super.execute(request, requestCacheKey, cacheExpiryDuration, requestListener);
        } else {
            ((BaseActivity) mContext).showMessage(R.string.setf_network_error);
        }
    }
}
