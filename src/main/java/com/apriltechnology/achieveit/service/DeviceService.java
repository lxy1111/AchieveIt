package com.apriltechnology.achieveit.service;


import com.apriltechnology.achieveit.dto.DeviceAdd;
import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.ProjectInfoAdd;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import javafx.util.Pair;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/25 16:29
 */
public interface DeviceService {


    Pair<Boolean,String> insertDevice(DeviceAdd deviceAdd);

    List<Device> getDeviceList(DeviceSearch deviceSearch);

    Integer getDeviceCount(DeviceSearch deviceSearch);

    Pair<Boolean,String> editDevice(DeviceSearch deviceSearch);

    Pair<Boolean,String> deleteDevice(List<Long> ids) throws BatchDeleteException;

}
