package com.apriltechnology.achieveit.service;


import com.apriltechnology.achieveit.entity.WorkHourInfo;

import java.util.List;

/**
 * @Description 工时service接口类
 * @Author br
 * @Date 2020/3/24
 */

public interface WorkHourInfoService {
    List<WorkHourInfo> getWorkHourInfo(Long projectId, String date);
}
