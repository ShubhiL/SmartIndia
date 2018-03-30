package com.shaktii.shubhilohani.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shaktii.shubhilohani.Constants.CommonUtilities;
import com.shaktii.shubhilohani.Constants.GlobalConstants;
import com.shaktii.shubhilohani.Pojo.Project;
import com.shaktii.shubhilohani.smartindia.HomeActivity;
import com.shaktii.shubhilohani.smartindia.ProjectActivity;
import com.shaktii.shubhilohani.smartindia.R;

import java.util.ArrayList;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private static final String TAG = "PROJECT LIST ADAPTER";

    HomeActivity homeActivity;

    String value;

    ArrayList<Project> projectArrayList;

    public ProjectListAdapter(ArrayList<Project> projectArrayList) {

        this.projectArrayList = projectArrayList;
    }

    @Override
    public ProjectListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_project, parent, false);

        homeActivity = (HomeActivity) parent.getContext();

        return new ProjectListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProjectListAdapter.ViewHolder holder, int position) {

        try {

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            int height = (GlobalConstants.HEIGHT - ((int) homeActivity.getResources().getDimension(R.dimen.value_50dp))) / 3;

            layoutParams.height = height;

            layoutParams.setMargins((int) homeActivity.getResources().getDimension(R.dimen.value_1dp), (int) homeActivity.getResources().getDimension(R.dimen.value_1dp),
                    (int) homeActivity.getResources().getDimension(R.dimen.value_1dp), (int) homeActivity.getResources().getDimension(R.dimen.value_1dp));

            holder.itemView.setLayoutParams(layoutParams);

            holder.mItem = projectArrayList.get(position);

            holder.txtName.setText(CommonUtilities.capitalize(projectArrayList.get(position).getProjectName()));
            holder.txtCode.setText(CommonUtilities.capitalize(projectArrayList.get(position).getProjectCode()));
            holder.txtPhase.setText(CommonUtilities.capitalize(projectArrayList.get(position).getProjectPhase()));
            holder.txtStartDate.setText(projectArrayList.get(position).getProjectName());
            holder.txtEndDate.setText(projectArrayList.get(position).getProjectName());

            holder.projectProgress.setProgress(projectArrayList.get(position).getProjectProgress());

            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(homeActivity, ProjectActivity.class);

                    homeActivity.startActivity(intent);

                    homeActivity.menuDrawer.closeMenu();
                }
            });

        } catch (Exception E) {

            E.printStackTrace();
        }
    }

    @Override
    public void onViewDetachedFromWindow(ProjectListAdapter.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);

        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {

        if (projectArrayList != null)
            return projectArrayList.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView txtCode, txtName, txtPhase, txtStartDate, txtEndDate;
        public final ProgressBar projectProgress;

        public Project mItem;

        public ViewHolder(View view) {
            super(view);

            mView = view;

            txtCode = (TextView) view.findViewById(R.id.project_code);
            txtName = (TextView) view.findViewById(R.id.project_name);
            projectProgress = (ProgressBar) view.findViewById(R.id.project_progress);
            txtPhase = (TextView) view.findViewById(R.id.project_phase);
            txtStartDate = (TextView) view.findViewById(R.id.start_date);
            txtEndDate = (TextView) view.findViewById(R.id.end_date);

        }
    }
}
