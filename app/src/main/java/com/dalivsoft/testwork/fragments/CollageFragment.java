package com.dalivsoft.testwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dalivsoft.testwork.domain.User;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class CollageFragment extends BaseFragment {

    private final static String EXTRA_USER = "EXTRA_USER";

    public static CollageFragment newInstance(User user) {
        Bundle b = new Bundle(1);
        b.putSerializable(EXTRA_USER, user);

        CollageFragment fragment = new CollageFragment();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
