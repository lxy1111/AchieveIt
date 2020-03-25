package com.apriltechnology.achieveit.service.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionAdd;
import com.apriltechnology.achieveit.dto.ProjectSubFunctionEdit;
import com.apriltechnology.achieveit.entity.ProjectSubFunc;
import com.apriltechnology.achieveit.mapper.ProjectSubFunctionMapper;
import com.apriltechnology.achieveit.model.ProjectSubFunctionModel;
import com.apriltechnology.achieveit.service.ProjectSubFunctionService;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 项目子功能service实现类
 * @Author fjm
 * @Date 2020/3/20
 */
@Service
@Slf4j
public class ProjectSubFunctionServiceImpl implements ProjectSubFunctionService {

    @Autowired
    private ProjectSubFunctionMapper projectSubFunctionMapper;


    @Override
    public Pair<Boolean, String> projectSubFunctionAdd(ProjectSubFunctionAdd projectSubFunctionAdd) {

        int result = projectSubFunctionMapper.projectSubFunctionAdd(projectSubFunctionAdd);
        if(result <= 0){
            return new Pair<>(false,"新增失败！");
        }

        return new Pair<>(true,"新增成功！");
    }

    @Override
    public Pair<Boolean, String> projectSubFunctionEdit(ProjectSubFunctionEdit projectSubFunctionEdit) {

        int result = projectSubFunctionMapper.projectSubFunctionEdit(projectSubFunctionEdit);
        if(result <= 0){
            return new Pair<>(false,"更新失败！");
        }

        return new Pair<>(true,"更新成功！");
    }

    @Override
    public Pair<Boolean, String> projectSubFunctionDelete(Long id) {

        int result = projectSubFunctionMapper.projectSubFunctionDelete(id);
        if(result <= 0){
            return new Pair<>(false,"删除失败！");
        }

        return new Pair<>(true,"删除成功！");
    }

    @Override
    public List<ProjectSubFunc> projectSubFunctionSearch(Long id) {

        List<ProjectSubFunc> projectSubFuncs = projectSubFunctionMapper.projectSunFunctionSearch(id);
        return projectSubFuncs;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public Pair<Boolean, String> projectSubFunctionExcelImport(MultipartFile file,Long id) {


        try {


            Sheet sheet = new Sheet(1,1, ProjectSubFunctionModel.class);
            List<Object> readList = EasyExcelFactory.read(new BufferedInputStream(file.getInputStream()),sheet);

            projectSubFunctionMapper.deleteAllSubFunctionById(id);

            if(null == readList || readList.size() <= 0){
                return new Pair<>(true,"导入成功，无数据！");
            }

            List<ProjectSubFunctionModel> modelLists = new ArrayList<>();
            for(Object obj : readList){
                modelLists.add((ProjectSubFunctionModel) obj);
            }

            projectSubFunctionMapper.projectSubFunctionExcelImport(modelLists,id);

            return new Pair<>(true,"导入成功！");
        } catch (IOException e) {
            log.error("projectSubFunctionExcelImport", ExceptionUtils.getStackTrace(e));
            return new Pair<>(false,"io 异常！");
        }

    }



}
