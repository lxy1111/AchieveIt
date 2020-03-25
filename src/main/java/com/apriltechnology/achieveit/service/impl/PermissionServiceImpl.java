package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.Permission;
import com.apriltechnology.achieveit.mapper.PermissionMapper;
import com.apriltechnology.achieveit.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 角色权限service实现类
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getRolePermissions(Long roleId) {

        List<Permission> permissions = permissionMapper.getPermissionByRoleId(roleId);

        return permissions;
    }
}
