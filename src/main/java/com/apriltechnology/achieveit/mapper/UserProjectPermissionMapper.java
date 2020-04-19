package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.dto.UserProjectPermissionInfo;
import com.apriltechnology.achieveit.entity.UserProjectPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description UserProjectPermission类mapper接口
 * @Author fjm
 * @Date 2020/4/15
 */
@Repository
public interface UserProjectPermissionMapper {

    /**
     * 插入用户项目权限信息
     * @param userProjectPermissionInfo
     * @return
     */
    int insertUserProjectPermission(UserProjectPermissionInfo userProjectPermissionInfo);

    /**
     * 编辑用户项目权限信息
     * @param userProjectPermissionInfo
     * @return
     */
    int editUserProjectPermission(UserProjectPermissionInfo userProjectPermissionInfo);

    /**'
     * 查询用户项目权限信息
     * @param projectId
     * @param userId
     * @return
     */
    UserProjectPermission searchUserProjectPermission(@Param("projectId")Long projectId,@Param("userId")Long userId);


}
