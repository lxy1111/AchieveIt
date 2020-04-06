package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.service.LoginService;
import com.apriltechnology.achieveit.service.UserService;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Test
    public void logOn() {
        User user = new User();
        user.setUsername("fjm");
        user.setPassword("123");
        Pair<Boolean,String> result = loginService.logOn("fjm","123",user);
        Assert.isTrue(result.getKey());
    }
}