package com.ledger.controller.sys;


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.entity.Config;
import org.springframework.web.bind.annotation.*;
import com.ledger.service.sys.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * <p>
 * 系统配置参数t_sys_config Controller
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@RestController
@RequestMapping("/sys/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<com.ledger.entity.Config>
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */

    @SLog("获取Config")
    @GetMapping(value = "/list")
    @ResponseBody
    public DataTable<Config> list(@RequestBody DataTable dt, ServletRequest request) {
    return configService.pageSearch(dt);
    }

    /**
    * @Description:  新增Config
    * @Param: [config]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("新增Config")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody Config config) {
    configService.save(config);
    return AjaxResult.success();
    }

    /**
    * @Description:  更新Config
    * @Param: [config]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("更新Config")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody Config config) {
    configService.updateById(config);
    return AjaxResult.success();
    }
}
