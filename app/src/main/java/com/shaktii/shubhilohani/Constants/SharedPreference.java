package com.shaktii.shubhilohani.Constants;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by shubhilohani on 3/30/18.
 */

public class SharedPreference {

        Context context;

        public SharedPreference() {
            this.context = GlobalConstants.applicationContext;
        }

        public void saveUserID(String userId) {

            SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.USER_ID_PREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("userId", userId);
            editor.commit();
        }

        public String getUserID() {

            SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.USER_ID_PREFERENCES, Context.MODE_PRIVATE);
            String response = sharedPreferences.getString("userId", null);

            return response;
        }

    }

