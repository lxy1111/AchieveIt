package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.RiskSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/30 18:14
 */
public interface RiskService {


    List<Risk> getRiskList(RiskSearch riskSearch);

    Integer getRiskCount(RiskSearch riskSearch);
}
