package com.apriltechnology.achieveit.dto;

/**
 * @Author: lxy
 * @Date: 2020/3/25 18:38
 */
public class DeviceSearch {

    private Long id;

    private Long projectID;

    private String deviceowner;

    private Long deadline;

    private int status;

    private Integer pageNum;

    private Integer pageSize;

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

    public String getDeviceowner() {
        return deviceowner;
    }

    public void setDeviceowner(String deviceowner) {
        this.deviceowner = deviceowner;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
