package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 项目成员类接口
 * @Author br
 * @Date 2020/3/27
 */

@Repository
public interface ProjectUserInfoMapper {
    /**
     * 通过projectId查询项目成员信息以及项目上级信息
     * @return
     */

    List<ProjectUserInfo> getProjectUserInfoList (@Param("projectId")Long projectId);
}
