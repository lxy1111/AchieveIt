package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description user类mapper接口
 * @Author fjm
 * @Date 2020/3/9
 */
@Repository
public interface UserMapper {

    /**
     * 通过username查询用户信息
     * @param username
     * @return
     */
    User getUserByUsername(@Param("username") String username);

}
