package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.Archives;
import com.apriltechnology.achieveit.service.impl.ArchiveServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
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
 * @Description 档案信息控制层
 * @Author br
 * @Date 2020/4/8
 */

@Controller
@RequestMapping("/Archive")
@Api(tags = "档案信息接口")
@Slf4j

public class ArchiveController {
    @Autowired
    private ArchiveServiceImpl archiveService;

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("通过项目id查询档案信息")
    public Response archiveSearch(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        List<Archives> archives= archiveService.getArchivesList(projectId);

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<Archives>> map = new HashMap<>();
        map.put("工时信息列表",archives);

        response.setData(map);
        response.setCount(archives.size());

        return response;
    }

    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("添加新档案")
    public Response archiveAdd(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.archivesAdd(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectBasicTable")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectBasicTable(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectBasicTable(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectProposal")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectProposal(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectProposal(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectPrice")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectPrice(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectPrice(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectEstimate")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectEstimate(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectEstimate(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectSchedule")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectSchedule(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectSchedule(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectProcess")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectProcess(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectProcess(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectCost")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectCost(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectCost(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectDemand")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectDemand(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectDemand(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectRisk")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectRisk(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectRisk(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProblem")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProblem(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProblem(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptReport")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptReport(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptReport(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptProjectSummary")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptProjectSummary(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptProjectSummary(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptBestExperience")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptBestExperience(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptBestExperience(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptDevelopTool")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptDevelopTool(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptDevelopTool(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptDevelopModel")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptDevelopModel(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptDevelopModel(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptExamine")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptExamine(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptExamine(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/AcceptQASummary")
    @ResponseBody
    @ApiOperation("更改状态")
    public Response acceptQASummary(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        Pair<Boolean,String> result = archiveService.acceptQASummary(projectId);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }
}
