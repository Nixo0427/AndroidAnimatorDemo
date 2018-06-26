package com.example.nixo.valueanimationtest.Scenne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nixo.valueanimationtest.R;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    ViewGroup mScenneViewGroup;
    Scene scene1;
    Scene scene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mScenneViewGroup = findViewById(R.id.scene_root);
        scene1 = Scene.getSceneForLayout(mScenneViewGroup,R.layout.senne_one,getBaseContext());
        scene2 = Scene.getSceneForLayout(mScenneViewGroup,R.layout.scenne_two,getBaseContext());


        TransitionManager.go(scene1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go_scenne1:
                Transition   transition = TransitionInflater.from(getBaseContext()).inflateTransition(R.transition.transition);
                TransitionManager.go(scene1,transition);
                break;
            case R.id.go_scenne2:

                TransitionManager.go(scene2);
                break;
        }
    }
}
