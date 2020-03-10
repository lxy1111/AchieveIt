package com.apriltechnology.achieveit.entity;

import java.sql.Timestamp;

/**
 * @Description 角色实体类
 * @Author fjm
 * @Date 2020/3/9
 */
public class Role {

    private Long id;

    private Long roleName;

    private String description;

    private Timestamp createTime;

    private Timestamp changeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleName() {
        return roleName;
    }

    public void setRoleName(Long roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
