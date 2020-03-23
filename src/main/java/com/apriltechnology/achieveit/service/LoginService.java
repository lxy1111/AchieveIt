package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.User;
import javafx.util.Pair;

/**
 * @Description 用户登录service接口层
 * @Author fjm
 * @Date 2020/3/9
 */
public interface LoginService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @param user
     * @return
     */
    Pair<Boolean,String> logOn(String username, String password ,User user);

    /**
     * 获取token
     * @param username
     * @param password
     * @return
     */
    String getToken(String username, String password);

}
