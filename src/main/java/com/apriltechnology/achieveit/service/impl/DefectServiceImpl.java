package com.apriltechnology.achieveit.service.impl;

import com.apriltechnology.achieveit.dto.DefectAdd;
import com.apriltechnology.achieveit.entity.Defect;
import com.apriltechnology.achieveit.mapper.DefectMapper;
import com.apriltechnology.achieveit.service.DefectService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefectServiceImpl implements DefectService {

    @Autowired
    private DefectMapper defectMapper;

    @Override
    public List<Defect> getDefectInfo(Long projectId) {
        List<Defect> defects = defectMapper.getDefectInfo(projectId);
        return defects;
    }

    @Override
    public Pair<Boolean, String> defectAdd(DefectAdd defectAdd) {
        int result = defectMapper.defectAdd(defectAdd);
        if(result <= 0){
            return new Pair<>(false,"缺陷添加失败！");
        }
        return new Pair<>(true,"缺陷添加成功！");
    }

    @Override
    public Pair<Boolean, String> defectDelete(Long defectId) {
        int result = defectMapper.defectDelete(defectId);
        if(result <= 0){
            return new Pair<>(false,"缺陷删除失败！");
        }
        return new Pair<>(true,"缺陷删除成功！");
    }
}
