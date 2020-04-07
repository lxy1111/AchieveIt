package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProjectRole;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 用户项目信息service接口类
 * @Author fjm
 * @Date 2020/3/9
 */
public interface UserProjectRoleService {

    /**
     * 获取用户项目信息
     * @param user
     * @return
     */
    List<Long> getUserProjectRole(User user, Long id) ;

    /**
     * 判断用户项目的权限
     * @param id
     * @param permission
     * @return
     */
    Pair<Boolean,String> judgeUserProjectPermission(Long id, String permission);
}
