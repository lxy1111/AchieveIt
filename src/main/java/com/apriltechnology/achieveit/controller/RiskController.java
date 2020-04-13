package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.*;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.service.DeviceService;
import com.apriltechnology.achieveit.service.RiskService;
import com.apriltechnology.achieveit.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lxy
 * @Date: 2020/3/30 18:20
 */

@Controller
@RequestMapping("/Risk")
@Api(tags = "风险信息接口")
@Slf4j
public class RiskController {

    @Autowired
    private RiskService riskService;



    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("新增风险信息")
    Response riskInfoAdd(@RequestBody RiskAdd riskAdd){

        Response response = new Response();

        User user = UserUtil.get();
        Pair<Boolean,String> result = riskService.insertRisk(riskAdd);
        if(!result.getKey()){
            return Response.createError("1",result.getValue());
        }

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

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("更新风险信息")
    Response editRisk(@RequestBody RiskSearch riskSearch){

        Response response = new Response();

        Pair<Boolean,String> result = riskService.editRisk(riskSearch);
        if(result.getKey()){
            response.setCode("0");
            response.setMsg(result.getValue());
            return response;
        }else{
            return Response.createError("`1",result.getValue());
        }
    }



    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("查询风险信息")
    Response riskSearch(@RequestBody RiskSearch riskSearch){

        if(null == riskSearch.getPageNum()){
            riskSearch.setPageNum(0);
        }

        if(null == riskSearch.getPageSize()){
            riskSearch.setPageSize(10);
        }

        Response response = new Response();

        Integer count = riskService.getRiskCount(riskSearch);

        List<Risk> risks = riskService.getRiskList(riskSearch);
        Map<String,List<Risk>> map = new HashMap<>();
        map.put("riskList",risks);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);


        return response;
    }

}
