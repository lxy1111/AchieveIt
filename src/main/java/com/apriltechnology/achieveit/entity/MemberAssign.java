package com.apriltechnology.achieveit.entity;

/**
 * @Description 成员分配类
 * @Author fjm
 * @Date 2020/4/8
 */
public class MemberAssign {

    private Long id;

    private Long projectId;

    private Integer qaMember;

    private Integer epgMember;

    private Integer devMember;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getQaMember() {
        return qaMember;
    }

    public void setQaMember(Integer qaMember) {
        this.qaMember = qaMember;
    }

    public Integer getEpgMember() {
        return epgMember;
    }

    public void setEpgMember(Integer epgMember) {
        this.epgMember = epgMember;
    }

    public Integer getDevMember() {
        return devMember;
    }

    public void setDevMember(Integer devMember) {
        this.devMember = devMember;
    }
}
