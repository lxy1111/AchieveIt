package com.apriltechnology.achieveit.filter;

import com.apriltechnology.achieveit.shiro.JWTToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Descriptiom jwt拦截器
 * @Author fjm
 * @Date 2020/3/8
 */
@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {

    // 登录标识
    private static String LOGIN_SIGN = "Authorization";

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response,Object mappedValue){
        try {
            if(isLoginAttempt(request,response)){
                executeLogin(request,response);
            }
        } catch (Exception e) {
            throw new AuthorizationException("权限不足！",e);
        }
        return true;
    }


    /**
     * 判断用户是否想要登入
     * 检测header里面是否包含Authorization字段即可
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(LOGIN_SIGN);
        log.info("判断用户是否想要登录：{}",authorization);
        return authorization != null;
    }


    /**
     * 执行登录操作
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");log.info("判断用户是否想要登录x：{}",authorization);
        JWTToken token = new JWTToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }
}
