package com.ledger.controller.sys;


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.entity.DictDetail;
import org.springframework.web.bind.annotation.*;
import com.ledger.service.sys.DictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * <p>
 * 系统字典明细表t_sys_dict_detail Controller
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@RestController
@RequestMapping("/sys/dictDetail")
public class DictDetailController {
    @Autowired
    private DictDetailService dictDetailService;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<com.ledger.entity.DictDetail>
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */

    @SLog("获取DictDetail")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<DictDetail> list(@RequestBody DataTable dt, ServletRequest request) {
    return dictDetailService.pageSearch(dt);
    }

    /**
    * @Description:  新增DictDetail
    * @Param: [dictDetail]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("新增DictDetail")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody DictDetail dictDetail) {
    dictDetailService.save(dictDetail);
    return AjaxResult.success();
    }

    /**
    * @Description:  更新DictDetail
    * @Param: [dictDetail]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("更新DictDetail")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody DictDetail dictDetail) {
    dictDetailService.updateById(dictDetail);
    return AjaxResult.success();
    }
}
