package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectSubFunc;
import com.apriltechnology.achieveit.model.ProjectSubFunctionModel;
import javafx.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * @Description 项目子功能service接口类
 * @Author fjm
 * @Date 2020/3/20
 */
public interface ProjectSubFunctionService {

    /**
     * 添加项目子功能信息
     * @param projectSubFunctionAdd
     * @return
     */
    Pair<Boolean,String> projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd);

    /**
     * 编辑项目子功能信息
     * @param projectSubFunctionEdit
     * @return
     */
    Pair<Boolean,String> projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit);

    /**
     * 删除项目子功能信息
     * @param id
     * @return
     */
    Pair<Boolean,String> projectSubFunctionDelete(Long id);

    /**
     * 查询项目子功能列表
     * @param id
     * @return
     */
    List<ProjectSubFunc> projectSubFunctionSearch(Long id);


    /**
     * 根据excel文件插入子功能信息
     * @param file
     * @return
     */
    Pair<Boolean,String> projectSubFunctionExcelImport(MultipartFile file,Long id);

    /**
     * excel导出项目子功能信息
     * @param id
     * @return
     */
    String projectSubFunctionExcelExport(OutputStream out , Long id);

}
