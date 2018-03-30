package com.shaktii.shubhilohani.smartindia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.shaktii.shubhilohani.Application.ApplicationController;
import com.shaktii.shubhilohani.Constants.GlobalConstants;
import com.shaktii.shubhilohani.Constants.SharedPreference;

/**
 * Created by shubhilohani on 3/30/18.
 */

public class BaseActivity extends AppCompatActivity {

    public SharedPreference sharedPreference;
    AppCompatActivity currentActivity;


    @Override
    public void onResume() {
        super.onResume();

        Log.d("BASE CLASS", "ON RESUME");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("BaseActivity", "ON CREATE");

        GlobalConstants.applicationContext = getApplicationContext();

//        appController.setCurrentActivity(this);
//
//        currentActivity = ((ApplicationController) GlobalConstants.applicationContext).getCurrentActivity();

        sharedPreference = new SharedPreference();

    }




}
