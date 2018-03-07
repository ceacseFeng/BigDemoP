package com.example.asus.bigdemoproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img_show;
    private Toolbar viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.set);
        img_show.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity(new Intent(MainActivity.this,CountDownActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void initView() {
        img_show = (ImageView) findViewById(R.id.img_show);
        viewById = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(viewById);
    }
}
