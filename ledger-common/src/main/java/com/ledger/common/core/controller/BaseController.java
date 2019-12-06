package com.ledger.common.core.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.core.entity.response.PageResult;
import com.ledger.common.core.entity.response.ReturnEntity;
import com.ledger.common.enums.HttpCodeEnum;
import com.ledger.common.utils.DateUtils;
import com.ledger.common.utils.ServletUtils;
import com.ledger.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * @description: base Controller
 * @author: pengzhen@cmhit.com
 * @create: 2019-12-03 10:29
 **/
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(BaseController.class);


    /**
     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }


    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return ServletUtils.getHttpServletRequest();
    }

    /**
     * 获取response
     */
    public HttpServletResponse getResponse() {
        return ServletUtils.getResponse();
    }

    /**
     * 获取session
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }


    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected ReturnEntity toAjax(int rows) {
        return rows > 0 ? success() : fail();
    }

    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected ReturnEntity toAjax(boolean result) {
        return result ? success() : fail();
    }

    /**
     * 返回成功
     */
    protected  ReturnEntity success() {
        return AjaxResult.success();
    }

    /**
     * 返回成功消息
     */
    protected  ReturnEntity success(Object t) {
        return AjaxResult.success(t);
    }

    /**
     * 返回成功消息
     */
    protected ReturnEntity success(Object t, String message) {
        return AjaxResult.success(message, t);
    }

    /**
     * 返回成功消息
     */
    protected ReturnEntity success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    protected ReturnEntity fail() {
        return AjaxResult.fail();
    }

    /**
     * 返回失败消息
     */
    protected ReturnEntity fail(String message) {
        return AjaxResult.fail(message);
    }

    /**
     * 自定义返回
     */
    protected ReturnEntity custom(HttpCodeEnum e) {
        return AjaxResult.custom(e);
    }

    /**
     * 返回失败消息
     */
    protected ReturnEntity nologin() {
        return AjaxResult.nologin();
    }

    /**
     * 页面跳转
     */
    protected String redirect(String url) {
        return StringUtils.format("redirect:{}", url);
    }


    protected <T> PageResult<T> page(List<T> list) {
        return PageResult.create(list);
    }

    protected <T> PageResult<T> page(Page page, List<T> list) {
        return PageResult.create(page, list);
    }

    protected <T> PageResult<T> page(PageInfo<T> page) {
        return PageResult.create(page);
    }

    protected <T> PageResult<T> page(Page page) {
        return PageResult.create(page);
    }

    protected <T> PageResult<T> pageFail(String msg) {
        return PageResult.createFail(msg);
    }

}
