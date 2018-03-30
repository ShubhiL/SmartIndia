package com.shaktii.shubhilohani.smartindia;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DashboardFragment extends Fragment {


    RecyclerView recycler;
    DashboardAdapter dashboardAdapter;
    ArrayList<Bean_dashboard> aList;
    LinearLayoutManager layoutManager;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recycler = (RecyclerView) v.findViewById(R.id.dashboard_recyclerView);
        aList = new ArrayList<>();
        Bean_dashboard ld;
        for(int i=0; i<10; i++){
            ld= new Bean_dashboard();
            ld.setProjectCode("Project "+i);
            ld.setProjectName("My project "+i);
            aList.add(ld);
            Log.wtf("ProjectNameCode",aList.get(i).getProjectCode()+" "+aList.get(i).getProjectName());
        }
        recycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        dashboardAdapter = new DashboardAdapter(getActivity(), aList);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(dashboardAdapter);
        return v;
        // inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

}
