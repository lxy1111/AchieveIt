package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectUserAdd;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.service.ProjectMemberService;
import com.apriltechnology.achieveit.service.ProjectPermissionService;
import com.apriltechnology.achieveit.service.ProjectUserInfoService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.PreferenceChangeEvent;

/**
 * @Description 组员信息控制层
 * @Author br
 * @Date 2020/3/27
 */

@Controller
@RequestMapping("/ProjectUserInfo")
@Api(tags = "组员信息接口")
@Slf4j

public class ProjectUserInfoController {
    @Autowired
    private ProjectUserInfoService projectUserInfoService;
    @Autowired
    private ProjectPermissionService projectPermissionService;
    @Autowired
    private ProjectMemberService projectMemberService;

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("查询组员信息")
    public Response projectUserInfoSearch(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        List<ProjectUserInfo> projectUserInfos = projectUserInfoService.getProjectUserInfoList(projectId);

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectUserInfo>> map = new HashMap<>();
        map.put("组员信息列表",projectUserInfos);

        response.setData(map);
        response.setCount(projectUserInfos.size());

        return response;
    }

    @PostMapping("/Delete")
    @ResponseBody
    @ApiOperation("删除项目相关组员")
    public Response projectUserDelete(@RequestParam(value = "projectId")Long projectId,@RequestParam(value = "userId")Long userId){
        if (projectId==null || projectId <= 0){
            return Response.createError("1","项目id不能为空或者小于等于0");
        }
        if (userId==null || userId <= 0){
            return Response.createError("1","用户id不能为空或者小于等于0");
        }
        Response response = new Response();
        Pair<Boolean,String> result = projectUserInfoService.projectUserDelete(projectId,userId);
        if(result.getKey()){
            Pair<Boolean,String> result1 = projectPermissionService.deleteUserProjectPermission(projectId,userId);
            if(result1.getKey()){
                response.setCode("0");
                response.setMsg(result1.getValue());
                return response;
            }else{
                return Response.createError("1",result1.getValue());
            }
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AddEPG")
    @ResponseBody
    @ApiOperation("添加EPG")
    public Response epgAdd(@RequestBody ProjectUserAdd projectUserAdd){
        Response response = new Response();
        //判断同一个人是否担任了同一个角色
        Pair<Boolean, String> result = projectUserInfoService.judgeProjectUserInfo(projectUserAdd);
        //新建有关userprojectpermission这个表
        UserProjectPermissionInfo userProjectPermissionInfo = new UserProjectPermissionInfo();
        userProjectPermissionInfo.setProjectId(projectUserAdd.getProjectId());
        userProjectPermissionInfo.setUserId(projectUserAdd.getUserId());
        userProjectPermissionInfo.setFilePermission(0);
        userProjectPermissionInfo.setGitPermission(0);
        userProjectPermissionInfo.setMailPermission(0);
        //如果没有冗余情况
        if(result.getKey()){
            //新增成员
            Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
            //如果新增epg成功
            if (result1.getKey()) {
                //调整memberassign和permission
                long projectId = projectUserAdd.getProjectId();
                long userId = projectUserAdd.getUserId();
                Pair<Boolean, String> result2 = projectMemberService.adjustEPGMemberAssign(projectId);
                if(judge(projectId,userId)){
                    Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                    response.setCode("0");
                    response.setMsg(result3.getValue());
                    return response;
                }
                else{
                    response.setCode("0");
                    response.setMsg(result2.getValue());
                    return response;
                }
            //新增epg失败
            } else {
                return Response.createError("1", result1.getValue());
            }
        //如果有冗余情况
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AddQA")
    @ResponseBody
    @ApiOperation("添加QA")
    public Response qaAdd(@RequestBody ProjectUserAdd projectUserAdd){
        Response response = new Response();
        //判断同一个人是否担任了同一个角色
        Pair<Boolean, String> result = projectUserInfoService.judgeProjectUserInfo(projectUserAdd);
        //新建有关userprojectpermission这个表
        UserProjectPermissionInfo userProjectPermissionInfo = new UserProjectPermissionInfo();
        userProjectPermissionInfo.setProjectId(projectUserAdd.getProjectId());
        userProjectPermissionInfo.setUserId(projectUserAdd.getUserId());
        userProjectPermissionInfo.setFilePermission(0);
        userProjectPermissionInfo.setGitPermission(0);
        userProjectPermissionInfo.setMailPermission(0);
        //如果没有冗余情况
        if(result.getKey()){
            //新增成员
            Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
            //如果新增epg成功
            if (result1.getKey()) {
                //调整memberassign和permission
                long projectId = projectUserAdd.getProjectId();
                long userId = projectUserAdd.getUserId();
                Pair<Boolean, String> result2 = projectMemberService.adjustQAMemberAssign(projectId);
                if(judge(projectId,userId)){
                    Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                    response.setCode("0");
                    response.setMsg(result3.getValue());
                    return response;
                }
                else{
                    response.setCode("0");
                    response.setMsg(result2.getValue());
                    return response;
                }
                //新增epg失败
            } else {
                return Response.createError("1", result1.getValue());
            }
            //如果有冗余情况
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("添加项目相关组员")
    public Response projectUserAdd(@RequestBody ProjectUserAdd projectUserAdd,@RequestParam(value = "id")Long id) {
        Response response = new Response();
        Pair<Boolean, String> result = projectUserInfoService.judgeProjectUserInfo(projectUserAdd);
        UserProjectPermissionInfo userProjectPermissionInfo = new UserProjectPermissionInfo();
        userProjectPermissionInfo.setProjectId(projectUserAdd.getProjectId());
        userProjectPermissionInfo.setUserId(projectUserAdd.getUserId());
        userProjectPermissionInfo.setFilePermission(0);
        userProjectPermissionInfo.setGitPermission(0);
        userProjectPermissionInfo.setMailPermission(0);
        //判断冗余
        if(result.getKey()){
            //项目经理分配组员
            if (id == 5) {
                Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
                //添加组员成功
                if (result1.getKey()) {
                    long projectId = projectUserAdd.getProjectId();
                    long userId = projectUserAdd.getUserId();
                    //调整DEV
                    Pair<Boolean, String> result2 = projectMemberService.adjustDEVMemberAssign(projectId);
                    //调整权限
                    if(judge(projectId,userId)){
                        //没有该成员就插入
                        Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                        response.setCode("0");
                        response.setMsg(result3.getValue());
                        return response;
                    }
                    //不然就放弃插入这一条数据
                    else{
                        response.setCode("0");
                        response.setMsg(result2.getValue());
                        return response;
                    }
                //添加组员失败
                } else {
                    return Response.createError("1", result1.getValue());
                }
            }else{
                return Response.createError("1","该用户不可分配成员");
            }
        }else {
            return Response.createError("1",result.getValue());
        }

    }

    private Boolean judge(Long projectId, Long userId){
        UserProjectPermission userProjectPermission = projectPermissionService.searchUserProhectPermission(projectId,userId);
        if (userProjectPermission==null)return true;
        else return false;
    }
}
