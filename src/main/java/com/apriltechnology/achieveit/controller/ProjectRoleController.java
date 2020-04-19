package com.apriltechnology.achieveit.controller;


import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectRole;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProjectRole;
import com.apriltechnology.achieveit.service.ProjectRoleService;
import com.apriltechnology.achieveit.service.UserProjectRoleService;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目角色信息控制层
 * @Author fjm
 * @Date 2020/3/23
 */

@Controller
@RequestMapping("/ProjectRole")
@Api(tags = "项目角色信息功能接口")
@Slf4j
public class ProjectRoleController {

    @Autowired
    private ProjectRoleService projectRoleService;

    @Autowired
    private UserProjectRoleService userProjectRoleService;

    @PostMapping("/searchAll")
    @ResponseBody
    @ApiOperation("查询所有项目角色信息")
    public Response searchAllProjectRoles(){

        Response response = new Response();
        List<ProjectRole> projectRoles = projectRoleService.getAllProjectRoles();

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectRole>> map = new HashMap<>();
        map.put("data",projectRoles);

        response.setData(map);
        response.setCount(projectRoles.size());

        return response;
    }

    @PostMapping("/SearchUserProjectRoles")
    @ResponseBody
    @ApiOperation("查询用户项目下的角色列表")
    public Response UserProjectRoles(@RequestParam("projectId")Long projectId){

        Response response = new Response();

        User user = UserUtil.get();
        List<Long> userProjectRolesId = userProjectRoleService.getUserProjectRole(user,projectId);
        if(null == userProjectRolesId || userProjectRolesId.size() <= 0){
            return Response.createError("1","没有角色！");
        }else {
            Map<String,List<Long>> map = new HashMap<>();
            map.put("data",userProjectRolesId);
            response.setCode("0");
            response.setData(map);
            response.setMsg("查询角色成功！");
            return response;
        }

    }

}
