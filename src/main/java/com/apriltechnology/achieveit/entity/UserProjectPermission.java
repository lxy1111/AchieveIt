package com.apriltechnology.achieveit.entity;

/**
 * @Description 项目权限实体类
 * @Author fjm
 * @Date 2020/4/15
 */
public class UserProjectPermission {

    private Long userId;

    private Long projectId;

    private Integer gitPermission;

    private Integer mailPermission;

    private Integer filePermission;

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

    public Integer getGitPermission() {
        return gitPermission;
    }

    public void setGitPermission(Integer gitPermission) {
        this.gitPermission = gitPermission;
    }

    public Integer getMailPermission() {
        return mailPermission;
    }

    public void setMailPermission(Integer mailPermission) {
        this.mailPermission = mailPermission;
    }

    public Integer getFilePermission() {
        return filePermission;
    }

    public void setFilePermission(Integer filePermission) {
        this.filePermission = filePermission;
    }
}
