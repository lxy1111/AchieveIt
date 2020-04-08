package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.Archives;
import com.apriltechnology.achieveit.mapper.ArchivesMapper;
import com.apriltechnology.achieveit.service.ArchiveService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 档案service实现类
 * @Author br
 * @Date 2020/4/8
 */
@Service
public class ArchiveServiceImpl implements ArchiveService {
    @Autowired
    private ArchivesMapper archivesMapper;

    public List<Archives> getArchivesList(Long projectId){
        List<Archives> archiveInfo = archivesMapper.getArchivesList(projectId);
        return archiveInfo;
    }

    public Pair<Boolean,String> archivesAdd(Long projectId){
        int result = archivesMapper.archivesAdd(projectId);
        if(result <= 0){
            return new Pair<>(false,"档案新增失败！");
        }
        return new Pair<>(true,"档案新增成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectBasicTable(Long projectId) {
        int result = archivesMapper.acceptProjectBasicTable(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectProposal(Long projectId) {
        int result = archivesMapper.acceptProjectProposal(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectPrice(Long projectId) {
        int result = archivesMapper.acceptProjectPrice(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectEstimate(Long projectId) {
        int result = archivesMapper.acceptProjectEstimate(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectSchedule(Long projectId) {
        int result = archivesMapper.acceptProjectSchedule(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectProcess(Long projectId) {
        int result = archivesMapper.acceptProjectProcess(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectCost(Long projectId) {
        int result = archivesMapper.acceptProjectCost(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectDemand(Long projectId) {
        int result = archivesMapper.acceptProjectDemand(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectRisk(Long projectId) {
        int result = archivesMapper.acceptProjectRisk(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProblem(Long projectId) {
        int result = archivesMapper.acceptProblem(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptReport(Long projectId) {
        int result = archivesMapper.acceptReport(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptProjectSummary(Long projectId) {
        int result = archivesMapper.acceptProjectSummary(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptBestExperience(Long projectId) {
        int result = archivesMapper.acceptBestExperience(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptDevelopTool(Long projectId) {
        int result = archivesMapper.acceptDevelopTool(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptDevelopModel(Long projectId) {
        int result = archivesMapper.acceptDevelopModel(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptExamine(Long projectId) {
        int result = archivesMapper.acceptExamine(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }

    @Override
    public Pair<Boolean, String> acceptQASummary(Long projectId) {
        int result = archivesMapper.acceptQASummary(projectId);
        if(result <= 0){
            return new Pair<>(false,"状态更新失败！");
        }
        return new Pair<>(true,"状态更新成功！");
    }
}
