package com.ledger.controller.sys;


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.entity.Area;
import org.springframework.web.bind.annotation.*;
import com.ledger.service.sys.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

/**
 * <p>
 * 系统区域表t_sys_area   全国的区域信息 Controller
 * </p>
 *
 * @author pz
 * @since 2019-12-07
 */
@RestController
@RequestMapping("/sys/area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<com.ledger.entity.Area>
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */

    @SLog("获取Area")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<Area> list(@RequestBody DataTable dt, ServletRequest request) {
    return areaService.pageSearch(dt);
    }

    /**
    * @Description:  新增Area
    * @Param: [area]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("新增Area")
    @GetMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody Area area) {
    areaService.save(area);
    return AjaxResult.success();
    }

    /**
    * @Description:  更新Area
    * @Param: [area]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: 2019-12-07
    */
    @SLog("更新Area")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody Area area) {
    areaService.updateById(area);
    return AjaxResult.success();
    }
}
