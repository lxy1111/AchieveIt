package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.Role;
import com.apriltechnology.achieveit.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户角色service实现类
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getUserRoles(Integer userId) {
        return null;
    }
}
