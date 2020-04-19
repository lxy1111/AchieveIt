package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/25 16:24
 */
@Repository
public interface DeviceMapper {

    int insertDevice( Device deviceInfo);

    List<Device> getDeviceList(Long id, String deviceowner, String deviceId,Long deadline, int status, Integer pageFirst,Integer pageLast);

    Integer getDeviceCount(Long id,String deviceowner, String deviceId,Long deadline,int status);

    int updateDevice(DeviceSearch deviceSearch);

    int deleteDevice(List<Long> ids);


}
