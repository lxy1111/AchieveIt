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
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
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
        if(result.getKey()){
            //3->epg 4->QA 5->PM
            if (id == 3) {
                Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
                long projectId = projectUserAdd.getProjectId();
                Pair<Boolean, String> result2 = projectMemberService.adjustEPGMemberAssign(projectId);
                Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                if (result1.getKey() && result2.getKey() && result3.getKey()) {
                    response.setCode("0");
                    response.setMsg(result1.getValue());
                    return response;
                } else {
                    return Response.createError("1", result1.getValue());
                }
            } else if (id == 4) {
                Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
                long projectId = projectUserAdd.getProjectId();
                Pair<Boolean, String> result2 = projectMemberService.adjustQAMemberAssign(projectId);
                Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                if (result1.getKey() && result2.getKey()&& result3.getKey()) {
                    response.setCode("0");
                    response.setMsg(result1.getValue());
                    return response;
                } else {
                    return Response.createError("1", result1.getValue());
                }
            } else if (id == 5) {
                Pair<Boolean, String> result1 = projectUserInfoService.projectUserAdd(projectUserAdd);
                long projectId = projectUserAdd.getProjectId();
                Pair<Boolean, String> result2 = projectMemberService.adjustDEVMemberAssign(projectId);
                Pair<Boolean,String> result3 = projectPermissionService.addUserProjectPermission(userProjectPermissionInfo);
                if (result1.getKey() && result2.getKey()&& result3.getKey()) {
                    response.setCode("0");
                    response.setMsg(result1.getValue());
                    return response;
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

}
