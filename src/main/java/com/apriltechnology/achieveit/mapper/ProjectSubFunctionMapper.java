package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectSubFunc;
import com.apriltechnology.achieveit.model.ProjectSubFunctionModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 项目子功能mapper接口
 * @Author fjm
 * @Date 2020/3/20
 */
@Repository
public interface ProjectSubFunctionMapper {

    /**
     * 添加项目子功能信息
     * @param projectSubFunctionAdd
     * @return
     */
    int projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd);

    /**
     * 编辑项目子功能信息
     * @param projectSubFunctionEdit
     * @return
     */
    int projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit);

    /**
     * 删除项目子功能信息
     * @param id
     * @return
     */
    int projectSubFunctionDelete(Long id);

    /**
     * 根据功能id查询子功能列表
     * @param id
     * @return
     */
    List<ProjectSubFunc> projectSunFunctionSearch(@Param("id") Long id);

    /**
     * excel导入
     * @param modelLists
     * @param id
     * @return
     */
    int projectSubFunctionExcelImport(@Param("list") List<ProjectSubFunctionModel> modelLists,@Param("id") Long id);

    /**
     * 删除功能所有子功能
     * @param id
     * @return
     */
    int deleteAllSubFunctionById(@Param("id") Long id);

    /**
     * excel导出
     * @param id
     * @return
     */
    List<ProjectSubFunctionModel> projectSubFunctionExcelExport(@Param("id")Long id);
}
