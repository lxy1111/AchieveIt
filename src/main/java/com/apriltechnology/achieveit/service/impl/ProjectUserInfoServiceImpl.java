package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import com.apriltechnology.achieveit.mapper.ProjectUserInfoMapper;
import com.apriltechnology.achieveit.service.ProjectUserInfoService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 组员管理service实现类
 * @Author br
 * @Date 2020/3/27
 */

@Service
public class ProjectUserInfoServiceImpl implements ProjectUserInfoService {
    @Autowired
    private ProjectUserInfoMapper projectUserInfoMapper;

    @Override
    public List<ProjectUserInfo> getProjectUserInfoList (Long projectId){
        List<ProjectUserInfo> projectUserInfos = projectUserInfoMapper.getProjectUserInfoList(projectId);
        return projectUserInfos;
    }

    @Override
    public Pair<Boolean,String> projectUserDelete(Long projectId, Long userId){
        int result = projectUserInfoMapper.projectUserDelete(projectId,userId);
        if(result <= 0){
            return new Pair<>(false,"删除失败！");
        }

        return new Pair<>(true,"删除成功！");
    }
}
