package com.apriltechnology.achieveit.dto;

import java.sql.Timestamp;

/**
 * @Descriptiom 项目信息新增类
 * @Author fjm
 * @Date 2020/3/30
 */
public class ProjectInfoAdd {

    private String projectName;

    private String customerInfo;

    private String leader;

    private String milepost;

    private String projectFunction;

    private String technology;

    private String businessArea;

    private Timestamp scheduleTime;

    private Timestamp deliveryTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getMilepost() {
        return milepost;
    }

    public void setMilepost(String milepost) {
        this.milepost = milepost;
    }

    public String getProjectFunction() {
        return projectFunction;
    }

    public void setProjectFunction(String projectFunction) {
        this.projectFunction = projectFunction;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public Timestamp getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Timestamp scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
}
