package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectInfoAdd;
import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.service.ProjectInfoService;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("新增项目信息")
    Response projectInfoAdd(@RequestBody ProjectInfoAdd projectInfoAdd){

        Response response = new Response();

        User user = UserUtil.get();
        Pair<Boolean,String> result = projectInfoService.insertProjectInfo(projectInfoAdd,user.getId(),0);
        if(!result.getKey()){
            return Response.createError("1",result.getValue());
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
    Response searchMyTask(){

        Response response = new Response();
        User user = UserUtil.get();
        List<ProjectInfo> projectInfos = projectInfoService.searchMyTaskProjectInfo(user.getUsername(),0);
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<ProjectInfo>> map = new HashMap<>();
        map.put("data",projectInfos);
        response.setData(map);
        return response;

    }


}
