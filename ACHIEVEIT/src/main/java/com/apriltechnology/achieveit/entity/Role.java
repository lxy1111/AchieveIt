package com.apriltechnology.achieveit.entity;

import java.util.Set;

/**
 * @Description 角色实体类
 * @Author fjm
 * @Date 2020/3/9
 */
public class Role {

    private Integer id;

    private Integer userId;

    private String roleName;

    //角色对应权限集合
    private Set<Permission> permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
