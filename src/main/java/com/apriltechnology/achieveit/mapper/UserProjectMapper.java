package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.UserProject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description UserProject类mapper接口
 * @Author fjm
 * @Date 2020/3/23
 */
@Repository
public interface UserProjectMapper {

    /**
     * 获取用户关联项目信息
     * @param userId
     * @param projectId
     * @return
     */
    UserProject getUserProject(@Param("userId") Long userId, @Param("projectId") Long projectId);

}
