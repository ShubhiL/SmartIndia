package com.shaktii.shubhilohani.smartindia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shaktii.shubhilohani.Constants.SharedPreference;

public class SplashScreenActivity extends BaseActivity {



    private final int SPLASH_DISPLAY_LENGTH = 2000;
    private Intent mainintent;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (sharedPreference.getUserID() == null) {

                    mainintent = new Intent(SplashScreenActivity.this,LoginActivity.class);
                    startActivity(mainintent);
                    SplashScreenActivity.this.finish();
                } else {
                    mainintent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                    SplashScreenActivity.this.startActivity(mainintent);
                    SplashScreenActivity.this.finish();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
