package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 创建新项目控制层
 * @Author fjm
 * @Date 2020/3/11
 */
@Controller
@RequestMapping("/Project")
public class ProjectController {


    @RequiresRoles("PM")
    @RequiresPermissions("personManage")
    @RequestMapping("/NewProject")
    @ResponseBody
    public Response newProject(){
        Response response = new Response();
        return response;
    }


}
