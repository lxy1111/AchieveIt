package com.apriltechnology.achieveit.shiro;

import com.apriltechnology.achieveit.entity.User;
import com.apriltechnology.achieveit.service.UserService;
import com.apriltechnology.achieveit.util.JWTUtil;
import com.apriltechnology.achieveit.util.UserUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Description 自定义JWT realm
 * @Author fjm
 * @Date 2020/3/8
 */
@Component
public class JWTRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JWTToken;
    }

    /**
     * 用户名正确与否验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);

        User user = userService.getUserByUsername(username);
        if(null != user){
            if(!JWTUtil.verify(token,username,user.getPassword())){
                throw new IncorrectCredentialsException("验证失败");
            }
            UserUtil.set(user);
            return new SimpleAuthenticationInfo(token,token,getName());
        }else{
            throw new UnknownAccountException("用户不存在");
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        User user = userService.getUserByUsername(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if(null != user){
            String userRoles = user.getRoles();
            if(!StringUtils.isEmpty(userRoles)){
                //角色信息
                info.addRole(userRoles);

                //todo 权限信息，由人事系统决定

            }

        }

        return info;
    }
}
