package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.DeviceAdd;
import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.ProjectInfoAdd;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import com.apriltechnology.achieveit.mapper.DeviceMapper;
import com.apriltechnology.achieveit.service.DeviceService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        List<Device> devicelist=deviceMapper.getDeviceList(deviceSearch.getId(),
                deviceSearch.getDeviceowner(),deviceSearch.getDeviceId(),deviceSearch.getDeadline(),deviceSearch.getStatus(),pageFirst,pageLast);
        return devicelist;

    }

    @Override
    public Pair<Boolean, String> insertDevice(DeviceAdd deviceAdd) {

        Device deviceInfo = this.dataChange(deviceAdd);
        int count = deviceMapper.insertDevice(deviceInfo);
        if(count > 0){
            return new Pair<>(true,"新增成功！");
        }else{
            return new Pair<>(false,"新增失败！");
        }

    }

    private Device dataChange(DeviceAdd deviceAdd){
        Device deviceInfo = new Device();
        deviceInfo.setDeviceId(deviceAdd.getDeviceId());
        deviceInfo.setStatus(deviceAdd.getStatus());
        deviceInfo.setDeviceowner(deviceAdd.getDeviceowner());
        deviceInfo.setDeadline(deviceAdd.getDeadline());
        return deviceInfo;
    }

    @Override
    public Integer getDeviceCount(DeviceSearch deviceSearch){
        Integer cnt=deviceMapper.getDeviceCount(deviceSearch.getId(),
                deviceSearch.getDeviceowner(),deviceSearch.getDeviceId(),deviceSearch.getDeadline(),deviceSearch.getStatus());
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public Pair<Boolean, String> deleteDevice(List<Long> ids) throws BatchDeleteException {

        if(null != ids && ids.size() > 0){
            int size = ids.size();
            int result = deviceMapper.deleteDevice(ids);
            if(result == size){
                return new Pair<>(true,"删除成功！");
            }else{
                throw new BatchDeleteException("删除失败！");
            }
        }

        return new Pair<>(false,"请选择需要删除的项目！");
    }


}
