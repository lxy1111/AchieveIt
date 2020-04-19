package com.apriltechnology.achieveit.dto;

import javax.validation.constraints.NotNull;

/**
 * @Description 项目组员增加
 * @Author br
 * @Date 2020/4/1
 */

public class ProjectUserEdit {

    private Long userId;

    private Long usedRoleId;

    private Long newRoleId;

    private Long projectId;

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


    public Long getUsedRoleId() {
        return usedRoleId;
    }

    public void setUsedRoleId(Long usedRoleId) {
        this.usedRoleId = usedRoleId;
    }

    public Long getNewRoleId() {
        return newRoleId;
    }

    public void setNewRoleId(Long newRoleId) {
        this.newRoleId = newRoleId;
    }
}
