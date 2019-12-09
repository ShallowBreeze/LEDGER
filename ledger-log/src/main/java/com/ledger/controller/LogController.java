package com.ledger.controller;


import com.ledger.common.core.entity.DataTable;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.common.utils.StringUtils;
import com.ledger.entity.Log;
import com.ledger.service.LogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 系统日志记录表 前端控制器
 * </p>
 *
 * @author pz
 * @since 2019-12-05
 */
@RestController
@RequestMapping("sys/log")
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value = "获取日志列表数据", notes = "获取日志列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable list(@RequestBody DataTable dt, ServletRequest request) {
        return logService.pageSearch(dt);
    }

    @GetMapping(value = "/error")
    @ApiOperation("错误日志查询")
    public ReturnEntity getErrorLogs(@RequestBody DataTable dt, ServletRequest request){
       if(StringUtils.isNotEmpty(dt.getSearchParams())){
           dt.getSearchParams().put("search_eq_type","ERROR");
       }else {
           Map<String, Object> map =new HashMap<>();
           map.put("search_eq_type","ERROR");
           dt.setSearchParams(map);
       }
        return logService.pageSearch(dt);
    }
}
