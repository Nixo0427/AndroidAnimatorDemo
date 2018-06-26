package com.example.nixo.framelayoutdrawableainimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    View v1;
    View v2;
    View v3;
    Button refrsph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1  = findViewById(R.id.view);
        v2  = findViewById(R.id.view2);
        v3  = findViewById(R.id.view3);
        refrsph = findViewById(R.id.refrsh);
        refrsph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view:
            case R.id.view2:
            case R.id.view3:


                AnimationDrawable drawable = (AnimationDrawable) v1.getBackground();
                AnimationDrawable drawable2 = (AnimationDrawable) v2.getBackground();
                AnimationDrawable drawable3 = (AnimationDrawable) v3.getBackground();

                final Animation aphla = AnimationUtils.loadAnimation(this,R.anim.aphla);
                final Animation scale = AnimationUtils.loadAnimation(this,R.anim.scale);
                final Animation set = AnimationUtils.loadAnimation(this,R.anim.set);
                final Animation trsation = AnimationUtils.loadAnimation(this,R.anim.trsation);
                final Animation trsation2 = AnimationUtils.loadAnimation(this,R.anim.trsation);
                trsation.setInterpolator(new LinearInterpolator());
                trsation.setInterpolator(new AccelerateInterpolator());
                v1.setAnimation(trsation);
                v2.setAnimation(trsation2);
                v3.setAnimation(set);
                drawable.start();
                drawable2.start();
                drawable3.start();
        }
    }
}
