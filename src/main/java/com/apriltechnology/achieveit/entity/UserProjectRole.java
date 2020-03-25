package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description 用户关联项目信息
 * @Author fjm
 * @Date 2020/3/23
 */
public class UserProjectRole {

    private Long userId;

    private Long projectId;

    private Long roleId;

    private Timestamp createTime;

    private Timestamp changeTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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
