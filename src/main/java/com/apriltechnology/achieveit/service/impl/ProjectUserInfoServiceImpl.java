package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.ProjectUserAdd;
import com.apriltechnology.achieveit.dto.ProjectUserEdit;
import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import com.apriltechnology.achieveit.entity.UserProjectRole;
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

    @Override
    public Pair<Boolean,String> judgeProjectUserInfo(ProjectUserAdd projectUserAdd) {
        List<UserProjectRole> projectUserInfos = projectUserInfoMapper.judgeProjectUserInfo(projectUserAdd);
        int result = projectUserInfos.size();
        if(result==0){
            return new Pair<>(true,"无重复项");
        }
        return new Pair<>(false,"该成员已经分配，请重新检查");
    }

    @Override
    public Pair<Boolean,String> projectUserAdd(ProjectUserAdd projectUserAdd){
        int result = projectUserInfoMapper.projectUserAdd(projectUserAdd);
        if(result <= 0){
            return new Pair<>(false,"新增失败！");
        }

        return new Pair<>(true,"新增成功！");
    }

    @Override
    public Pair<Boolean, String> projectUserEdit(ProjectUserEdit projectUserEdit) {
        int result = projectUserInfoMapper.projectUserEdit(projectUserEdit);
        if(result <= 0){
            return new Pair<>(false,"编辑失败！");
        }
        return new Pair<>(true,"编辑成功！");
    }
}
