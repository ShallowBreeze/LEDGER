package com.ledger.controller.sys;


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.entity.Dict;
import org.springframework.web.bind.annotation.*;
import com.ledger.service.sys.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * <p>
 * 系统字典表t_sys_dict Controller
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@RestController
@RequestMapping("/sys/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<com.ledger.entity.Dict>
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */

    @SLog("获取Dict")
    @GetMapping(value = "/list")
    @ResponseBody
    public DataTable<Dict> list(@RequestBody DataTable dt, ServletRequest request) {
    return dictService.pageSearch(dt);
    }

    /**
    * @Description:  新增Dict
    * @Param: [dict]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("新增Dict")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody Dict dict) {
    dictService.save(dict);
    return AjaxResult.success();
    }

    /**
    * @Description:  更新Dict
    * @Param: [dict]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("更新Dict")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody Dict dict) {
    dictService.updateById(dict);
    return AjaxResult.success();
    }
}
