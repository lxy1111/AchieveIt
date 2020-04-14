package com.apriltechnology.achieveit.controller;


import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.service.UserService;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 用户信息controller层
 * @Author fjm
 * @Date 2020/3/31
 */
@Controller
@RequestMapping("/UserInfo")
@Api(tags = "用户信息接口")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/UserRole")
    @ResponseBody
    @ApiOperation("用户角色查询")
    Response getUserRole(){

        Response response = new Response();
        User user = UserUtil.get();
        response.setCode("0");
        Map<String,String> map = new HashMap<>();
        map.put("role",user.getRoles());
        response.setData(map);
        return response;
    }

    @PostMapping("/SearchUsers")
    @ResponseBody
    @ApiOperation("查询用户信息")
    Response searchUsers(@RequestParam("username")String username){

        Response response = new Response();
        Map<String,List<User>> map = new HashMap<>();
        response.setCode("0");
        if(StringUtils.isEmpty(username)){
            map.put("data",new ArrayList<>());
            response.setData(map);
            response.setCount(0);
            return response;
        }

        List<User> users = userService.searchUserByUserName(username);
        if(null == users || users.size() <= 0){
            response.setCount(0);
            map.put("data",new ArrayList<>());
            response.setData(map);
            return response;
        }else{
            response.setCount(users.size());
            map.put("data",users);
            response.setData(map);
            return response;
        }
    }

}
