package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.mapper.UserMapper;
import com.apriltechnology.achieveit.service.LoginService;
import com.apriltechnology.achieveit.util.JWTUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户登录service实现层
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Pair<Boolean, String> logOn(String username, String password) {

        User user = userMapper.getUserByUsername(username);
        if(null != user){
            if(user.getPassword().equals(password)){
                return new Pair<>(true,"登录成功");
            }else{
                return new Pair<>(false,"密码错误！");
            }
        }else{
            return new Pair<>(false,"用户名不存在！");
        }
    }

    @Override
    public String getToken(String username, String password) {

        return JWTUtil.sign(username,password);
    }


}
