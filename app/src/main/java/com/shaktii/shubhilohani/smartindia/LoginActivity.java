package com.shaktii.shubhilohani.smartindia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LOGIN SCREEN";

    String strULBName, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void signIn(View view) {

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
