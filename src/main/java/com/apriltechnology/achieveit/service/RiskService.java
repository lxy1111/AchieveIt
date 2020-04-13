package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.DeviceAdd;
import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.RiskAdd;
import com.apriltechnology.achieveit.dto.RiskSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;
import javafx.util.Pair;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/30 18:14
 */
public interface RiskService {


    Pair<Boolean,String> insertRisk(RiskAdd riskAdd);

    List<Risk> getRiskList(RiskSearch riskSearch);

    Integer getRiskCount(RiskSearch riskSearch);
}
