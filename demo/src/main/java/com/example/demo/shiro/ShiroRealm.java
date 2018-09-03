package com.example.demo.shiro;

import com.example.demo.system.dao.*;
import com.example.demo.system.entity.Role;
import com.example.demo.system.entity.RoleToResource;
import com.example.demo.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright © 2018青城科技. All rights reserved
 * @Auther: 郭慧乔
 * @Date: 2018/7/30 14:16
 * @Description:
 */
public class ShiroRealm extends AuthorizingRealm {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private UserToRoleDao userToRoleDao;
    @Autowired
    private RoleToResourceDao roleToResourceDao;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
        User user = userDao.findByUsername((String) principalCollection.getPrimaryPrincipal());


        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Role role = userToRoleDao.findByUser(user).getRole();
        //赋予角色
        info.addRole(role.getName());
        //赋予权限
        for(RoleToResource roleToResource : roleToResourceDao.findByRole(role)){
            info.addStringPermission(roleToResource.getResource().getName());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info(userName+token.getPassword());

        User user = userDao.findByUsername(token.getUsername());
        if (user != null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }


}
