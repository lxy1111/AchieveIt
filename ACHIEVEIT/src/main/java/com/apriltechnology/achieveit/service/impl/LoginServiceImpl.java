package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.service.LoginService;
import com.apriltechnology.achieveit.util.JWTUtil;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

/**
 * @Description 用户登录service实现层
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class LoginServiceImpl implements LoginService {



    @Override
    public Pair<Boolean, String> logOn(String username, String password) {

        //判断用户名密码准确性
        return null;
    }

    @Override
    public String getToken(String username, String password) {
        return JWTUtil.sign(username,password);
    }


}
