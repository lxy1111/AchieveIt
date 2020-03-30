package com.apriltechnology.achieveit.util;

import com.apriltechnology.achieveit.entity.User;

/**
 * @Description 登录用户信息工具类
 * @Author fjm
 * @Date 2020/3/30
 */
public class UserUtil {

   private UserUtil(){

   }

   private static final ThreadLocal<User> loginUser = new ThreadLocal<>();

   public static void set(User user){
       loginUser.set(user);
   }

   public static User get(){
       return loginUser.get();
   }

   public static void remove(){
       loginUser.remove();
   }
}
