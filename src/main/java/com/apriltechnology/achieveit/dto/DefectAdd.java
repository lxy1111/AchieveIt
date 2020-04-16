package com.apriltechnology.achieveit.dto;


/**
 * @Description 缺陷增加
 * @Author br
 * @Date 2020/4/16
 */

public class DefectAdd {
    private long projectId;

    private long chargerId;

    private String content;

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
}
