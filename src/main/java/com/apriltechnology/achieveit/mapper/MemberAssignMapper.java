package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.MemberAssign;
import org.springframework.stereotype.Repository;

/**
 * @Description MemberAssign类mapper接口
 * @Author fjm
 * @Date 2020/4/8
 */
@Repository
public interface MemberAssignMapper {

    /**
     * 插入成员信息关联类
     * @param memberAssign
     * @return
     */
    int insertMapperAssign(MemberAssign memberAssign);
}
