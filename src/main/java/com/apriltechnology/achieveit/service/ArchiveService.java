package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.Archives;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 档案接口类
 * @Author br
 * @Date 2020/4/8
 */

public interface ArchiveService {
    List<Archives> getArchivesList(Long projectId);

    Pair<Boolean,String> archivesAdd(Long projectId);

    Pair<Boolean,String> acceptProjectBasicTable(Long projectId);

    Pair<Boolean,String> acceptProjectProposal(Long projectId);

    Pair<Boolean,String> acceptProjectPrice(Long projectId);

    Pair<Boolean,String> acceptProjectEstimate(Long projectId);

    Pair<Boolean,String> acceptProjectSchedule(Long projectId);

    Pair<Boolean,String> acceptProjectProcess(Long projectId);

    Pair<Boolean,String> acceptProjectCost(Long projectId);

    Pair<Boolean,String> acceptProjectDemand(Long projectId);

    Pair<Boolean,String> acceptProjectRisk(Long projectId);

    Pair<Boolean,String> acceptProblem(Long projectId);

    Pair<Boolean,String> acceptReport(Long projectId);

    Pair<Boolean,String> acceptProjectSummary(Long projectId);

    Pair<Boolean,String> acceptBestExperience(Long projectId);

    Pair<Boolean,String> acceptDevelopTool(Long projectId);

    Pair<Boolean,String> acceptDevelopModel(Long projectId);

    Pair<Boolean,String> acceptExamine(Long projectId);

    Pair<Boolean,String> acceptQASummary(Long projectId);
}
