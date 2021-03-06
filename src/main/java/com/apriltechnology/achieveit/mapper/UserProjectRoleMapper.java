package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.UserProjectRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description UserProject类mapper接口
 * @Author fjm
 * @Date 2020/3/23
 */
@Repository
public interface UserProjectRoleMapper {

    /**
     * 获取用户关联项目信息
     * @param userId
     * @param projectId
     * @return
     */
    List<Long> getUserProjectRole(@Param("userId") Long userId, @Param("projectId") Long projectId);

    /**
     * 批量插入关联信息
     * @param userProjectRoles
     * @return
     */
    int batchInsertUserProjectRole(@Param("list")List<UserProjectRole> userProjectRoles);
}
