package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectUserAdd;
import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import javafx.util.Pair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 组员信息service接口类
 * @Author br
 * @Date 2020/3/27
 */

public interface ProjectUserInfoService {
    /**
     * 通过项目id查询项目的组员
     * @param projectId
     * @return
     */
    List<ProjectUserInfo> getProjectUserInfoList (Long projectId);

    /**
     * 通过项目id和userId删除项目组员表关联项
     * @param projectId
     * @param userId
     * @return
     */
    Pair<Boolean,String> projectUserDelete(Long projectId,Long userId);

    Pair<Boolean,String> judgeProjectUserInfo(ProjectUserAdd projectUserAdd);

    /**
     * 添加组员信息
     * @param projectUserAdd
     * @return
     */
    Pair<Boolean,String> projectUserAdd(ProjectUserAdd projectUserAdd);
}
