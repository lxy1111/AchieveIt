package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.WorkHourAdd;
import com.apriltechnology.achieveit.dto.WorkHourEdit;
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
     * 项目经理通过date和projectid查询工时信息
     * @return
     */
    List<WorkHourInfo> managerGetWorkHourInfoList(@Param("projectId") Long projectId, @Param("date") String date);

    /**
     * 项目成员通过userid和projectid查询工时信息
     * @return
     */
    List<WorkHourInfo> userGetWorkHourInfoList (@Param("projectId") Long projectId, @Param("userId") Long userId);

    List<WorkHourInfo> getInfoList(@Param("projectId")Long projectId);

    //项目经理审批通过
    int acceptWorkHourInfo (@Param("workHourId") Long workHourId);

    //项目经理审批拒绝
    int rejectWorkHourInfo (@Param("workHourId") Long workHourId);

    //项目成员增添工时信息
    int workHourInfoAdd(WorkHourAdd workHourAdd);

    //项目成员修改工时信息
    int workHourInfoEdit(WorkHourEdit workHourEdit);

    //重置工时状态
    int resetWorkHourInfo(@Param("workHourId") Long workHourId);
}
