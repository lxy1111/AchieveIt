package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.*;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProjectRole;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.exception.InsertException;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import com.apriltechnology.achieveit.service.UserService;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目信息controller层
 * @Author fjm
 * @Date 2020/3/17
 */
@Controller
@RequestMapping("/ProjectInfo")
@Api(tags = "项目信息接口")
@Slf4j
public class ProjectInfoController {

    @Autowired
    private ProjectInfoService projectInfoService;

    @Autowired
    private UserService userService;

    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("新增项目信息")
    Response projectInfoAdd(@RequestBody ProjectInfoAdd projectInfoAdd){

        if(null == projectInfoAdd.getScheduleTime()){
            Timestamp time = new Timestamp(System.currentTimeMillis());
            projectInfoAdd.setScheduleTime(time);
        }

        if(null == projectInfoAdd.getDeliveryTime()){
            Timestamp time = new Timestamp(System.currentTimeMillis());
            projectInfoAdd.setDeliveryTime(time);
        }

        Response response = new Response();

        User user = UserUtil.get();
        Pair<Boolean,String> result = null;
        try {
            result = projectInfoService.insertProjectInfo(projectInfoAdd,user.getId(),0);
        } catch (InsertException e) {
            log.error("projectInfoAdd",ExceptionUtils.getStackTrace(e));
            response.setCode("1");
            response.setMsg(e.getMessage());
            return response;
        }

        //todo 调用邮件服务

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
    @ApiOperation("查询项目信息")
    Response projectInfoSearch(@RequestBody ProjectInfoSearch projectInfoSearch){

        if(null == projectInfoSearch.getPageNum()){
            projectInfoSearch.setPageNum(1);
        }

        if(null == projectInfoSearch.getPageSize()){
            projectInfoSearch.setPageSize(10);
        }

        Response response = new Response();

        Integer count = projectInfoService.getProjectInfoCount(projectInfoSearch);

        List<ProjectInfo> projectInfos = projectInfoService.getProjectInfo(projectInfoSearch);
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);

        return response;
    }

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("更新项目信息")
    Response editProjectInfo(@RequestBody ProjectInfoSearch projectInfoSearch){

        if(null == projectInfoSearch.getScheduleTime()){
            Timestamp time = new Timestamp(System.currentTimeMillis());
            projectInfoSearch.setScheduleTime(time);
        }

        if(null == projectInfoSearch.getDeliveryTime()){
            Timestamp time = new Timestamp(System.currentTimeMillis());
            projectInfoSearch.setDeliveryTime(time);
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectInfoService.editProjectInfo(projectInfoSearch);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else{
            return Response.createError("`1",result.getValue());
        }
    }

    @PostMapping("/Delete")
    @ResponseBody
    @ApiOperation("删除项目信息")
    Response deleteProjectInfo(@RequestParam("ids[]") List<Long> ids){

        Response response = new Response();

        try {
            Pair<Boolean,String> result = projectInfoService.deleteProjectInfo(ids);
            if(result.getKey()){
                response.setCode("0");
                response.setMsg(result.getValue());
                return response;
            }else{
                response.setCode("1");
                response.setMsg(result.getValue());
                return response;
            }
        } catch (BatchDeleteException e) {
            log.error("deleteProjectInfo", ExceptionUtils.getStackTrace(e));
            response.setCode("1");
            response.setMsg(e.getMessage());
            return response;
        }
    }

    @PostMapping("/GetStatus")
    @ResponseBody
    @ApiOperation("获取项目状态信息")
    Response getProjectStatus(@RequestParam("projectId")Long projectId){

        Response response = new Response();
        int result = projectInfoService.getProjectStatus(projectId);
        if(result < 0 || result > 6){
            return Response.createError("1","data error");
        }else {
            response.setCode("0");
            Map<String,Integer> map = new HashMap<>();
            map.put("data",result);
            response.setData(map);
            response.setMsg("查询成功！");
            return response;
        }
    }

    @PostMapping("/ApproveProject")
    @ResponseBody
    @ApiOperation("同意立项")
    Response approveProject(@RequestParam("projectId")Long projectId){

        Response response = new Response();

        Pair<Boolean,String> result = projectInfoService.changeProjectStatus(projectId,1);
        //todo 发送邮件给项目经理，EPG经理，QA经理
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

    @PostMapping("/RejectProject")
    @ResponseBody
    @ApiOperation("不同意立项")
    Response rejectProject(@RequestParam("projectId")Long projectId){

        Response response = new Response();

        Pair<Boolean,String> result = projectInfoService.changeProjectStatus(projectId,2);
        //todo 发送邮件给项目经理

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


    @PostMapping("/MyTask")
    @ResponseBody
    @ApiOperation("待审批项目")
    Response searchMyTask(@RequestBody MyTaskInfo myTaskInfo){

        if(null == myTaskInfo.getPageNum() || myTaskInfo.getPageNum() <= 0){
            myTaskInfo.setPageNum(1);
        }
        if(null == myTaskInfo.getPageSize() || myTaskInfo.getPageSize() <= 0){
            myTaskInfo.setPageSize(10);
        }

        Response response = new Response();
        User user = UserUtil.get();
        int count = projectInfoService.searchMyTaskProjectInfoCount(user.getUsername(),0);
        List<ProjectInfo> projectInfos = projectInfoService.searchMyTaskProjectInfo(user.getUsername(),0,myTaskInfo.getPageNum(),myTaskInfo.getPageSize());
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        response.setCount(count);
        return response;
    }

    @PostMapping("/MyProject")
    @ResponseBody
    @ApiOperation("我创建的项目")
    Response searchMyProject(@RequestBody MyProjectInfo myProjectInfo){
        if(null == myProjectInfo.getPageNum() || myProjectInfo.getPageNum() <= 0){
            myProjectInfo.setPageNum(1);
        }
        if(null == myProjectInfo.getPageSize() || myProjectInfo.getPageSize() <= 0){
            myProjectInfo.setPageSize(10);
        }

        Response response = new Response();
        User user = UserUtil.get();
        int count = projectInfoService.searchMyProjectInfoCount(user.getId());
        List<ProjectInfo> projectInfos = projectInfoService.searchMyProjectInfo(user.getId(),myProjectInfo.getPageSize(),myProjectInfo.getPageNum());
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        response.setCount(count);
        return response;
    }

    @PostMapping("/SetStatus")
    @ResponseBody
    @ApiOperation("设置项目状态")
    Response setProjectStatus(@RequestParam("statusId") Integer statusId,@RequestParam("projectId") Long projectId){
        Response response = new Response();
        if(null == statusId || statusId < 0 || statusId > 6){
            return Response.createError("1","不存在此状态！");
        }

        Pair<Boolean,String> result = projectInfoService.changeProjectStatus(projectId,statusId);
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

    @PostMapping("/GetQALeaderProject")
    @ResponseBody
    @ApiOperation("QA经理获取待分配项目")
    Response getQALeaderProjectInfo(@RequestBody QALeaderProjectInfo qaLeaderProjectInfo){

        if(null == qaLeaderProjectInfo.getPageNum() || qaLeaderProjectInfo.getPageNum() <= 0){
            qaLeaderProjectInfo.setPageNum(1);
        }
        if(null == qaLeaderProjectInfo.getPageSize() || qaLeaderProjectInfo.getPageSize() <= 0){
            qaLeaderProjectInfo.setPageSize(10);
        }

        Response response = new Response();
        int count = projectInfoService.searchQALeaderProjectCount();
        List<ProjectInfo> projectInfos = projectInfoService.searchQALeaderProject(qaLeaderProjectInfo.getPageNum(),qaLeaderProjectInfo.getPageSize());
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        response.setCount(count);
        return response;
    }

    @PostMapping("/GetEPGLeaderProject")
    @ResponseBody
    @ApiOperation("EPG经理获取待分配项目")
    Response getEPGLeaderProjectInfo(@RequestBody EPGLeaderProjectInfo epgLeaderProjectInfo){

        if(null == epgLeaderProjectInfo.getPageNum() || epgLeaderProjectInfo.getPageNum() <= 0){
            epgLeaderProjectInfo.setPageNum(1);
        }
        if(null == epgLeaderProjectInfo.getPageSize() || epgLeaderProjectInfo.getPageSize() <= 0){
            epgLeaderProjectInfo.setPageSize(10);
        }

        Response response = new Response();
        int count = projectInfoService.searchEPGLeaderProjectCount();
        List<ProjectInfo> projectInfos = projectInfoService.searchEPGLeaderProject(epgLeaderProjectInfo.getPageNum(),epgLeaderProjectInfo.getPageSize());
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        response.setCount(count);
        return response;
    }

    @PostMapping("/GetMemberProject")
    @ResponseBody
    @ApiOperation("项目组员获取自己的项目")
    Response getMemberProjectInfo(@RequestBody MemberProjectInfo memberProjectInfo){

        if(null == memberProjectInfo.getPageNum() || memberProjectInfo.getPageNum() <= 0){
            memberProjectInfo.setPageNum(1);
        }
        if(null == memberProjectInfo.getPageSize() || memberProjectInfo.getPageSize() <= 0){
            memberProjectInfo.setPageSize(10);
        }

        Response response = new Response();
        User user = UserUtil.get();
        int count = projectInfoService.getMemberProjectInfoCount(user.getId());
        List<ProjectInfo> projectInfos = projectInfoService.getMemberProjectInfo(user.getId(),memberProjectInfo.getPageNum(),memberProjectInfo.getPageSize());
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        response.setCount(count);
        return response;
    }

    @PostMapping("/GetCreater")
    @ResponseBody
    @ApiOperation("获取项目创建者id")
    Response getCreaterId(@RequestParam("projectId")Long projectId){
        Response response = new Response();
        Long id = projectInfoService.getProjectCreaterId(projectId);
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,Long> map = new HashMap<>();
        map.put("data",id);
        response.setData(map);
        return response;
    }

}
