package com.apriltechnology.achieveit.dto;

import java.sql.Timestamp;

/**
 * @Description 工时增加
 * @Author br
 * @Date 2020/4/4
 */

public class WorkHourAdd {
    private long projectId;

    private long userId;

    private String userName;

    private String finishedFunction;

    private String finishedActivity;

    private Timestamp startTime;

    private Timestamp finishTime;

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFinishedFunction() {
        return finishedFunction;
    }

    public void setFinishedFunction(String finishedFunction) {
        this.finishedFunction = finishedFunction;
    }

    public String getFinishedActivity() {
        return finishedActivity;
    }

    public void setFinishedActivity(String finishedActivity) {
        this.finishedActivity = finishedActivity;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }
}
