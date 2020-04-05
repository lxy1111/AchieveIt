package com.apriltechnology.achieveit.service.impl;


import com.apriltechnology.achieveit.mapper.ProjectMemberMapper;
import com.apriltechnology.achieveit.service.ProjectMemberService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Autowired
    private ProjectMemberMapper projectMemberMapper;

    public Pair<Boolean,String> adjustQAMemberAssign(Long projectId){
        int result = projectMemberMapper.adjustQAMemberAssign(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    public Pair<Boolean,String> adjustEPGMemberAssign(Long projectId){
        int result = projectMemberMapper.adjustEPGMemberAssign(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    public Pair<Boolean,String> adjustDEVMemberAssign(Long projectId){
        int result = projectMemberMapper.adjustDEVMemberAssign(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }
}
