package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectInfoSearch;
import com.apriltechnology.achieveit.entity.ProjectInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

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
    List<ProjectInfo> getMyTaskProjectInfo(@Param("leader")String leader,@Param("status")Integer status);

    /**
     * 查询我创建的任务
     * @param createrId
     * @return
     */
    List<ProjectInfo> getMyProjectInfo(@Param("createrId")Long createrId);

}
