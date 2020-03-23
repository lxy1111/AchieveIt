package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.Permission;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProject;
import com.apriltechnology.achieveit.mapper.PermissionMapper;
import com.apriltechnology.achieveit.mapper.UserMapper;
import com.apriltechnology.achieveit.mapper.UserProjectMapper;
import com.apriltechnology.achieveit.service.UserProjectService;
import com.apriltechnology.achieveit.shiro.JWTToken;
import com.apriltechnology.achieveit.util.JWTUtil;
import javafx.util.Pair;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 用户项目信息service实现类
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class UserProjectServiceImpl implements UserProjectService {

    @Autowired
    private UserProjectMapper userProjectMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserProject getUserProject(User user,Long id) {

        UserProject userProject = userProjectMapper.getUserProject(user.getId(),id);

        return userProject;
    }

    @Override
    public Pair<Boolean,String> judgeUserProjectPermission(Long id, String permission) {

        String token = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userMapper.getUserByUsername(JWTUtil.getUsername(token));

        if(null == id || id <= 0){
            return new Pair<>(false,"没有项目信息！");
        }

        UserProject userProject = this.getUserProject(user,id);
        if(null == userProject){
            return new Pair<>(false,"没有该项目权限！");
        }

        String[] roles = userProject.getProjectRole().split(",");


        for(String role : roles){
            List<Permission> userPermissions = permissionMapper.getPermissionByRoleName(role);
            if(this.hasPermission(userPermissions,permission)){
                return new Pair<>(true,"权限认证通过！");
            }
        }

        return new Pair<>(false,"没有操作权限！");
    }

    /**
     * 判断角色是否有给定的权限
     * @param permissions
     * @return
     */
    private Boolean hasPermission(List<Permission> permissions,String permission){

        for(Permission item : permissions){
            if(item.getPermissionName().equals(permission)){
                return true;
            }
        }

        return false;
    }
}
