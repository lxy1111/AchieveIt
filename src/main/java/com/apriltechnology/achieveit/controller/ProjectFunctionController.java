package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectFunctionEdit;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectFunc;
import com.apriltechnology.achieveit.service.ProjectFunctionService;
import com.apriltechnology.achieveit.service.UserProjectRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目功能controller层
 * @Author fjm
 * @Date 2020/3/20
 */
@Controller
@RequestMapping("/ProjectFunction")
@Api(tags = "项目功能接口")
@Slf4j
public class ProjectFunctionController {

    @Autowired
    private ProjectFunctionService projectFunctionService;

    @Autowired
    private UserProjectRoleService userProjectRoleService;

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("编辑项目功能信息")
    public Response editProjectFunction(@RequestBody ProjectFunctionEdit projectFunctionEdit, BindingResult results){

        if(results.hasErrors()){
            log.error("editProjectFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectFunctionService.projectFunctionEdit(projectFunctionEdit);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/Delete")
    @ResponseBody
    @ApiOperation("删除项目功能信息")
    public Response deleteProjectFunction(@RequestParam(value = "id")Long id){


        if(null == id || id <= 0){
            return Response.createError("1","id不能为空或者小于等于0");
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectFunctionService.projectFunctionDelete(id);
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
    @ApiOperation("添加项目功能信息")
    public Response addProjectFunction(@RequestBody ProjectFunctionAdd projectFunctionAdd, BindingResult results){

        if(results.hasErrors()){
            log.error("addProjectFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectFunctionService.projectFunctionAdd(projectFunctionAdd);

        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("添加项目功能信息")
    public Response searchProjectFunction(@RequestParam(value = "id")Long id){

        if(null == id || id <= 0){
            return Response.createError("1","id不能为空或者小于等于0");
        }

        Response response = new Response();

        List<ProjectFunc> result = projectFunctionService.projectFunctionSearch(id);

        Map<String,List<ProjectFunc>> map = new HashMap<>();
        map.put("data",result);

        response.setCount(result.size());
        response.setData(map);
        response.setCode("0");
        response.setMsg("查询成功");

        return response;
    }
}
