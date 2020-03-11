package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.UserLoginInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 创建新项目控制层
 * @Author fjm
 * @Date 2020/3/11
 */
@Controller
@RequestMapping("/Project")
@Api(tags = "项目信息接口")
public class ProjectController {


    @RequiresRoles("PM")
    @RequiresPermissions("personManage")
    @RequestMapping("/NewProject")
    @ResponseBody
    @ApiOperation("创建新项目")
    public Response newProject(){
        Response response = new Response();
        return response;
    }


}
