package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectInfoAdd;
import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import com.apriltechnology.achieveit.exception.BatchDeleteException;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 项目信息service接口类
 * @Author fjm
 * @Date 2020/3/17
 */
public interface ProjectInfoService {

    /**
     * 根据用户输入获取项目信息
     * @param projectInfoSearch
     * @return
     */
    List<ProjectInfo> getProjectInfo(ProjectInfoSearch projectInfoSearch);

    /**
     * 查询项目数量
     * @param projectInfoSearch
     * @return
     */
    Integer getProjectInfoCount(ProjectInfoSearch projectInfoSearch);

    /**
     * 更新项目信息
     * @param projectInfoSearch
     * @return
     */
    Pair<Boolean,String> editProjectInfo(ProjectInfoSearch projectInfoSearch);


    /**
     * 批量删除项目
     * @param projectIds
     * @return
     */
    Pair<Boolean,String> deleteProjectInfo(List<Long> projectIds) throws BatchDeleteException;

    /**
     * 新增项目
     * @param projectInfoAdd
     * @param createId
     * @param status
     * @return
     */
    Pair<Boolean,String> insertProjectInfo(ProjectInfoAdd projectInfoAdd,Long createId,int status);

    /**
     * 获取项目状态信息
     * @param projectId
     * @return
     */
    int getProjectStatus(Long projectId);

    /**
     * 改变项目状态信息
     * @param projectId
     * @param status
     * @return
     */
    Pair<Boolean,String> changeProjectStatus(Long projectId,Integer status);

    /**
     * 查询待审批项目
     * @param leader
     * @param status
     * @return
     */
    List<ProjectInfo> searchMyTaskProjectInfo(String leader,Integer status,Integer pageNum,Integer pageSize);

    /**
     * 查询待审批项目数量
     * @param leader
     * @param status
     * @return
     */
    int searchMyTaskProjectInfoCount(String leader,Integer status);

    /**
     * 查询我创建的项目
     * @param createrId
     * @return
     */
    List<ProjectInfo> searchMyProjectInfo(Long createrId,Integer pageSize,Integer pageNum);

    /**
     * 查询我创建的项目数量
     * @param createrId
     * @return
     */
    int searchMyProjectInfoCount(Long createrId);

    /**
     * 查询QALeader待分配项目
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProjectInfo> searchQALeaderProject(Integer pageNum,Integer pageSize );

    /**
     * 查询QALeader待分配项目数量
     * @return
     */
    int searchQALeaderProjectCount();

    /**
     * 查询EPGLeader待分配项目
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProjectInfo> searchEPGLeaderProject(Integer pageNum,Integer pageSize);

    /**
     * 查询EPGLeader待分配项目数量
     * @return
     */
    int searchEPGLeaderProjectCount();

    /**
     * 项目组员获取自己的项目信息
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ProjectInfo> getMemberProjectInfo(Long userId,Integer pageNum,Integer pageSize);

    /**
     * 项目组员获取自己的项目信息数量
     * @param userId
     * @return
     */
    int getMemberProjectInfoCount(Long userId);

    /**
     * 获取项目创建者id
     * @param projectId
     * @return
     */
    Long getProjectCreaterId(Long projectId);

}
