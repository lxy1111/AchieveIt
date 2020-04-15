package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import com.apriltechnology.achieveit.service.ProjectPermissionService;
import com.apriltechnology.achieveit.service.UserProjectRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 项目权限信息controller层
 * @Author fjm
 * @Date 2020/4/15
 */
@Controller
@RequestMapping("/ProjectPermission")
@Api(tags = "权限信息接口")
@Slf4j
public class ProjectPermissionController {

    @Autowired
    private ProjectPermissionService projectPermissionService;


    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("新增用户项目权限信息")
    Response addUserProjectRole(@RequestBody UserProjectPermissionInfo userProjectPermissionInfo){

        if(null == userProjectPermissionInfo.getGitPermission() || (userProjectPermissionInfo.getGitPermission() != 0 && userProjectPermissionInfo.getGitPermission() != 1)){
            userProjectPermissionInfo.setGitPermission(0);
        }

        if(null == userProjectPermissionInfo.getMailPermission() || (userProjectPermissionInfo.getMailPermission() != 0 && userProjectPermissionInfo.getMailPermission() != 1)){
            userProjectPermissionInfo.setMailPermission(0);
        }

        if(null == userProjectPermissionInfo.getFilePermission() || (userProjectPermissionInfo.getFilePermission() != 0 && userProjectPermissionInfo.getFilePermission() != 1)){
            userProjectPermissionInfo.setFilePermission(0);
        }

        if(userProjectPermissionInfo.getGitPermission() == 1){
            //todo 调用接口执行分配git权限shell脚本
        }

        if(userProjectPermissionInfo.getMailPermission() == 1){
            //todo 调用接口执行分配mail权限shell脚本
        }

        if(userProjectPermissionInfo.getFilePermission() == 1){
            //todo 调用接口执行分配file权限shell脚本
        }


        Response response = new Response();
        Pair<Boolean,String> result = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);

        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else{
            response.setCode("1");
            response.setMsg(result.getValue());
            return response;
        }
    }

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("编辑用户项目权限信息")
    Response editUserProjectRole(@RequestBody UserProjectPermissionInfo userProjectPermissionInfo){

        if(null == userProjectPermissionInfo.getGitPermission() || (userProjectPermissionInfo.getGitPermission() != 0 && userProjectPermissionInfo.getGitPermission() != 1)){
            userProjectPermissionInfo.setGitPermission(0);
        }

        if(null == userProjectPermissionInfo.getMailPermission() || (userProjectPermissionInfo.getMailPermission() != 0 && userProjectPermissionInfo.getMailPermission() != 1)){
            userProjectPermissionInfo.setMailPermission(0);
        }

        if(null == userProjectPermissionInfo.getFilePermission() || (userProjectPermissionInfo.getFilePermission() != 0 && userProjectPermissionInfo.getFilePermission() != 1)){
            userProjectPermissionInfo.setFilePermission(0);
        }


        //todo 调用接口执行分配git权限shell脚本
        //todo 调用接口执行分配mail权限shell脚本
        //todo 调用接口执行分配file权限shell脚本



        Response response = new Response();
        Pair<Boolean,String> result = projectPermissionService.editUserpRrojectPermission(userProjectPermissionInfo);

        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else{
            response.setCode("1");
            response.setMsg(result.getValue());
            return response;
        }
    }

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("查询用户项目权限信息")
    Response searchUserProjectPermission(@RequestParam("projectId")Long projectId,@RequestParam("userId")Long userId){

        Response response = new Response();
        UserProjectPermission userProjectPermission = projectPermissionService.searchUserProhectPermission(projectId,userId);
        if(null == userProjectPermission){
            return Response.createError("1","还未分配该用户权限信息！");
        }else {
            response.setCount(1);
            Map<String,UserProjectPermission> map = new HashMap();
            map.put("data",userProjectPermission);
            response.setData(map);
            response.setCode("0");
            return response;
        }

    }
}
