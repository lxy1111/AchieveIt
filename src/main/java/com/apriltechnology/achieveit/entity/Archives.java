package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;

/**
 * @Description 档案信息类
 * @Author br
 * @Date 2020/4/8
 */


public class Archives {
    private long id;

    private long projectId;

    private Integer projectBasicTable;

    private Integer projectProposal;

    private Integer projectPrice;

    private Integer projectEstimate;

    private Integer projectSchedule;

    private Integer projectProcess;

    private Integer projectCost;

    private Integer projectDemand;

    private Integer projectRisk;

    private Integer acceptProblem;

    private Integer acceptReport;

    private Integer projectSummary;

    private Integer bestExperience;

    private Integer developTool;

    private Integer developModel;

    private Integer examine;

    private Integer qaSummary;

    private Timestamp creatTime;

    private Timestamp changeTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectBasicTable() {
        return projectBasicTable;
    }

    public void setProjectBasicTable(Integer projectBasicTable) {
        this.projectBasicTable = projectBasicTable;
    }

    public Integer getProjectProposal() {
        return projectProposal;
    }

    public void setProjectProposal(Integer projectProposal) {
        this.projectProposal = projectProposal;
    }

    public Integer getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(Integer projectPrice) {
        this.projectPrice = projectPrice;
    }

    public Integer getProjectEstimate() {
        return projectEstimate;
    }

    public void setProjectEstimate(Integer projectEstimate) {
        this.projectEstimate = projectEstimate;
    }

    public Integer getProjectSchedule() {
        return projectSchedule;
    }

    public void setProjectSchedule(Integer projectSchedule) {
        this.projectSchedule = projectSchedule;
    }

    public Integer getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(Integer projectProcess) {
        this.projectProcess = projectProcess;
    }

    public Integer getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(Integer projectCost) {
        this.projectCost = projectCost;
    }

    public Integer getProjectDemand() {
        return projectDemand;
    }

    public void setProjectDemand(Integer projectDemand) {
        this.projectDemand = projectDemand;
    }

    public Integer getProjectRisk() {
        return projectRisk;
    }

    public void setProjectRisk(Integer projectRisk) {
        this.projectRisk = projectRisk;
    }

    public Integer getAcceptProblem() {
        return acceptProblem;
    }

    public void setAcceptProblem(Integer acceptProblem) {
        this.acceptProblem = acceptProblem;
    }

    public Integer getAcceptReport() {
        return acceptReport;
    }

    public void setAcceptReport(Integer acceptReport) {
        this.acceptReport = acceptReport;
    }

    public Integer getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(Integer projectSummary) {
        this.projectSummary = projectSummary;
    }

    public Integer getBestExperience() {
        return bestExperience;
    }

    public void setBestExperience(Integer bestExperience) {
        this.bestExperience = bestExperience;
    }

    public Integer getDevelopTool() {
        return developTool;
    }

    public void setDevelopTool(Integer developTool) {
        this.developTool = developTool;
    }

    public Integer getDevelopModel() {
        return developModel;
    }

    public void setDevelopModel(Integer developModel) {
        this.developModel = developModel;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public Integer getQaSummary() {
        return qaSummary;
    }

    public void setQaSummary(Integer qaSummary) {
        this.qaSummary = qaSummary;
    }

    public Timestamp getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Timestamp creatTime) {
        this.creatTime = creatTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }
}
