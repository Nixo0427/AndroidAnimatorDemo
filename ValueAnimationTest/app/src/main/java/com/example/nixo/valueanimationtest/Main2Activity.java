package com.example.nixo.valueanimationtest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewAnimationUtils;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends Activity implements View.OnClickListener {

    ImageView imageView ;
    Button loading;
    Button roback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.image);
        loading = findViewById(R.id.loadding);
        roback = findViewById(R.id.roback);
        imageView.setVisibility(View.GONE);
        loading.setOnClickListener(this);
        roback.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loadding:{
                int w = imageView.getWidth();
                int h = imageView.getHeight();
                int x = w ;
                int y = h;
                int r = (int) Math.hypot(w,h);
                Animator loadding = ViewAnimationUtils.createCircularReveal(imageView,x,y,0,r);
                loadding.setDuration(2000);
                imageView.setVisibility(View.VISIBLE);
                loadding.start();
                break;
            }
            case R.id.roback:{
                int w = imageView.getWidth();
                int h = imageView.getHeight();
                int x = w;
                int y = h;
                int r = (int ) Math.hypot(w,h);
                Animator roback = ViewAnimationUtils.createCircularReveal(imageView,x,y,r,0);
                roback.setDuration(2000);
                roback.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        imageView.setVisibility(View.GONE);
                    }
                });
                roback.start();
                break;
            }

        }
    }
}
