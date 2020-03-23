package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProject;
import javafx.util.Pair;

/**
 * @Description 用户项目信息service接口类
 * @Author fjm
 * @Date 2020/3/9
 */
public interface UserProjectService {

    /**
     * 获取用户项目信息
     * @param user
     * @return
     */
    UserProject getUserProject(User user,Long id) ;

    /**
     * 判断用户项目的权限
     * @param id
     * @param user
     * @param permission
     * @return
     */
    Pair<Boolean,String> judgeUserProjectPermission(Long id, String permission);
}
