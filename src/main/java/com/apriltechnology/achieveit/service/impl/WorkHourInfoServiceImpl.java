package com.apriltechnology.achieveit.service.impl;


import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.mapper.WorkHourInfoMapper;
import com.apriltechnology.achieveit.service.WorkHourInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 工时service实现类
 * @Author br
 * @Date 2020/3/24
 */
@Service
public class WorkHourInfoServiceImpl implements WorkHourInfoService {
    @Autowired
    private WorkHourInfoMapper workHourInfoMapper;

    @Override
    public List<WorkHourInfo> getWorkHourInfo(String date){
        List<WorkHourInfo> workHourInfos = workHourInfoMapper.getWorkHourInfoList(date);
        return workHourInfos;
    }
}
