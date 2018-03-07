package com.example.asus.bigdemoproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CountDownActivity extends AppCompatActivity {

    private TextView tv_show;
    private Handler han= new Handler(){};
    Runnable runnable = new Runnable(){
    int a =5;
        @Override
        public void run() {
            a--;
            tv_show.setText(a+"");

            if (a>0) {
                han.postDelayed(runnable,1000);
            }else {

                startActivity(new Intent(CountDownActivity.this,ShouDastaActivity.class));
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        initView();
        showData();
    }

    private void showData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                han.postDelayed(runnable,1000);
            }
        }).start();
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);

    }
}
