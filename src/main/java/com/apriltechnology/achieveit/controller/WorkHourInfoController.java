package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.entity.ProjectRole;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.service.WorkHourInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @ApiOperation("查询工时信息")
    public Response workHourInfoSearch(@RequestParam(value = "id") String id){

        if (!isValidDate(id)){
            return Response.createError("1","输入日期格式不对(yyyy-mm-dd)");
        }

        Response response = new Response();
        List<WorkHourInfo> workHourInfos = workHourInfoService.getWorkHourInfo(id);

        response.setCode("0");
        response.setMsg("查询成功！");
        Map<String,List<WorkHourInfo>> map = new HashMap<>();
        map.put("工时信息列表",workHourInfos);

        response.setData(map);
        response.setCount(workHourInfos.size());

        return response;

    }

    //判断输入字符串是否符合日期格式
    public static boolean isValidDate(String date){
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
