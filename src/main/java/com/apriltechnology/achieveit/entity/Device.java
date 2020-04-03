package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;

/**
 * @Author: lxy
 * @Date: 2020/3/25 19:31
 */
public class Device {

    private Long id;

    private Long projectID;

    private Long deadline;

    private String deviceowner;

    private int status;

    private Timestamp createTime;

    private Timestamp changeTime;

    public String getDeviceowner() {
        return deviceowner;
    }

    public void setDeviceowner(String deviceowner) {
        this.deviceowner = deviceowner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }
}
