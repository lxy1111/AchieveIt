package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.ProjectFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectFunc;
import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import com.apriltechnology.achieveit.mapper.ProjectFunctionMapper;
import com.apriltechnology.achieveit.service.ProjectFunctionService;
import com.apriltechnology.achieveit.service.ProjectPermissionService;
import com.apriltechnology.achieveit.service.UserService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 项目功能service实现类
 * @Author fjm
 * @Date 2020/3/20
 */
@Service
public class ProjectFunctionServiceImpl implements ProjectFunctionService {


    @Autowired
    private ProjectFunctionMapper projectFunctionMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectPermissionService projectPermissionService;

    @Override
    public Pair<Boolean, String> projectFunctionAdd(ProjectFunctionAdd projectFunctionAdd) {

        int result = projectFunctionMapper.projectFunctionAdd(projectFunctionAdd);
        if(result <= 0){
            return new Pair<>(false,"新增失败！");
        }

        return new Pair<>(true,"新增成功！");
    }

    @Override
    public Pair<Boolean, String> projectFunctionEdit(ProjectFunctionEdit projectFunctionEdit) {

        int result = projectFunctionMapper.projectFunctionEdit(projectFunctionEdit);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }

        return new Pair<>(true,"更新成功！");
    }

    @Override
    public Pair<Boolean, String> projectFunctionDelete(Long id) {

        int result = projectFunctionMapper.projectFunctionDelete(id);
        if(result <= 0){
            return new Pair<>(false,"删除失败！");
        }

        return new Pair<>(true,"删除成功！");
    }

    @Override
    public List<ProjectFunc> projectFunctionSearch(Long id) {

        List<ProjectFunc> projectFuncs = projectFunctionMapper.projectFunctionSearch(id);
        return projectFuncs;
    }

    @Override
    public Pair<Boolean, String> judgeChargePerson(String personCharge, Long projectId) {
        User user = userService.getUserByUsername(personCharge);
        if(null == user){
            return new Pair<>(false,"负责人不存在！");
        }

        UserProjectPermission userProjectPermission = projectPermissionService.searchUserProjectPermission(projectId,user.getId());
        if(null == userProjectPermission) {
            return new Pair<>(false, "负责人'" + personCharge + "'不是此项目成员！");
        }

        return new Pair<>(true,"负责人校验正确！");
    }

}
