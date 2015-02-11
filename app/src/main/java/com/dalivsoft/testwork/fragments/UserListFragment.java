package com.dalivsoft.testwork.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.adapter.UserListAdapter;
import com.dalivsoft.testwork.domain.User;
import com.dalivsoft.testwork.domain.answer.UserAnswer;

import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class UserListFragment extends BaseFragment implements OnItemClickListener {

    private final static String EXTRA_USER_ANSWER = "EXTRA_USER_ANSWER";

    // VALUE`s
    private List<User> mUserList;

    // ADAPTER
    private UserListAdapter mAdapter;

    public static UserListFragment newInstance(UserAnswer userAnswer) {
        Bundle b = new Bundle(1);
        b.putSerializable(EXTRA_USER_ANSWER, userAnswer);
        UserListFragment fragment = new UserListFragment();
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().getSerializable(EXTRA_USER_ANSWER) != null) {
            mUserList = ((UserAnswer) getArguments().getSerializable(EXTRA_USER_ANSWER)).getUserList();
        }
        mAdapter = new UserListAdapter();
        mAdapter.setData(mUserList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView lv = (ListView) view.findViewById(R.id.lv_users);
        lv.setAdapter(mAdapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startFragment(CollageFragment.newInstance(mUserList.get(position)), true);
    }
}
