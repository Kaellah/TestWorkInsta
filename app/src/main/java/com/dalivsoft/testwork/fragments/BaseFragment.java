package com.dalivsoft.testwork.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.activity.BaseActivity;
import com.dalivsoft.testwork.application.App;
import com.dalivsoft.testwork.application.AppSettings;
import com.octo.android.robospice.SpiceManager;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class BaseFragment extends Fragment  {

    // VALUE`s
    private App mApp;
    private AppSettings mSettings;
    private SpiceManager mSpiceManager;
    private BaseActivity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApp = (App) getActivity().getApplication();
        mActivity = (BaseActivity) getActivity();
        mSettings = mActivity.getSettings();
        mSpiceManager = mActivity.getRoboSpiceManager();
    }

    public AppSettings getSettings() {
        return mSettings;
    }

    public SpiceManager getSpiceManager() {
        return mSpiceManager;
    }

    public App getApp() {
        return mApp;
    }

    protected void startFragment(int resId, Fragment fragment, boolean addToStack, String stackTag) {
        mActivity.startFragment(resId, fragment, addToStack, stackTag, true);
    }

    protected void startFragment(Fragment fragment, boolean backStack) {
        startFragment(R.id.main_frame, fragment, backStack, ((Object) fragment).getClass().getSimpleName());
    }


}
