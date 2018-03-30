package com.shaktii.shubhilohani.Constants;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CommonUtilities {

    public static boolean checkInternetConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager) GlobalConstants.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        return isConnected;

    }
}
