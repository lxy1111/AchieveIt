package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.ProjectRole;
import com.apriltechnology.achieveit.mapper.ProjectRoleMapper;
import com.apriltechnology.achieveit.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户角色service实现层
 * @Author fjm
 * @Date 2020/3/23
 */
@Service
public class ProjectRoleServiceImpl implements ProjectRoleService {

    @Autowired
    private ProjectRoleMapper projectRoleMapper;


    @Override
    public List<ProjectRole> getAllProjectRoles() {

        List<ProjectRole> projectRoles = projectRoleMapper.getAllProjectRoles();
        return projectRoles;
    }
}
