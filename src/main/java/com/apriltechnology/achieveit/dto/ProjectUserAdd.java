package com.apriltechnology.achieveit.dto;

import javax.validation.constraints.NotNull;

/**
 * @Description 项目组员增加
 * @Author br
 * @Date 2020/4/1
 */

public class ProjectUserAdd {

    private Long userId;

    private String roleDescription;

    private Long projectId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
