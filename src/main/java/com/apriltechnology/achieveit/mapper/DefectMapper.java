package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.DefectAdd;
import com.apriltechnology.achieveit.entity.Defect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DefectMapper {
    //通过项目id查询缺陷
    List<Defect> getDefectInfo(@Param("projectId")Long projectId);

    //增添缺陷
    int defectAdd(DefectAdd defectAdd);

    //删除缺陷
    int defectDelete(@Param("defectId")Long defectId);
}
