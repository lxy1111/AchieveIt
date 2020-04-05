package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description 项目子功能实体类
 * @Date 2020/3/25
 * @Author fjm
 */
public class ProjectFunc {
    private Long id;

    private Long projectId;

    private String functionName;

    private String personCharge;

    private Timestamp createTime;

    private Timestamp changeTime;

    private List<ProjectSubFunc> projectSubFuncs;

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

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getPersonCharge() {
        return personCharge;
    }

    public void setPersonCharge(String personCharge) {
        this.personCharge = personCharge;
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

    public List<ProjectSubFunc> getProjectSubFuncs() {
        return projectSubFuncs;
    }

    public void setProjectSubFuncs(List<ProjectSubFunc> projectSubFuncs) {
        this.projectSubFuncs = projectSubFuncs;
    }
}
