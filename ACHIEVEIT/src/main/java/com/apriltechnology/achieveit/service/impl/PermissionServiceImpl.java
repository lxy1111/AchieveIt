package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.Permission;
import com.apriltechnology.achieveit.entity.Role;
import com.apriltechnology.achieveit.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 角色权限service实现类
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<Permission> getRolePermissions(List<Role> roles) {
        return null;
    }
}
