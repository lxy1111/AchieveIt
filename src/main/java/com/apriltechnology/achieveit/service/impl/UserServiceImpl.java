package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.mapper.UserMapper;
import com.apriltechnology.achieveit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户信息service实现层
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {

        User user = userMapper.getUserByUsername(username);

        return user;
    }
}
