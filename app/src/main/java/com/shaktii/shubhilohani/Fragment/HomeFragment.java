package com.shaktii.shubhilohani.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shaktii.shubhilohani.Adapter.ProjectListAdapter;
import com.shaktii.shubhilohani.Pojo.Project;
import com.shaktii.shubhilohani.smartindia.HomeActivity;
import com.shaktii.shubhilohani.smartindia.R;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {

    private static final String POSITION = "position";

    private static final String TAG = "HOME FRAGMENT";

    View view;

    HomeActivity homeActivity;

    LinearLayout linearParent;

    RecyclerView recyclerView;

    ProjectListAdapter projectListAdapter;

    LinearLayoutManager linearLayoutManager;

    String value;

    ArrayList<Project> projectArrayList;

    public HomeFragment() {

        Log.d(TAG, "CONSTRUCTOR");
    }

    public static HomeFragment newInstance(String screen) {

        Log.d(TAG, "INSTANCE");

        HomeFragment homeFragment = new HomeFragment();

        Bundle bundle = new Bundle();

        bundle.putString(POSITION, screen);

        homeFragment.setArguments(bundle);

        return homeFragment;
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

        viewInitialization();

        return view;
    }

    private void viewInitialization() {

        linearParent = (LinearLayout) view.findViewById(R.id.linear_parent);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        setValues();
    }

    private void setValues() {

        loadArrayList();
    }

    private void loadArrayList() {

        projectArrayList = new ArrayList<Project>();

        for (int i = 0; i < 6; i++) {

            Project project = new Project();

            projectArrayList.add(project);
        }

        loadMenuList();
    }

    private void loadMenuList() {

        linearLayoutManager = new LinearLayoutManager(homeActivity);

        projectListAdapter = new ProjectListAdapter(projectArrayList);

        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(projectListAdapter);

        recyclerView.setLayoutManager(linearLayoutManager);

        linearLayoutManager.scrollToPosition(0);
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
