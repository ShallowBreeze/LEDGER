package com.ledger.controller;

import com.ledger.annotation.SLog;
import com.ledger.common.annotation.AnonymousAccess;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.service.sys.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 登录
 * @author: pengzhen@cmhit.com
 * @create: 2019-12-10 14:17
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @SLog("用户登录")
    @AnonymousAccess
    @PostMapping(value = "login")
    public ReturnEntity login(HttpServletRequest request) {
        // 用户信息
        Subject s = SecurityUtils.getSubject();
        boolean flag=s.isRemembered() || s.isAuthenticated();
        if(!flag){
          return AjaxResult.fail();
        }
        return AjaxResult.success();
    }

    /**
     *  空地址请求
     * @param model
     * @param request
     * @return
     */
    @GetMapping(value = "")
    public ReturnEntity index(Model model, HttpServletRequest request) {
        // 用户信息
        Subject s = SecurityUtils.getSubject();
        boolean flag=s.isRemembered() || s.isAuthenticated();
        if(!flag){
            return AjaxResult.fail();
        }
        return AjaxResult.success();
    }
}
