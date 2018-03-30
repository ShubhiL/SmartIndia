package com.shaktii.shubhilohani.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Project implements Parcelable {

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel source) {
            return new Project(source);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    public String getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(String projectPhase) {
        this.projectPhase = projectPhase;
    }

    String projectName, projectCode, projectPhase, startDate, endDate;

    int projectProgress;

    public Project() {

    }

    protected Project(Parcel in) {
        this.projectName = in.readString();
        this.projectCode = in.readString();
        this.projectPhase = in.readString();
        this.startDate = in.readString();
        this.endDate = in.readString();
        this.projectProgress = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(int projectProgress) {
        this.projectProgress = projectProgress;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.projectName);
        dest.writeString(this.projectCode);
        dest.writeString(this.projectPhase);
        dest.writeString(this.startDate);
        dest.writeString(this.endDate);
        dest.writeInt(this.projectProgress);
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}


