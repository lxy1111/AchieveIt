package com.apriltechnology.achieveit.mapper;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description 分配角色后专门调整memberassign表
 * @Author br
 * @Date 2020/4/5
 */


@Repository
public interface ProjectMemberMapper {
    int adjustQAMemberAssign(@Param("projectId")Long projectId);

    int adjustEPGMemberAssign(@Param("projectId")Long projectId);

    int adjustDEVMemberAssign(@Param("projectId")Long projectId);
}
