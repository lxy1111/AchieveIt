package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Description ProjectInfo类mapper接口
 * @Author fjm
 * @Date 2020/3/17
 */
@Repository
public interface ProjectInfoMapper {


    /**
     * 查询项目
     * @return
     */
    List<ProjectInfo> getProjectInfoList(Long id, String projectName, String customerInfo, String leader, String milepost, String projectFunction,
                                         String technology, String businessArea, Timestamp scheduleTime, Timestamp deliveryTime, Integer offset, Integer limit);

    /**
     * 查询项目数量
     * @return
     */
    Integer getProjectInfoCount(Long id, String projectName, String customerInfo, String leader, String milepost, String projectFunction,
                                String technology, String businessArea, Timestamp scheduleTime, Timestamp deliveryTime);


    /**
     * 更新项目信息
     * @param projectInfoSearch
     * @return
     */
    int updateProjectInfo(ProjectInfoSearch projectInfoSearch);

    /**
     * 删除项目
     * @param ids
     * @return
     */
    int deleteProjectInfo(List<Long> ids);

    /**
     * 新增项目
     * @param projectInfo
     * @return
     */
    int insertProjectInfo( ProjectInfo projectInfo);

    /**
     * 获取项目状态信息
     * @param projectId
     * @return
     */
    int getProjectStatus(@Param("projectId") Long projectId);

    /**
     * 改变项目状态信息
     * @param projectId
     * @param status
     * @return
     */
    int changeProjectStatus(@Param("projectId")Long projectId,@Param("status")Integer status);

    /**
     * 查询待审批项目
     * @param leader
     * @param status
     * @return
     */
    List<ProjectInfo> getMyTaskProjectInfo(@Param("leader")String leader,@Param("status")Integer status,@Param("offset")Integer offset,@Param("limit")Integer limit);

    /**
     * 查询待审批项目数量
     * @param leader
     * @param status
     * @return
     */
    Integer getMyTaskProjectInfoCount(@Param("leader")String leader,@Param("status")Integer status);

    /**
     * 查询我创建的任务
     * @param createrId
     * @return
     */
    List<ProjectInfo> getMyProjectInfo(@Param("createrId")Long createrId,@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 查询我创建的任务数量
     * @param createrId
     * @return
     */
    Integer getMyProjectInfoCount(@Param("createrId")Long createrId);

    /**
     * 查询QA待分配的项目
     * @param offset
     * @param limit
     * @return
     */
    List<ProjectInfo> getQALeaderProject(@Param("offset")Integer offset,@Param("limit")Integer limit,@Param("status")Integer status);

    /**
     * 查询QA待分配的项目数量
     * @param status
     * @return
     */
    Integer getQALeaderProjectCount(@Param("status")Integer status);

    /**
     * 查询EPG待分配的项目
     * @param offset
     * @param limit
     * @param status
     * @return
     */
    List<ProjectInfo> getEPGLeaderProject(@Param("offset")Integer offset,@Param("limit")Integer limit,@Param("status")Integer status);

    /**
     * 查询EPG待分配的项目数量
     * @param status
     * @return
     */
    Integer getEPGLeaderProjectCount(@Param("status")Integer status);

    /**
     * 项目组员获取自己的项目id
     * @param offset
     * @param limit
     * @param userId
     * @return
     */
    List<Long> getMemberProjectIds(@Param("offset")Integer offset,@Param("limit")Integer limit,@Param("userId")Long userId);

    /**
     * 项目组员获取自己的项目数量
     * @param userId
     * @return
     */
    Integer getMemberProjectIdsCount(@Param("userId")Long userId);

    /**
     * 根据id列表获取项目信息
     * @param ids
     * @return
     */
    List<ProjectInfo> getProjectInfosByIds(@Param("list") List<Long> ids);

    /**
     * 根据id获取项目信息
     * @param projectId
     * @return
     */
    ProjectInfo getProjectInfoById(@Param("projectId") Long projectId);
}
