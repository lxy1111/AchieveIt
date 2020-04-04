package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.WorkHourAdd;
import com.apriltechnology.achieveit.dto.WorkHourEdit;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.service.WorkHourInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 工时信息控制层
 * @Author br
 * @Date 2020/3/24
 */

@Controller
@RequestMapping("/WorkHourInfo")
@Api(tags = "工时信息接口")
@Slf4j

public class WorkHourInfoController {

    @Autowired
    private WorkHourInfoService workHourInfoService;

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("项目经理查询工时信息")
    public Response managerWorkHourInfoSearch(@RequestParam(value = "projectId") Long projectId,@RequestParam(value = "id") String id){

        if (!isValidDate(id)){
            return Response.createError("1","输入日期格式不对(yyyy-mm-dd)");
        }

        Response response = new Response();
        List<WorkHourInfo> workHourInfos = workHourInfoService.managerGetWorkHourInfo(projectId,id);

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<WorkHourInfo>> map = new HashMap<>();
        map.put("工时信息列表",workHourInfos);

        response.setData(map);
        response.setCount(workHourInfos.size());

        return response;
    }

    @PostMapping("/MyWorkHours")
    @ResponseBody
    @ApiOperation("普通员工查询工时信息")
    public Response userWorkHourInfoSearch(@RequestParam(value = "projectId")Long projectId,@RequestParam(value = "userId")Long userId){
        Response response = new Response();
        List<WorkHourInfo> workHourInfos = workHourInfoService.userGetWorkHourInfo(projectId,userId);
        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<WorkHourInfo>> map = new HashMap<>();
        map.put("成员工时信息列表",workHourInfos);

        response.setData(map);
        response.setCount(workHourInfos.size());

        return response;
    }

    @PostMapping("/Accept")
    @ResponseBody
    @ApiOperation("审批通过工时信息")
    public Response acceptWorkHourInfo(@RequestParam(value = "id")Long id){
        Response response = new Response();
        Pair<Boolean,String> result = workHourInfoService.acceptWorkHourInfo(id);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/Reject")
    @ResponseBody
    @ApiOperation("审批拒绝工时信息")
    public Response rejectWorkHourInfo(@RequestParam(value = "id")Long id){
        Response response = new Response();
        Pair<Boolean,String> result = workHourInfoService.rejectWorkHourInfo(id);
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
    @ApiOperation("添加工时信息")
    public Response workHourInfoAdd(@RequestBody WorkHourAdd workHourAdd){
        Timestamp timestamp = workHourAdd.getStartTime();
        Date ts = new Date(timestamp.getTime());
        Date currentTime = new Date();
        long day = (currentTime.getTime()-ts.getTime())/(24*60*60*1000);
        if (day>=3){
            return Response.createError("1","工时报告最多延期三天，已超时！");
        }
        Response response = new Response();
        Pair<Boolean,String> result = workHourInfoService.workHourInfoAdd(workHourAdd);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("修改工时信息")
    public Response workHourInfoEdit(@RequestBody WorkHourEdit workHourEdit){
        Timestamp timestamp = workHourEdit.getStartTime();
        Date ts = new Date(timestamp.getTime());
        Date currentTime = new Date();
        long day = (currentTime.getTime()-ts.getTime())/(24*60*60*1000);
        if (day>=3){
            return Response.createError("1","工时报告最多延期三天，请重新修改！");
        }
        Response response = new Response();
        Pair<Boolean,String> result = workHourInfoService.workHourInfoEdit(workHourEdit);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else {
            return Response.createError("1",result.getValue());
        }
    }

    //判断输入字符串是否符合日期格式
    private static boolean isValidDate(String date){
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.setLenient(false);
            format.parse(date);
        }catch (ParseException e){
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
