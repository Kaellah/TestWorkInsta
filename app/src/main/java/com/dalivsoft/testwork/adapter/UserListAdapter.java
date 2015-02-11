package com.dalivsoft.testwork.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalivsoft.testwork.R;
import com.dalivsoft.testwork.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cheakshov R.(email:roman_woland@mail.ru)
 */
public class UserListAdapter extends BaseAdapter {

    class ViewHolder {
        TextView tvUserName;
    }

    // VALUE`s
    private List<User> mUserList;

    public UserListAdapter() {
        mUserList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mUserList.size();
    }

    @Override
    public User getItem(int position) {
        return mUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_user_list, parent, false);
            viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tv_username);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvUserName.setText(getItem(position).getUserName());
        return convertView;
    }

    public void setData(List<User> userList) {
        mUserList = userList;
    }
}
