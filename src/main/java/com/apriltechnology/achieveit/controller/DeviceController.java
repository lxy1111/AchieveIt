package com.apriltechnology.achieveit.controller;

import com.apriltechnology.achieveit.dto.*;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.service.DeviceService;
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
 * @Author: lxy
 * @Date: 2020/3/25 19:43
 */

@Controller
@RequestMapping("/Device")
@Api(tags = "设备信息接口")
@Slf4j
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping("/Add")
    @ResponseBody
    @ApiOperation("新增设备信息")
    Response deviceInfoAdd(@RequestBody DeviceAdd deviceAdd){

        Response response = new Response();

        User user = UserUtil.get();
        Pair<Boolean,String> result = deviceService.insertDevice(deviceAdd);
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

    @PostMapping("/Search")
    @ResponseBody
    @ApiOperation("查询设备信息")
    Response deviceSearch(@RequestBody DeviceSearch deviceSearch){

        if(null == deviceSearch.getPageNum()){
            deviceSearch.setPageNum(0);
        }

        if(null == deviceSearch.getPageSize()){
            deviceSearch.setPageSize(10);
        }

        Response response = new Response();

        Integer count = deviceService.getDeviceCount(deviceSearch);

        List<Device> devices = deviceService.getDeviceList(deviceSearch);
        Map<String,List<Device>> map = new HashMap<>();
        map.put("deviceList",devices);

        response.setCode("0");
        response.setMsg("查询成功");
        response.setCount(count);
        response.setData(map);

        return response;
    }

    @PostMapping("/Edit")
    @ResponseBody
    @ApiOperation("更新设备信息")
    Response editDevice(@RequestBody DeviceSearch deviceSearch){

        Response response = new Response();

        Pair<Boolean,String> result = deviceService.editDevice(deviceSearch);
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
    @ApiOperation("删除设备")
    Response deleteDevices(@RequestBody List<Long> ids){

        Response response = new Response();

        try {
            Pair<Boolean,String> result = deviceService.deleteDevice(ids);
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
            log.error("deleteDevices", ExceptionUtils.getStackTrace(e));
            response.setCode("1");
            response.setMsg(e.getMessage());
            return response;
        }

    }


}
