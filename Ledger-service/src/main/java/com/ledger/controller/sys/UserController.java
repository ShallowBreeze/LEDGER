package com.ledger.controller.sys;


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.entity.User;
import org.springframework.web.bind.annotation.*;
import com.ledger.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * <p>
 * 用户表 Controller
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<com.ledger.entity.User>
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */

    @SLog("获取User")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<User> list(@RequestBody DataTable dt, ServletRequest request) {
    return userService.pageSearch(dt);
    }

    /**
    * @Description:  新增User
    * @Param: [user]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("新增User")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody User user) {
    userService.save(user);
    return AjaxResult.success();
    }

    /**
    * @Description:  更新User
    * @Param: [user]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("更新User")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody User user) {
    userService.updateById(user);
    return AjaxResult.success();
    }
}
