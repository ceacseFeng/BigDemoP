package com.example.asus.bigdemoproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.bigdemoproject.R;
import com.example.asus.bigdemoproject.bean.Person;

import java.util.List;

/**
 * Created by ASUS on 2017/12/28.
 */

public class LinkmanAdapter extends BaseExpandableListAdapter {
    List<String> mgroupList;
    List<List<Person>> mchildList;
    Context mcontext;

    public LinkmanAdapter(List<String> mgroupList, List<List<Person>> mchildList, Context mcontext) {
        this.mgroupList = mgroupList;
        this.mchildList = mchildList;
        this.mcontext = mcontext;
    }

    @Override
    public int getGroupCount() {
        return mgroupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mchildList.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return mgroupList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return mchildList.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.item_group, null);
        TextView name = inflate.findViewById(R.id.tv_group_name);
        name.setText(mgroupList.get(i));
        return inflate;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(mcontext).inflate(R.layout.item_child, null);
        TextView name = inflate.findViewById(R.id.tv_child_name);
        ImageView img_head = inflate.findViewById(R.id.img_head);
        name.setText(mchildList.get(i).get(i1).getName());
        img_head.setImageResource(mchildList.get(i).get(i1).getImg());
        return inflate;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
