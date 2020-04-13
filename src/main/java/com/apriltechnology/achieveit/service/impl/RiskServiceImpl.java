package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.DeviceAdd;
import com.apriltechnology.achieveit.dto.DeviceSearch;
import com.apriltechnology.achieveit.dto.RiskAdd;
import com.apriltechnology.achieveit.dto.RiskSearch;
import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;
import com.apriltechnology.achieveit.mapper.RiskMapper;
import com.apriltechnology.achieveit.service.RiskService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/30 18:15
 */
@Service
public class RiskServiceImpl implements RiskService {


    @Autowired
    private RiskMapper riskMapper;

    @Override
    public Pair<Boolean,String> insertRisk(RiskAdd riskAdd){


        Risk riskInfo = this.dataChange(riskAdd);
        int count = riskMapper.insertRisk(riskInfo);
        if(count > 0){
            return new Pair<>(true,"新增成功！");
        }else{
            return new Pair<>(false,"新增失败！");
        }

    }

    private Risk dataChange(RiskAdd riskAdd){
        Risk riskInfo = new Risk();
        riskInfo.setDescription(riskAdd.getDescription());
        riskInfo.setEffect(riskAdd.getEffect());
        riskInfo.setFrequency(riskAdd.getFrequency());
        riskInfo.setLevel(riskAdd.getLevel());
        riskInfo.setProjectID(riskAdd.getProjectID());
        riskInfo.setRelevant(riskAdd.getRelevant());
        riskInfo.setResponsible(riskAdd.getResponsible());
        riskInfo.setStatus(riskAdd.getStatus());
        riskInfo.setStrategy(riskAdd.getStrategy());
        riskInfo.setType(riskAdd.getType());
        return riskInfo;
    }

    @Override
    public List<Risk> getRiskList(RiskSearch riskSearch){
        Integer pageFirst = (riskSearch.getPageNum()-1)*riskSearch.getPageSize();
        Integer pageLast = pageFirst + riskSearch.getPageSize();
        List<Risk> riskList=riskMapper.getRiskList(riskSearch.getId(),riskSearch.getProjectID(),
                riskSearch.getType(),riskSearch.getDescription(),riskSearch.getLevel(),riskSearch.getEffect(),riskSearch.getStrategy(),riskSearch.getStatus(),riskSearch.getResponsible(),riskSearch.getFrequency(),riskSearch.getRelevant(), pageFirst,pageLast);
        return riskList;

    }

    @Override
    public Integer getRiskCount(RiskSearch riskSearch){
        Integer cnt=riskMapper.getRiskCount(riskSearch.getId(),riskSearch.getProjectID(),
                riskSearch.getType(),riskSearch.getDescription(),riskSearch.getLevel(),riskSearch.getEffect(),riskSearch.getStrategy(),riskSearch.getStatus(),riskSearch.getResponsible(),riskSearch.getFrequency(),riskSearch.getRelevant());
        return cnt;
    }


}
