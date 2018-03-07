package com.example.asus.bigdemoproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.asus.bigdemoproject.R;
import com.example.asus.bigdemoproject.adapter.LinkmanAdapter;
import com.example.asus.bigdemoproject.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LinkmanFragment extends Fragment {


    private ExpandableListView expand_link;
    private List<List<Person>> childList;
    private List<String> groupList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_linkman, container, false);
        initView(inflate);
        initData();
        initAdapter();
        return inflate;
    }

    private void initAdapter() {
        LinkmanAdapter adapter = new LinkmanAdapter(groupList,childList,getActivity());
        expand_link.setAdapter(adapter);
    }

    private void initData() {
        groupList = new ArrayList<>();
        groupList.add("我的家人");
        groupList.add("我的朋友");
        groupList.add("我的同学");

        childList = new ArrayList<>();

        List<Person> familyList = new ArrayList<>();
        familyList.add(new Person(R.mipmap.ic_launcher,"爸爸"));
        familyList.add(new Person(R.mipmap.ic_launcher,"妈妈"));
        familyList.add(new Person(R.mipmap.ic_launcher,"姐姐"));

        List<Person> friendLlist = new ArrayList<>();
        friendLlist.add(new Person(R.mipmap.ic_launcher,"小张"));
        friendLlist.add(new Person(R.mipmap.ic_launcher,"小李"));
        friendLlist.add(new Person(R.mipmap.ic_launcher,"小林"));

        List<Person> schoolmateList = new ArrayList<>();
        schoolmateList.add(new Person(R.mipmap.ic_launcher,"白武阳"));
        schoolmateList.add(new Person(R.mipmap.ic_launcher,"李星旺"));
        schoolmateList.add(new Person(R.mipmap.ic_launcher,"贾吉祥"));

        childList.add(familyList);
        childList.add(friendLlist);
        childList.add(schoolmateList);

    }

    private void initView(View inflate) {
        expand_link = (ExpandableListView) inflate.findViewById(R.id.expand_link);
    }
}
