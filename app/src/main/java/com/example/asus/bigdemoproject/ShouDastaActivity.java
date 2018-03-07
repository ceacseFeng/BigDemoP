package com.example.asus.bigdemoproject;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.asus.bigdemoproject.fragment.NewsFragment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ShouDastaActivity extends AppCompatActivity {

    private FrameLayout frag;
    private RadioButton btn_news;
    private RadioButton btn_linkman;
    private RadioButton btn_students;
    private FragmentManager supportFragmentManager;
    private FragmentManager manager;
    private RadioGroup radio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_dasta);
        initView();
        initData();
        initListener();

    }

    private void initListener() {

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.btn_news:
                        break;
                    case R.id.btn_linkman:
                        break;
                   
                }
            }
        });
    }

    private void initData() {

        NewsFragment newsFragment = new NewsFragment();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.frag,newsFragment);
        transaction.commit();
    }

    private void initView() {
        frag = (FrameLayout) findViewById(R.id.frag);
        btn_news = (RadioButton) findViewById(R.id.btn_news);
        btn_linkman = (RadioButton) findViewById(R.id.btn_linkman);
        btn_students = (RadioButton) findViewById(R.id.btn_students);
        radio = (RadioGroup) findViewById(R.id.radio);

    }
}
