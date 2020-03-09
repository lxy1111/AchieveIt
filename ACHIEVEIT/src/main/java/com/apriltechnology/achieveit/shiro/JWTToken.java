package com.apriltechnology.achieveit.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Description jwt token 实体类
 * @Author fjm
 * @Date 2020/3/8
 */
public class JWTToken implements AuthenticationToken {

    private static final long serialVersionUID = 1L;

    // 秘钥
    private String token;

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
