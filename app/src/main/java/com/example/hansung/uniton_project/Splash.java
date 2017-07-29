package com.example.hansung.uniton_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hansung.uniton_project.Login.LoginActivity;

/**
 * Created by HANSUNG on 2017-07-29.
 */

public class Splash extends AppCompatActivity {

    private static final int DELAY_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startActivity(new Intent(this, LoginActivity.class));
        try{
            Thread.sleep(DELAY_TIME);
        }catch(Exception e){};
        this.finish();
    }
}
