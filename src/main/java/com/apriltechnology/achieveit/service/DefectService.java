package com.apriltechnology.achieveit.service;

import com.apriltechnology.achieveit.dto.DefectAdd;
import com.apriltechnology.achieveit.entity.Defect;
import javafx.util.Pair;

import java.util.List;

public interface DefectService {
    List<Defect> getDefectInfo(Long projectId);

    Pair<Boolean,String> defectAdd(DefectAdd defectAdd);

    Pair<Boolean,String> defectDelete(Long defectId);
}
