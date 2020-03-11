package com.apriltechnology.achieveit.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 权限验证全局自定义异常
 * @Author fjm
 * @Date 2020/3/9
 */
@ControllerAdvice
public class ShiroException {

    /**
     * 处理shiro的认证异常
     * @param req
     * @param resp
     * @param e
     * @throws Exception
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public void defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws Exception{
        //重定向到异常处理方法
        resp.sendRedirect("/Error/NoPermission");
    }
}
