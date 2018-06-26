package com.example.nixo.valueanimationtest.ActivityTransation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.util.Pair;
import android.view.View;

import com.example.nixo.valueanimationtest.R;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener{

    int resid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im1:
                resid = R.drawable.a11;
                    break;
            case R.id.im2:
                resid = R.drawable.a22;
                break;
            case R.id.im3:
                resid = R.drawable.a33;
                break;
            case R.id.im4:
                resid = R.drawable.b;
                break;
        }

        Intent intent = new Intent(this,Main7Activity.class);
        intent.putExtra("resId",resid);
        Transition transition = new Explode();
        transition.excludeChildren(android.R.id.statusBarBackground,true);
        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);
        getWindow().setReenterTransition(transition);
        Pair<View,String> pair = Pair.create(v,"image");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,pair);
        startActivity(intent,options.toBundle());
    }

}
