package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.DefectAdd;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.Defect;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.service.DefectService;
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

@Controller
@RequestMapping("/Defect")
@Api(tags = "缺陷信息接口")
@Slf4j

public class DefectController {
    @Autowired
    private DefectService defectService;

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("查询缺陷信息")
    public Response getDefectInfo(@RequestParam(value = "projectId")Long projectId){
        Response response = new Response();
        List<Defect>defects = defectService.getDefectInfo(projectId);
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<Defect>> map = new HashMap<>();
        map.put("缺陷信息列表",defects);

        response.setData(map);
        response.setCount(defects.size());
        return response;
    }

    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("添加缺陷信息")
    public Response defectAdd(@RequestBody DefectAdd defectAdd){
        Response response = new Response();
        Pair<Boolean,String> result = defectService.defectAdd(defectAdd);
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
    @ApiOperation("删除缺陷信息")
    public Response defectDelete(@RequestParam(value = "id")Long id){
        Response response = new Response();
        Pair<Boolean,String> result = defectService.defectDelete(id);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }
}
