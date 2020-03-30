package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.Response;
import com.apriltechnology.achieveit.dto.RiskSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;
import com.apriltechnology.achieveit.service.DeviceService;
import com.apriltechnology.achieveit.service.RiskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: lxy
 * @Date: 2020/3/30 18:20
 */
public class RiskController {

    @Autowired
    private RiskService riskService;

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
        map.put("deviceList",risks);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);

        return response;
    }

}
