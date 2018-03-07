package com.example.asus.bigdemoproject.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.bigdemoproject.R;
import com.example.asus.bigdemoproject.adapter.NewsAdapter;
import com.example.asus.bigdemoproject.bean.NewsBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView recyler_news;
    private String path;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {

        private NewsBean[] newsBeans;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String jsonString = (String) msg.obj;

            newsBeans = new Gson().fromJson(jsonString, NewsBean[].class);

            List<NewsBean> list = new ArrayList<>();
            for (int i = 0; i < newsBeans.length; i++) {

                list.add(newsBeans[i]);
            }

            LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
            recyler_news.setLayoutManager(manager);

            NewsAdapter adapter = new NewsAdapter(list,getActivity());
            recyler_news.setAdapter(adapter);



        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_news, container, false);
        getData();
        initView(inflate);
        return inflate;
    }

    private void getData() {
       new Thread(new Runnable() {
           @Override
           public void run() {
               path = "http://192.168.1.19/json/array2.json";
               try {
                   URL url = new URL(path);
                   HttpURLConnection con = (HttpURLConnection) url.openConnection();
                   con.connect();
                   if (con.getResponseCode() == 200) {
                       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                       StringBuffer stringBuffer = new StringBuffer();
                       String temp = null;

                       while ((temp = bufferedReader.readLine()) != null) {
                           stringBuffer.append(temp);
                       }
                       handler.obtainMessage(1, stringBuffer.toString()).sendToTarget();
                   }
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }


    private void initView(View inflate) {
        recyler_news = inflate.findViewById(R.id.reclyer_news);
    }
}
