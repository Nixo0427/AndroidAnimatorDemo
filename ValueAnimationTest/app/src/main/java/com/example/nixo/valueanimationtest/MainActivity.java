package com.example.nixo.valueanimationtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    ImageView button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:{
//                ValueAnimator练习↓↓↓↓↓
//                final ValueAnimator animator = ValueAnimator.ofInt(0,100);
//                animator.setDuration(1000);
//                animator.setInterpolator(new LinearInterpolator());
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float animatedFraction = animator.getAnimatedFraction();
//                        int animatedValue = (int) animation.getAnimatedValue();
//                        Log.d("JSY","属性值"+animatedFraction+"变化值"+animatedValue);
//                    }
//                });
//                animator.start();

//            ObjectAnimator练习
//                Animator animator = AnimatorInflater.loadAnimator(this,R.animator.aplha);
//                animator.setTarget(v);
//                animator.start();
//                 ObjectAnimator.ofFloat(v,"scaleY",1.0f,2.0f).start();

                //viewPropertyAnimator练习
//                v.animate().translationY(300f).setDuration(1000).start();


//                Animator Set方法练习
//                  方法1
                Animator animatorAlpha = ObjectAnimator.ofFloat(v,"alpha",1.0f,0.0f);
                Animator animatorRoation = ObjectAnimator.ofFloat(v,"rotation",0,360);
                AnimatorSet set = new AnimatorSet();
                set.playSequentially(animatorRoation,animatorAlpha);
                set.setDuration(2000);
                set.start();
//                Animator Set实现方法2 利用view.animate来进行Set方法
                v.animate().rotation(360).setDuration(2000).start();
                v.animate().alpha(0.0f).setDuration(2000).setStartDelay(2000).start();

            }
        }
    }
}
