package com.apriltechnology.achieveit.entity;

import java.util.Set;

/**
 * @Description 用户信息类
 * @Author fjm
 * @Date 2020/3/9
 */
public class User {

    private Integer id;

    private String username;

    private String password;

    //用户对应的角色集合
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
