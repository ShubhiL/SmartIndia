package com.shaktii.shubhilohani.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shaktii.shubhilohani.smartindia.HomeActivity;
import com.shaktii.shubhilohani.smartindia.R;

public class AddProjectFragment extends BaseFragment {

    private static final String POSITION = "position";

    private static final String TAG = "ADD PROJECT SCREEN";

    View view;

    HomeActivity homeActivity;

    String value;

    public AddProjectFragment() {

        Log.d(TAG, "CONSTRUCTOR");
    }

    public static AddProjectFragment newInstance(String screen) {

        Log.d(TAG, "INSTANCE");

        AddProjectFragment addProjectFragment = new AddProjectFragment();

        Bundle bundle = new Bundle();

        bundle.putString(POSITION, screen);

        addProjectFragment.setArguments(bundle);

        return addProjectFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeActivity = (HomeActivity) getActivity();

        if (getArguments() != null) {

            Log.d(TAG, "ON CREATE");

            value = getArguments().getString(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "ON CREATE VIEW");

        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
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

        if (homeActivity != null)
            homeActivity.homeNavigate();
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

    @Override
    public boolean onBackPressed() {

        Log.d(TAG, "ON BACK PRESSED");

        return false;
    }
}
