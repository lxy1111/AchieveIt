package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.mapper.ProjectRoleMapper;
import com.apriltechnology.achieveit.mapper.UserProjectRoleMapper;
import com.apriltechnology.achieveit.service.UserProjectRoleService;
import com.apriltechnology.achieveit.util.UserUtil;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 用户项目信息service实现类
 * @Author fjm
 * @Date 2020/3/9
 */
@Service
public class UserProjectRoleServiceImpl implements UserProjectRoleService {

    @Autowired
    private UserProjectRoleMapper userProjectRoleMapper;

    @Autowired
    private ProjectRoleMapper projectRoleMapper;

    @Override
    public List<Long> getUserProjectRole(User user, Long id) {

        List<Long> userProjectRoles = userProjectRoleMapper.getUserProjectRole(user.getId(),id);

        return userProjectRoles;
    }

    @Override
    public Pair<Boolean,String> judgeUserProjectPermission(Long id, String permission) {

        User user = UserUtil.get();

        if(null == id || id <= 0){
            return new Pair<>(false,"没有项目信息！");
        }

        List<Long> roleIds = this.getUserProjectRole(user,id);
        if(null == roleIds || roleIds.size() <= 0){
            return new Pair<>(false,"没有该项目权限！");
        }


        List<String> roleNames = projectRoleMapper.getRoleNameByIds(roleIds);

        for(String roleName : roleNames){
            if(roleName.equals(permission)){
                return new Pair<>(true,"权限认证通过！");
            }
        }

        return new Pair<>(false,"没有操作权限！");
    }

}
