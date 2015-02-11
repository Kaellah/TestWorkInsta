package com.dalivsoft.testwork.activity;

import android.os.Bundle;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.fragments.LoginFragment;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        startFragment(LoginFragment.newInstance(), false);
    }


}
