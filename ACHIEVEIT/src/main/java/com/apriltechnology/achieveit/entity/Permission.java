package com.apriltechnology.achieveit.entity;

/**
 * @Description 权限实体类
 * @Author fjm
 * @Date 2020/3/9
 */
public class Permission {

    private Integer id;

    private Integer roleId;

    private String permissionsName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }
}
