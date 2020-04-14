package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户信息service接口层
 * @Author fjm
 * @Date 2020/3/9
 */
public interface UserService {

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    List<User> searchUserByUserName(String username);

}
