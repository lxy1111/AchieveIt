package com.apriltechnology.achieveit.entity;

import java.util.List;

/**
 * @Description 组员管理类信息
 * @Author br
 * @Date 2020/3/27
 */


public class ProjectUserInfo {
    private long userId;

    private String userName;

    private List<Long> userRole;

    private String userMail;

    private String userDepartment;

    private String projectChargerMail;

    private String userTel;

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

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getProjectChargerMail() {
        return projectChargerMail;
    }

    public void setProjectChargerMail(String projectChargerMail) {
        this.projectChargerMail = projectChargerMail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public List<Long> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<Long> userRole) {
        this.userRole = userRole;
    }
}
