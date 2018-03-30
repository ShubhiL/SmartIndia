package com.shaktii.shubhilohani.Application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;

import com.shaktii.shubhilohani.Constants.GlobalConstants;


public class ApplicationController extends Application {

    public static final String TAG = ApplicationController.class.getSimpleName();

    private static ApplicationController mInstance;

    private AppCompatActivity mCurrentActivity = null;

    public static synchronized ApplicationController getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);

        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        GlobalConstants.applicationContext = getApplicationContext();

//        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/roboto_regular.ttf");
//
//        TypefaceUtil.setDefaultFont(this, "DEFAULT", "fonts/roboto_regular.ttf");
//        TypefaceUtil.setDefaultFont(this, "MONOSPACE", "fonts/roboto_regular.ttf");
//        TypefaceUtil.setDefaultFont(this, "SERIF", "fonts/roboto_regular.ttf");
//        TypefaceUtil.setDefaultFont(this, "SANS_SERIF", "fonts/roboto_regular.ttf");
    }

    public AppCompatActivity getCurrentActivity() {
        return mCurrentActivity;
    }

    public void setCurrentActivity(AppCompatActivity mCurrentActivity) {
        this.mCurrentActivity = mCurrentActivity;
    }
}

