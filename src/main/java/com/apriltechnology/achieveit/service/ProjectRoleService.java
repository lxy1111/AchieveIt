package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.ProjectRole;

import java.util.List;

/**
 * @Description 用户项目角色service接口层
 * @Author fjm
 * @Date 2020/3/23
 */
public interface ProjectRoleService {

    /**
     * 获取所有的角色信息
     * @return
     */
    List<ProjectRole> getAllProjectRoles();

}
