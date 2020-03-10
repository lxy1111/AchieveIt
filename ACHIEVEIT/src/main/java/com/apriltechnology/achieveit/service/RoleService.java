package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.Role;

import java.util.List;

/**
 * @Description 用户角色service接口类
 * @Author fjm
 * @Date 2020/3/9
 */
public interface RoleService {

    /**
     * 获取所有角色信息
     * @return
     */
    List<Role> getAllRoles();
}
