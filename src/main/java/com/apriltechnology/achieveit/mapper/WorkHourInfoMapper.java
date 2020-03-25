package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.WorkHourInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description WorkHourInfo类接口
 * @Author br
 * @Date 2020/3/24
 */

@Repository
public interface WorkHourInfoMapper {
    /**
     * 通过date查询工时信息
     * @return
     */
    List<WorkHourInfo> getWorkHourInfoList (@Param("date") String date);
}
