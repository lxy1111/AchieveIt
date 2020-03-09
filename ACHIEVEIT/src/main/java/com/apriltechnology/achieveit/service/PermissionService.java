package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.Permission;
import com.apriltechnology.achieveit.entity.Role;

import java.util.List;

/**
 * @Description 角色权限service接口类
 * @Author fjm
 * @Date 2020/3/9
 */
public interface PermissionService {

    /**
     * 根据role获取用户角色权限信息
     * @param roles
     * @return
     */
    List<Permission> getRolePermissions(List<Role> roles);

}
