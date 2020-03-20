package com.apriltechnology.achieveit.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Descriptiom 用户登录信息类
 * @Author fjm
 * @Date 2020/3/9
 */
@ApiModel(value = "UserLoginInfo",description = "用户登录请求对象")
public class UserLoginInfo implements Serializable {

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "请输入用户名")
    private String username;

    @ApiModelProperty(value = "密码")
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
