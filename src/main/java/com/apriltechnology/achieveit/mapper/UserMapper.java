package com.apriltechnology.achieveit.mapper;

import com.apriltechnology.achieveit.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 模糊查询用户信息
     * @param username
     * @return
     */
    List<User> searchUserByUsername(@Param("username")String username);

    /**
     * 根据名称模糊查询项目上级
     * @param username
     * @return
     */
    List<User> searchProjectSuperiorsByUsername(@Param("username")String username);
}
