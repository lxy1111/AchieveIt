package com.apriltechnology.achieveit.entity;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @Description 工时信息类
 * @Author br
 * @Date 2020/3/24
 */

public class WorkHourInfo {

    private long id;

    private long userId;

    private String userName;

    private String userRole;

    private String finishedFunction;

    private String finishedActivity;

    private Timestamp startTime;

    private Timestamp finishTime;

    private Timestamp creatTime;

    private Timestamp changeTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }
}
