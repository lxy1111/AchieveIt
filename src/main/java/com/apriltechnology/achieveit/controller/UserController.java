package com.apriltechnology.achieveit.controller;


import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

}
