package com.example.nixo.valueanimationtest.deemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import com.example.nixo.valueanimationtest.R;

public class Main3Activity extends Activity {


    ImageView imageView;
    boolean isGo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        imageView = findViewById(R.id.mImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isGo){
                    back();
                }else{
                    go();
                }
            }
        });
    }



    private void go(){
        int w  = imageView.getWidth();
        int h = imageView.getHeight();
        int x = w/2;
        int y = h/2;
        int sr = (int) Math.sqrt((w*w)+(h*h));

        Animator go = ViewAnimationUtils.createCircularReveal(imageView,x,y,sr,30);
        go.setDuration(500);
        go.start();
        go.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.animate().translationY( - imageView.getTop()).start();
                int w  = imageView.getWidth();
                int h = imageView.getHeight();
                int x = w/2;
                int y = h/2;
                int sr = (int) Math.sqrt((w*w)+(h*h));
                float scaleX =(imageView.getWidth() / imageView.getX() );
                AnimatorSet set1 = new AnimatorSet();
                set1.playTogether(ViewAnimationUtils.createCircularReveal(imageView,x,y,0,sr)
                        ,ObjectAnimator.ofFloat(imageView,"scaleX",0.0f,scaleX)
                        ,ObjectAnimator.ofFloat(imageView,"scaleY",0.0f,scaleX)
                );
                set1.setDuration(500);
                set1.start();
                isGo = true;
            }
        });
    }

    private void back(){
        int w  = imageView.getWidth();
        int h = imageView.getHeight();
        int x = w/2;
        int y = h/2;
        int sr = (int) Math.sqrt((w*w)+(h*h));
        Animator back = ViewAnimationUtils.createCircularReveal(imageView,x,y,sr,30);
        back.setDuration(500);
        back.start();
        back.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                imageView.animate().translationY(  imageView.getY() / 2).start();
                int w  = imageView.getWidth();
                int h = imageView.getHeight();
                int x = w/2;
                int y = h/2;
                int sr = (int) Math.sqrt((w*w)+(h*h));
                int er = 30;

                float scaleX =( imageView.getX()/ imageView.getWidth() );


                AnimatorSet set1 = new AnimatorSet();
                set1.playTogether(ObjectAnimator.ofFloat(imageView,"alpha",0.0f,1.0f),
                        ViewAnimationUtils.createCircularReveal(imageView,x,y,0,sr)
                        ,ObjectAnimator.ofFloat(imageView,"scaleX",0.0f,scaleX)
                        ,ObjectAnimator.ofFloat(imageView,"scaleY",0.0f,scaleX)
                );
                set1.setDuration(500);
                set1.start();
                isGo = false;
            }
        });
    }


}
