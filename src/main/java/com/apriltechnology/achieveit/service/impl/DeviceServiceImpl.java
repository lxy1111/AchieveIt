package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.mapper.DeviceMapper;
import com.apriltechnology.achieveit.service.DeviceService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/25 18:39
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public  List<Device> getDeviceList(DeviceSearch deviceSearch){
        Integer pageFirst = (deviceSearch.getPageNum()-1)*deviceSearch.getPageSize();
        Integer pageLast = pageFirst + deviceSearch.getPageSize();
        List<Device> devicelist=deviceMapper.getDeviceList(deviceSearch.getId(),deviceSearch.getProjectID(),
                deviceSearch.getDeviceowner(),deviceSearch.getDeadline(),deviceSearch.getStatus(),pageFirst,pageLast);
        return devicelist;

    }

    @Override
    public Integer getDeviceCount(DeviceSearch deviceSearch){
        Integer cnt=deviceMapper.getDeviceCount(deviceSearch.getId(),deviceSearch.getProjectID(),
                deviceSearch.getDeviceowner(),deviceSearch.getDeadline(),deviceSearch.getStatus());
        return cnt;
    }

    @Override
    public Pair<Boolean,String> editDevice(DeviceSearch deviceSearch){
        int result = deviceMapper.updateDevice(deviceSearch);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }else{
            return new Pair<>(true,"更新成功！");
        }

    }

}
