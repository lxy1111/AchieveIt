package com.apriltechnology.achieveit.service.impl;


import com.apriltechnology.achieveit.dto.WorkHourAdd;
import com.apriltechnology.achieveit.dto.WorkHourEdit;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import com.apriltechnology.achieveit.mapper.WorkHourInfoMapper;
import com.apriltechnology.achieveit.service.WorkHourInfoService;
import javafx.util.Pair;
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
    public List<WorkHourInfo> managerGetWorkHourInfo(Long projectId, String date){
        List<WorkHourInfo> workHourInfos = workHourInfoMapper.managerGetWorkHourInfoList(projectId,date);
        return workHourInfos;
    }
    @Override
    public List<WorkHourInfo> userGetWorkHourInfo(Long projectId,Long userId){
        List<WorkHourInfo> workHourInfos = workHourInfoMapper.userGetWorkHourInfoList(projectId,userId);
        return workHourInfos;
    }

    @Override
    public Pair<Boolean,String> acceptWorkHourInfo(Long workHourId){
        int result = workHourInfoMapper.acceptWorkHourInfo(workHourId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }
    @Override
    public Pair<Boolean,String> rejectWorkHourInfo(Long workHourId){
        int result = workHourInfoMapper.rejectWorkHourInfo(workHourId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean,String> workHourInfoAdd(WorkHourAdd workHourAdd){
        int result = workHourInfoMapper.workHourInfoAdd(workHourAdd);
        if(result <= 0){
            return new Pair<>(false,"工时添加失败！");
        }
        return new Pair<>(true,"工时添加成功！");
    }

    @Override
    public Pair<Boolean,String> workHourInfoEdit(WorkHourEdit workHourEdit){
        int result = workHourInfoMapper.workHourInfoEdit(workHourEdit);
        if(result <= 0){
            return new Pair<>(false,"工时编辑失败！");
        }
        return new Pair<>(true,"工时编辑成功！");
    }
}
