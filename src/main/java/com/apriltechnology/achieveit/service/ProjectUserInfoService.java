package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.ProjectUserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description 组员信息service接口类
 * @Author br
 * @Date 2020/3/27
 */

public interface ProjectUserInfoService {
    List<ProjectUserInfo> getProjectUserInfoList (Long projectId);
}
