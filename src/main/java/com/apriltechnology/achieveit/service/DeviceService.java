package com.apriltechnology.achieveit.service;


import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.entity.Device;
import javafx.util.Pair;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/25 16:29
 */
public interface DeviceService {

    List<Device> getDeviceList(DeviceSearch deviceSearch);

    Integer getDeviceCount(DeviceSearch deviceSearch);

    Pair<Boolean,String> editDevice(DeviceSearch deviceSearch);

}
