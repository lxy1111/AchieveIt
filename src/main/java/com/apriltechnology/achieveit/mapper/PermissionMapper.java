package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description permission类mapper接口
 * @Author fjm
 * @Date 2020/3/10
 */
@Repository
public interface PermissionMapper {

    /**
     * 通过角色名获取权限信息
     * @param roleId
     * @return
     */
    List<Permission> getPermissionByRoleId(@Param("roleId") Long roleId);
}
