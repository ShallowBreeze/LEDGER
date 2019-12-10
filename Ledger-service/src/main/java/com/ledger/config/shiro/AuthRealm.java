package com.ledger.config.shiro;

import com.ledger.common.constant.Setting;
import com.ledger.common.shiro.ShiroUser;
import com.ledger.common.utils.EncryptUtils;
import com.ledger.common.utils.SpringContextHolder;
import com.ledger.entity.User;
import com.ledger.service.sys.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;

/**
 * @author felixu
 * @date 2019.03.14
 */
@Slf4j
public class AuthRealm extends AuthorizingRealm {

    /**
     * 设定密码校验的Hash算法与迭代次数
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Setting.HASH_ALGORITHM);
        matcher.setHashIterations(Setting.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
        log.info("[AuthRealm#initCredentialsMatcher] ---> set credentials matcher");
    }

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginName=((UsernamePasswordToken) token).getUsername();
        UserService userService = SpringContextHolder.getBean(UserService.class);
        User user = userService.getByLoginName(loginName);

        if (user != null) {
            log.info("[AuthRealm#doGetAuthenticationInfo] --> {} login", user.getUserName());

            byte[] salt = EncryptUtils.decodeHex(user.getUserPwd());
            return new SimpleAuthenticationInfo(new ShiroUser(user.getUserId(),loginName, user.getUserName()),
                    user.getUserPwd(), ByteSource.Util.bytes(salt),
                    getName());
        } else {
            log.error("[AuthRealm#doGetAuthenticationInfo] --> login error");
            throw new UnknownAccountException();
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("[AuthRealm#doGetAuthorizationInfo] --> authorization");
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

/*        ISysRoleService sysRoleService = ApplicationContextRegister.getBean(SysRoleService.class);

        for (SysRole sysRole : sysRoleService.selectRoleByUserId(shiroUser.id)) {
            // 基于Role的权限信息
            info.addRole(sysRole.getCode());
            // 基于Permission的权限信息
            info.addStringPermissions(sysRole.getPermissionList());
        }*/
        return info;
    }


}