package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectFunc;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 项目功能mapper接口
 * @Author fjm
 * @Date 2020/3/20
 */
@Repository
public interface ProjectFunctionMapper {

    /**
     * 添加项目功能信息
     * @param projectFunctionAdd
     * @return
     */
    int projectFunctionAdd(ProjectFunctionAdd projectFunctionAdd);

    /**
     * 编辑项目功能信息
     * @param projectFunctionEdit
     * @return
     */
    int projectFunctionEdit(ProjectFunctionEdit projectFunctionEdit);

    /**
     * 删除项目功能信息
     * @param id
     * @return
     */
    int projectFunctionDelete(Long id);

    /**
     * 根据功能id查询功能列表
     * @param id
     * @return
     */
    List<ProjectFunc> projectFunctionSearch(@Param("id") Long id);
}
