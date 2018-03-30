package com.shaktii.shubhilohani.Constants;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Window;

public class CommonUtilities {

    public static boolean checkInternetConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager) GlobalConstants.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        return isConnected;

    }

    public static Dialog showDialog(Activity activity, int layout) {

        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);

        return dialog;
    }

    public static String capitalize(String title) {

        try {

            if (title == null || title.length() == 0) {
                return "";
            }

            char firstLetter = title.charAt(0);

            if (Character.isUpperCase(firstLetter)) {

                return title;

            } else {

                return Character.toUpperCase(firstLetter) + title.substring(1);
            }
        } catch (Exception E) {
            E.printStackTrace();
            return "";
        }
    }
}
