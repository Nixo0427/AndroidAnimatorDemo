package com.example.nixo.valueanimationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nixo.valueanimationtest.ActivityTransation.Main6Activity;
import com.example.nixo.valueanimationtest.Scenne.Main4Activity;
import com.example.nixo.valueanimationtest.deemo.Main3Activity;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.go2:
                startActivity(new Intent(this,Main2Activity.class));
                break;
            case R.id.go3:
                startActivity(new Intent(this, Main3Activity.class));
                break;
            case R.id.go4:
                startActivity(new Intent(this, Main4Activity.class));
                break;
            case R.id.go5:
                startActivity(new Intent(this, Main6Activity.class));
                break;
        }
    }
}
