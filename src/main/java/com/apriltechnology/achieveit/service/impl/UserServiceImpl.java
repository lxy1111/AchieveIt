package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.mapper.UserMapper;
import com.apriltechnology.achieveit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<User> searchUserByUserName(String username) {
        List<User> users = userMapper.searchUserByUsername(username);
        return users;
    }

    @Override
    public List<User> searchProjectSuperiors(String username) {
        List<User> users = userMapper.searchProjectSuperiorsByUsername(username);
        return users;
    }
}
