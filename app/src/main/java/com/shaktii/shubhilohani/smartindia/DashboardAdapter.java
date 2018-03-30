package com.shaktii.shubhilohani.smartindia;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.TestViewHolder>  {

    Context context;
    ArrayList<Bean_dashboard> aList;

    public DashboardAdapter(Context context, ArrayList<Bean_dashboard> aList) {
        this.context = context;
        this.aList = aList;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recycler_view, parent, false);
        DashboardAdapter.TestViewHolder vh = new DashboardAdapter.TestViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {

        if (holder instanceof DashboardAdapter.TestViewHolder) {
            holder.tv_projectCode.setText(aList.get(position).getProjectCode());
            holder.tv_projectName.setText((aList.get(position).getProjectName()));
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, SingleProjectActivity.class);
                context.startActivity(intent);

            }
        });


    }



    @Override
    public int getItemCount() {
        return aList.size();
    }

    static class TestViewHolder extends RecyclerView.ViewHolder {

        TextView tv_projectCode;
        CardView cardView;
        TextView tv_projectName;

        public TestViewHolder(View view){
            super(view);
            tv_projectCode = (TextView) view.findViewById(R.id.tv_projectCode);
            tv_projectName = (TextView) view.findViewById(R.id.tv_projectName);
//            cardView = view.findViewById(R.id.card_view);

        }

    }

}


