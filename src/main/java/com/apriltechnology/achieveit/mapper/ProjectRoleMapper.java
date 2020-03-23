package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.ProjectRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description ProjectRole类mapper接口
 * @Author fjm
 * @Date 2020/3/23
 */
@Repository
public interface ProjectRoleMapper {

    /**
     * 查询所有项目角色信息
     * @return
     */
    List<ProjectRole> getAllProjectRoles();

}
