package com.example.carepath;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Handler;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(this,2000);
    }

    @Override
    public void run() {

        Prefs prefs = new Prefs(this);
        if(!TextUtils.isEmpty(prefs.getUser())){
            startActivity(new Intent(SplashScreen.this,MainActivity.class));
            finish();
        }else{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }


       //

    }
}
