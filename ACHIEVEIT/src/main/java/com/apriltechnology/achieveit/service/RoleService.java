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
     * 根据userId获取用户角色信息
     * @param userId
     * @return
     */
    List<Role> getUserRoles(Integer userId);
}
