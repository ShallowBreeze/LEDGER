package com.ledger.common.shiro;


import org.apache.shiro.SecurityUtils;

/**
 * Created by chen on 2017/7/28.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe: shiro 用户封装的工具类
 */
public class SysUser {
    /**
     * 取出Shiro中的当前用户LoginName.
     */
    public static String name() {
        return ShiroUser().getName();
    }

    public static Long id() {
        return ShiroUser().getId();
    }

    public static String loginName() {
        return ShiroUser().getUsername();
    }

    public static ShiroUser ShiroUser() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
