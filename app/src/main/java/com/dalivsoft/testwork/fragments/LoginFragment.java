package com.dalivsoft.testwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.domain.answer.UserAnswer;
import com.dalivsoft.testwork.network.GetUserRequest;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class LoginFragment extends BaseFragment implements OnClickListener {

    // VIEW`s
    private EditText mEtUserName;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.holo_blue_bright, R.color.holo_green_light,
                R.color.holo_orange_light, R.color.holo_red_light);
        mSwipeRefreshLayout.setEnabled(false);

        mEtUserName = (EditText) view.findViewById(R.id.et_username);
        view.findViewById(R.id.btn_get_collage).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_collage:
                getSpiceManager().execute(new GetUserRequest(getActivity().getApplicationContext(),
                        mEtUserName.getText().toString().trim()), mRequestListener);
                mSwipeRefreshLayout.setRefreshing(true);
                break;
            default:
                break;
        }
    }

    RequestListener mRequestListener = new RequestListener<UserAnswer>() {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            mSwipeRefreshLayout.setRefreshing(false);
        }

        @Override
        public void onRequestSuccess(UserAnswer userAnswer) {
            mSwipeRefreshLayout.setRefreshing(false);
            startFragment(UserListFragment.newInstance(userAnswer), true);
        }
    };
}
