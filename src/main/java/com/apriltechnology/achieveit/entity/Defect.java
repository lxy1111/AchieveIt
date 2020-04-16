package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;

/**
 * @Description 缺陷信息类
 * @Author br
 * @Date 2020/4/16
 */


public class Defect {
    private long id;

    private long projectId;

    private long chargerId;

    private String content;

    private Timestamp createTime;

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

    public long getChargerId() {
        return chargerId;
    }

    public void setChargerId(long chargerId) {
        this.chargerId = chargerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
