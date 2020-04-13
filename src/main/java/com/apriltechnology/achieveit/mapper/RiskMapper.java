package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.Device;
import com.apriltechnology.achieveit.entity.Risk;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: lxy
 * @Date: 2020/3/30 17:09
 */
@Repository
public interface RiskMapper {

    int insertRisk(Risk riskInfo);

    List<Risk> getRiskList(Long id, Long projectID, String type, String description, Long level, Long effect, String strategy, Long status, String responsible, Long frequency, String relevant, Integer pageFirst, Integer pageLast);

    Integer getRiskCount(Long id, Long projectID, String type, String description, Long level,Long effect,String strategy,Long status, String responsible,Long frequency,String relevant);



}
