package com.apriltechnology.achieveit.dto;

import java.sql.Timestamp;

/**
 * @Description 工时编辑
 * @Author br
 * @Date 2020/4/4
 */

public class WorkHourEdit {
    private long workHourId;

    private String finishedFunction;

    private String finishedActivity;

    private Timestamp startTime;

    private Timestamp finishTime;


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

    public long getWorkHourId() {
        return workHourId;
    }

    public void setWorkHourId(long workHourId) {
        this.workHourId = workHourId;
    }
}
