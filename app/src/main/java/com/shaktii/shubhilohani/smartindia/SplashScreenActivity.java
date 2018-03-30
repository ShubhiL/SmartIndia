package com.shaktii.shubhilohani.smartindia;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.shaktii.shubhilohani.Constants.CommonUtilities;
import com.shaktii.shubhilohani.Constants.GlobalConstants;

public class SplashScreenActivity extends BaseActivity {

    final Handler splashHandler = new Handler();

    final Runnable splashRunnable = new Runnable() {

        @Override
        public void run() {

            if (CommonUtilities.checkInternetConnection()) {

                if (sharedPreference.getUserID() != null && !sharedPreference.getUserID().contentEquals("")) {

                    navigateHome();

                } else {

//                    navigateHome();

                    navigateLogin();
                }

            } else {

                displayMessage(currentActivity.getString(R.string.error_no_connection));

                navigateLogin();
            }
        }
    };


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getDeviceInfo();

        splashHandler.postDelayed(splashRunnable, 3000);

    }

    private void getDeviceInfo() {

        try {

            DisplayMetrics displayMetrics = new DisplayMetrics();

            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

            int height = displayMetrics.heightPixels;

            int width = displayMetrics.widthPixels;

            GlobalConstants.WIDTH = width;

            GlobalConstants.HEIGHT = height;

        } catch (Exception E) {

            E.printStackTrace();
        }
    }
}
