package com.apriltechnology.achieveit.dto;

import java.sql.Timestamp;

/**
 * @Author: lxy
 * @Date: 2020/4/7 17:53
 */
public class DeviceAdd {

    private Long deadline;

    private String deviceowner;

    private int status;

    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public String getDeviceowner() {
        return deviceowner;
    }

    public void setDeviceowner(String deviceowner) {
        this.deviceowner = deviceowner;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
