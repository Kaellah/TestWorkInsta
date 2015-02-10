package com.dalivsoft.testwork.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.application.App;
import com.dalivsoft.testwork.application.AppSettings;
import com.dalivsoft.testwork.network.CustomSpiceManager;
import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.UncachedSpiceService;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class BaseActivity extends ActionBarActivity {

    // VALUE`s
    protected App mApp;
    protected AppSettings mSettings;
//    private static Toast sToast;
    private SpiceManager mSpiceManager = new CustomSpiceManager(UncachedSpiceService.class, this);

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        mApp = (App) getApplication();
        mSettings = mApp.getSettings();
        super.onCreate(savedInstanceState, persistentState);
    }

    public AppSettings getSettings() {
        return mSettings;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mSpiceManager.isStarted()) {
            mSpiceManager.start(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mSpiceManager.isStarted()) {
            mSpiceManager.shouldStop();
        }
    }

    public void startFragment(int resId, Fragment fragment,
                              boolean addToStack, String stackTag, boolean animation) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (animation)
            ft.setCustomAnimations(R.anim.slidein_right, R.anim.slideout_left,
                    R.anim.slidein_left, R.anim.slideout_right);
        ft.replace(resId, fragment, stackTag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        if (addToStack) {
            ft.addToBackStack(stackTag);
        }
        ft.commitAllowingStateLoss();
    }

    protected void startFragment(Fragment fragment, boolean backStack, boolean animation) {
        startFragment(R.id.main_frame, fragment, backStack, ((Object) fragment).getClass().getSimpleName(), animation);
    }

    public void startFragment(Fragment fragment, boolean backStack) {
        startFragment(R.id.main_frame, fragment, backStack, ((Object) fragment).getClass().getSimpleName(), true);
    }

    public SpiceManager getRoboSpiceManager() {
        return mSpiceManager;
    }

    public void showMessage(String msg) {
        showToast(msg);
    }

    public void showMessage(int idStr) {
        showToast(getString(idStr));
    }

    private void showToast(String msg) {
        Toast.makeText(mApp.getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
