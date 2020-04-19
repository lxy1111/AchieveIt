package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import javafx.util.Pair;

/**
 * @Description 用户项目权限service接口层
 * @Author fjm
 * @Date 2020/4/15
 */
public interface ProjectPermissionService {

    /**
     * 新增用户项目权限信息
     * @param userProjectPermissionInfo
     * @return
     */
    Pair<Boolean,String> addUserProjectPermission(UserProjectPermissionInfo userProjectPermissionInfo);

    /**
     * 编辑用户项目权限信息
     * @param userProjectPermissionInfo
     * @return
     */
    Pair<Boolean,String> editUserpRrojectPermission(UserProjectPermissionInfo userProjectPermissionInfo);

    /**
     * 查询用户项目权限信息
     * @param projectId
     * @param userId
     * @return
     */
    UserProjectPermission searchUserProjectPermission(Long projectId,Long userId);
}
