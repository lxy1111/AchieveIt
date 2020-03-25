package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectSubFunc;
import com.apriltechnology.achieveit.service.ProjectSubFunctionService;
import com.apriltechnology.achieveit.service.UserProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 项目子功能控制层
 * @Author fjm
 * @Date 2020/3/20
 */

@Controller
@RequestMapping("/ProjectSubFunction")
@Api(tags = "项目子功能接口")
@Slf4j
public class ProjectSubFunctionController {

    @Autowired
    private ProjectSubFunctionService projectSubFunctionService;

    @Autowired
    private UserProjectService userProjectService;

    @PostMapping("/SubEdit")
    @ResponseBody
    @ApiOperation("编辑项目子功能信息")
    @RequiresRoles("PM")
    public Response editProjectSubFunction(@RequestBody ProjectSubFunctionEdit projectSubFunctionEdit, BindingResult results){

        Pair<Boolean,String> auth = userProjectService.judgeUserProjectPermission(projectSubFunctionEdit.getProjectId(),"personManage");
        if(!auth.getKey()){
            return Response.createError("1",auth.getValue());
        }

        if(results.hasErrors()){
            log.error("editProjectSubFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionEdit(projectSubFunctionEdit);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }

    }

    @PostMapping("/SubDelete")
    @ResponseBody
    @ApiOperation("删除项目子功能信息")
    public Response deleteProjectSubFunction(@RequestParam(value = "id")Long id){


        if(null == id || id <= 0){
            return Response.createError("1","id不能为空或者小于等于0");
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionDelete(id);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/SubAdd")
    @ResponseBody
    @ApiOperation("添加项目子功能信息")
    public Response addProjectSubFunction(@RequestBody ProjectSubFunctionAdd projectSubFunctionAdd, BindingResult results){

        if(results.hasErrors()){
            log.error("editProjectSubFunction bindingResult",results.getFieldError().getField());
            return Response.createError("1",results.getFieldError().getField());
        }

        Response response = new Response();

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionAdd(projectSubFunctionAdd);

        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/SubSearch")
    @ResponseBody
    @ApiOperation("添加项目子功能信息")
    public Response searchProjectSubFunction(@RequestParam(value = "id")Long id){

        if(null == id || id <= 0){
            return Response.createError("1","id不能为空或者小于等于0");
        }

        Response response = new Response();

        List<ProjectSubFunc> result = projectSubFunctionService.projectSubFunctionSearch(id);

        Map<String,List<ProjectSubFunc>> map = new HashMap<>();
        map.put("data",result);

        response.setCount(result.size());
        response.setData(map);
        response.setCode("0");
        response.setMsg("查询成功");

        return response;
    }

    @PostMapping("/ExcelImport")
    @ApiOperation("Excel导入项目子功能信息")
    @ResponseBody
    public Response subFunctionExcelImport(@RequestParam(value = "file")MultipartFile file,@RequestParam(value = "id")Long id){

        Response response = new Response();
        if(file.isEmpty()){
            response.setCode("1");
            response.setMsg("文件为空！");
            return response;
        }

        if(!this.judgeExcelFile(file)){
            response.setCode("1");
            response.setMsg("文件格式错误！");
            return response;
        }

        Long size = file.getSize();
        if(size > 1024 * 1024 * 10){
            response.setCode("1");
            response.setMsg("文件大小超过10M!");
            return response;
        }

        Pair<Boolean,String> result = projectSubFunctionService.projectSubFunctionExcelImport(file,id);
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

    private Boolean judgeExcelFile(MultipartFile file){

        String extName = "";

        if(file.getOriginalFilename().lastIndexOf(".") != -1){
            extName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),
                    file.getOriginalFilename().length());
            if(extName.equals(".xlsx") || extName.equals(".xls")){
                return true;
            }
        }

        return false;
    }

}
