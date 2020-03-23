package com.apriltechnology.achieveit.controller;


import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectRole;
import com.apriltechnology.achieveit.service.ProjectRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @PostMapping("/searchAll")
    @ResponseBody
    @ApiOperation("查询所有项目角色信息")
    public Response searchAllProjectRoles(){

        Response response = new Response();
        List<ProjectRole> projectRoles = projectRoleService.getAllProjectRoles();

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectRole>> map = new HashMap<>();
        map.put("项目角色列表",projectRoles);

        response.setData(map);
        response.setCount(projectRoles.size());

        return response;
    }

}
