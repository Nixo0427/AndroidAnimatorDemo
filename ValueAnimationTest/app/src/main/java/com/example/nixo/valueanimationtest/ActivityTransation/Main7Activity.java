package com.example.nixo.valueanimationtest.ActivityTransation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.widget.ImageView;

import com.example.nixo.valueanimationtest.R;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent intent = getIntent();
        ImageView imageView = findViewById(R.id.m7img);
        imageView.setImageResource(intent.getIntExtra("resId",R.mipmap.ic_launcher));
        Transition transition = new Explode();
        transition.excludeChildren(android.R.id.statusBarBackground,true);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        getWindow().setReenterTransition(transition);
    }
}
