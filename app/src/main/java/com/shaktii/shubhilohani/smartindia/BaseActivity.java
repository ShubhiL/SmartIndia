package com.shaktii.shubhilohani.smartindia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.shaktii.shubhilohani.Application.ApplicationController;
import com.shaktii.shubhilohani.Constants.GlobalConstants;
import com.shaktii.shubhilohani.Constants.SharedPreference;

public class BaseActivity extends AppCompatActivity {

    public static String TAG = "BASE ACTIVITY";
    public SharedPreference sharedPreference;
    protected ApplicationController applicationController = (ApplicationController) GlobalConstants.applicationContext;
    View inflatedView;
    AppCompatActivity currentActivity;

    View viewGroup;

    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "ON CREATE");

        GlobalConstants.applicationContext = getApplicationContext();

        applicationController.setCurrentActivity(this);

        currentActivity = ((ApplicationController) GlobalConstants.applicationContext).getCurrentActivity();

        sharedPreference = new SharedPreference();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Log.d(TAG, "ON POST CREATE");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "ON START");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(TAG, "ON STOP");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "ON RESUME");

        applicationController.setCurrentActivity(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "ON PAUSE");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Log.d(TAG, "ON BACK PRESSED");
    }

    @Override
    public void onDestroy() {
        clearReferences();
        super.onDestroy();

        Log.d(TAG, "ON DESTROY");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "ON ACTIVITY RESULT");
    }

    private void clearReferences() {

        AppCompatActivity currentActivity = applicationController.getCurrentActivity();

        if (this.equals(currentActivity))
            applicationController.setCurrentActivity(null);
    }

    public void displayMessage(String message) {

        viewGroup = new View(this);

        this.addContentView(viewGroup, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Snackbar.make(viewGroup, message, Snackbar.LENGTH_LONG).show();
    }

    public void displayLongMessage(String message) {

        if (snackbar != null)
            snackbar.dismiss();

        viewGroup = new View(this);

        this.addContentView(viewGroup, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        snackbar = Snackbar.make(viewGroup, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    public void navigateLogin() {

        Intent intent = new Intent(currentActivity, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void navigateHome() {

        Intent intent = new Intent(currentActivity, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void loaderInitialization() {

        LayoutInflater inflater = (LayoutInflater) currentActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflatedView = inflater.inflate(R.layout.loader_design, null);

        this.addContentView(inflatedView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        inflatedView.setVisibility(View.GONE);
    }

    public void hideKeyboard() {

        View view = currentActivity.getCurrentFocus();

        if (view != null) {
            ((InputMethodManager) currentActivity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
