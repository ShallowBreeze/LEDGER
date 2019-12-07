package ${package.Controller};


import com.ledger.annotation.SLog;
import com.ledger.common.core.entity.DataTable;
import org.springframework.validation.annotation.Validated;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import org.springframework.beans.factory.annotation.Autowired;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

import javax.servlet.ServletRequest;

/**
 * <p>
 * ${table.comment!} Controller
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/sys/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${table.serviceName} ${table.entityPath}Service;

    /**
    * @Description: 分页查询
    * @Param: [dt, request]
    * @return: com.ledger.common.core.entity.DataTable<${package.Entity}.${entity}>
    * @Author: pengzhen@cmhit.com
    * @Date: ${date}
    */

    @SLog("获取${entity}")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<${entity}> list(@RequestBody DataTable dt, ServletRequest request) {
    return ${table.entityPath}Service.pageSearch(dt);
    }

    /**
    * @Description:  新增${entity}
    * @Param: [${table.entityPath}]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: ${date}
    */
    @SLog("新增${entity}")
    @PostMapping(value = "/insert")
    @ResponseBody
    public ReturnEntity create(@Validated @RequestBody ${entity} ${table.entityPath}) {
    ${table.entityPath}Service.save(${table.entityPath});
    return AjaxResult.success();
    }

    /**
    * @Description:  更新${entity}
    * @Param: [${table.entityPath}]
    * @return: com.ledger.common.core.entity.response.ReturnEntity
    * @Author: pengzhen@cmhit.com
    * @Date: ${date}
    */
    @SLog("更新${entity}")
    @PostMapping(value = "/update")
    @ResponseBody
    public ReturnEntity update(@Validated @RequestBody ${entity} ${table.entityPath}) {
    ${table.entityPath}Service.updateById(${table.entityPath});
    return AjaxResult.success();
    }
}
</#if>
