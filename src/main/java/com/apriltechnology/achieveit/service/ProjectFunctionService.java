package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectFunc;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 项目功能service接口类
 * @Author fjm
 * @Date 2020/3/20
 */
public interface ProjectFunctionService {


    /**
     * 添加项目功能信息
     * @param projectFunctionAdd
     * @return
     */
    Pair<Boolean,String> projectFunctionAdd(ProjectFunctionAdd projectFunctionAdd);

    /**
     * 编辑项目功能信息
     * @param projectFunctionEdit
     * @return
     */
    Pair<Boolean,String> projectFunctionEdit(ProjectFunctionEdit projectFunctionEdit);

    /**
     * 删除项目功能信息
     * @param id
     * @return
     */
    Pair<Boolean,String> projectFunctionDelete(Long id);

    /**
     * 查询项目功能列表
     * @param id
     * @return
     */
    List<ProjectFunc> projectFunctionSearch(Long id);

    /**
     * 判断负责人是否正确
     * @param personCharge
     * @param projectId
     * @return
     */
    Pair<Boolean,String> judgeChargePerson(String personCharge,Long projectId);

}
