package com.apriltechnology.achieveit.service;


import com.apriltechnology.achieveit.dto.WorkHourAdd;
import com.apriltechnology.achieveit.dto.WorkHourEdit;
import com.apriltechnology.achieveit.entity.WorkHourInfo;
import javafx.util.Pair;

import java.util.List;

/**
 * @Description 工时service接口类
 * @Author br
 * @Date 2020/3/24
 */

public interface WorkHourInfoService {
    List<WorkHourInfo> managerGetWorkHourInfo(Long projectId, String date);

    List<WorkHourInfo> userGetWorkHourInfo(Long projectId,Long userId);

    Pair<Boolean,String> acceptWorkHourInfo(Long workHourId);

    Pair<Boolean,String> rejectWorkHourInfo(Long workHourId);

    Pair<Boolean,String> workHourInfoAdd(WorkHourAdd workHourAdd);

    Pair<Boolean,String> workHourInfoEdit(WorkHourEdit workHourEdit);
}
