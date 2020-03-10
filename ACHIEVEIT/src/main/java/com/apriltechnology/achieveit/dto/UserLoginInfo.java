package com.apriltechnology.achieveit.dto;

import javax.validation.constraints.NotBlank;

/**
 * @Descriptiom 用户登录信息类
 * @Author fjm
 * @Date 2020/3/9
 */
public class UserLoginInfo {

    @NotBlank(message = "请输入用户名")
    private String username;

    @NotBlank(message = "请输入密码")
    private String password;

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
}
