package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import com.apriltechnology.achieveit.mapper.UserProjectPermissionMapper;
import com.apriltechnology.achieveit.service.ProjectPermissionService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description 用户项目权限service实现层
 * @Author fjm
 * @Date 2020/4/15
 */
@Service
public class ProjectPermissionServiceImpl implements ProjectPermissionService {

    @Autowired
    private UserProjectPermissionMapper userProjectPermissionMapper;

    @Override
    public Pair<Boolean, String> addUserProjectPermission(UserProjectPermissionInfo userProjectPermissionInfo) {


        int count = userProjectPermissionMapper.insertUserProjectPermission(userProjectPermissionInfo);
        if(count <= 0){
            return new Pair<>(false,"插入失败！");
        }else{
            return new Pair<>(true,"插入成功！");
        }
    }

    @Override
    public Pair<Boolean, String> editUserpRrojectPermission(UserProjectPermissionInfo userProjectPermissionInfo) {

        int count = userProjectPermissionMapper.editUserProjectPermission(userProjectPermissionInfo);
        if(count <= 0){
            return new Pair<>(false,"更新失败！");
        }else{
            return new Pair<>(true,"更新成功！");
        }
    }

    @Override
    public UserProjectPermission searchUserProhectPermission(Long projectId, Long userId) {
        UserProjectPermission userProjectPermission = userProjectPermissionMapper.searchUserProjectPermission(projectId,userId);
        return userProjectPermission;
    }

    @Override
    public Pair<Boolean, String> deleteUserProjectPermission(Long projectId, Long userId) {
        int count = userProjectPermissionMapper.deleteUserProjectPermission(projectId,userId);
        if(count <= 0){
            return new Pair<>(false,"删除失败！");
        }else{
            return new Pair<>(true,"删除成功！");
        }
    }

}
