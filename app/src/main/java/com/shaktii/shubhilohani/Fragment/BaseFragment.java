package com.shaktii.shubhilohani.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    public abstract boolean onBackPressed();

    public static final String TAG = "BASE FRAGMENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "ON CREATE");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "ON CREATE VIEW");

        return container;
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        Log.d(TAG, "ON VIEW CREATED");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "ON ACTIVITY CREATED");
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
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "ON PAUSE");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "ON ATTACH");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Log.d(TAG, "ON DETACH");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "ON DESTROY");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "ON DESTROY VIEW");
    }
}