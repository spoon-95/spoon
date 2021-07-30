package com.wsp.spoon.config.shrio;


import com.wsp.spoon.domain.SysPermission;
import com.wsp.spoon.domain.SysRole;
import com.wsp.spoon.domain.SysUser;
import com.wsp.spoon.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的realm 数据域
 */

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 权限校验的时候会调用
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


        //从token中获取用户信息,token代表用户输入
//        String username = (String) principals.getPrimaryPrincipal();
        SysUser newUser = (SysUser) principals.getPrimaryPrincipal();

//        使用原因？
//        授权的时候每次都去查询数据库，对于频繁访问的接口，性能和响应速度比较慢，所以使用缓存

        //提高性能的方法1-使用redis缓存:
        //      将信息放到缓存,例如redis,但是要设置缓存失效时间,因为可能更新数据库了,但是缓存没有更新
        //提高性能的方法2-使用shiro-redis集成的缓存:
        //      shiro-redis的缓存配置在SecurityManager中
        SysUser user = sysUserService.findAllUserInfoByUsername(newUser.getUsername());

        List<String> stringRoleList = new ArrayList<>();
        List<String> stringPermissionList = new ArrayList<>();

        List<SysRole> roleList = user.getRoleList();

        for (SysRole role : roleList) {
            stringRoleList.add(role.getName());

            List<SysPermission> permissionList = role.getPermissionList();

            for (SysPermission p : permissionList) {
                if (p != null) {
                    stringPermissionList.add(p.getName());
                }
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //将用户对应的角色和权限信息 放到权限器中
        simpleAuthorizationInfo.addStringPermissions(stringPermissionList);
        simpleAuthorizationInfo.addRoles(stringRoleList);

        return simpleAuthorizationInfo;
    }

    /**
     * 用户登录的时候会调用
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //从token中获取用户信息,token代表用户输入
        String username = (String) token.getPrincipal();

        SysUser user = sysUserService.findAllUserInfoByUsername(username);

        if (user == null) {
            return null;
        }

        //取密码
        String password = user.getPassword();

        if (password == null || "".equals(password)) {
            return null;
        }

        return new SimpleAuthenticationInfo(user, password, this.getClass().getName());
    }
}
