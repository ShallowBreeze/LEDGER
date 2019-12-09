package com.ledger.common.core.entity.response;


import com.alibaba.fastjson.JSON;
import com.ledger.common.core.entity.DataTable;
import com.ledger.common.enums.HttpCodeEnum;
import lombok.Builder;
import org.apache.poi.ss.formula.functions.T;

/**
 * 操作消息提醒
 * 
 */
public class AjaxResult {

	/**
	 * 请求成功
	 * @return
	 */
	public static ReturnEntity success() {
		return new ReturnEntity(HttpCodeEnum.OK.getCode(),HttpCodeEnum.OK.getMessage(),null );
	}

	/**
	 * 成功请求
	 *
	 * @param data
	 * @return
	 */
	public static ReturnEntity success(Object data) {
		return new ReturnEntity(HttpCodeEnum.OK.getCode(), HttpCodeEnum.OK.getMessage(),data);
	}
	/**
	 * 成功请求
	 *
	 * @param message
	 * @return
	 */
	public static ReturnEntity success(String message) {
		return new ReturnEntity(HttpCodeEnum.OK.getCode(),message,null);
	}


	/**
	 * 成功请求
	 *
	 * @param message
	 * @return
	 */
	public static ReturnEntity success(String message, Object data) {
		return new ReturnEntity(HttpCodeEnum.OK.getCode(), message,data);
	}


	/**
	 * 操作失败
	 * @return
	 */
	public static ReturnEntity fail() {
		return new ReturnEntity(HttpCodeEnum.FAIL.getCode(), HttpCodeEnum.FAIL.getMessage());
	}

	/**
	 * 操作失败
	 * @return
	 */
	public static ReturnEntity fail(String message) {
		return new ReturnEntity(HttpCodeEnum.FAIL.getCode(),message);
	}

	/**
	 * 服务器错误
	 * @return
	 */
	public static ReturnEntity error() {
		return new ReturnEntity(HttpCodeEnum.INTERNAL_SERVER_ERROR.getCode(),HttpCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
	}


	/**
	 * 服务器错误
	 * @param data
	 * @return
	 */
	public static ReturnEntity error(Object data) {
		return new ReturnEntity(HttpCodeEnum.INTERNAL_SERVER_ERROR.getCode(),HttpCodeEnum.INTERNAL_SERVER_ERROR.getMessage(), data);
	}
	/**
	 * 参数错误
	 * @return
	 */
	public static ReturnEntity paramError() {
		return new ReturnEntity(HttpCodeEnum.INVALID_REQUEST.getCode(), HttpCodeEnum.INVALID_REQUEST.getMessage());
	}

	/**
	 * 参数错误
	 * @param data
	 * @return
	 */
	public static ReturnEntity paramError(Object data) {
		return new ReturnEntity(HttpCodeEnum.INVALID_REQUEST.getCode(), HttpCodeEnum.INVALID_REQUEST.getMessage(), data);
	}

	/**
	 * 未登录
	 * @return
	 */
	public static ReturnEntity nologin() {
		return new ReturnEntity(HttpCodeEnum.NO_LOGIN.getCode(),HttpCodeEnum.NO_LOGIN.getMessage());
	}
	/**
	 * 没有权限
	 * @return
	 */
	public static ReturnEntity unAuthorized() {
		return new ReturnEntity(HttpCodeEnum.UNAUTHORIZED.getCode(),HttpCodeEnum.UNAUTHORIZED.getMessage());
	}

	/**
	 * 没有权限
	 * @param data
	 * @return
	 */
	public static ReturnEntity unAuthorized(Object data) {
		return new ReturnEntity(HttpCodeEnum.UNAUTHORIZED.getCode(),HttpCodeEnum.UNAUTHORIZED.getMessage(),data);
	}


	/**
	 *  禁止访问
	 * @return
	 */
	public static ReturnEntity forbidden() {
		return new ReturnEntity(HttpCodeEnum.FORBIDDEN.getCode(),HttpCodeEnum.FORBIDDEN.getMessage());
	}

	/**
	 * 禁止访问
	 * @param data
	 * @return
	 */
	public static ReturnEntity forbidden(Object data) {
		return new ReturnEntity(HttpCodeEnum.FORBIDDEN.getCode(),HttpCodeEnum.FORBIDDEN.getMessage(), data);
	}


	/**
	 * 资源不存在
	 * @return
	 */
	public static ReturnEntity notFound() {
		return new ReturnEntity(HttpCodeEnum.NOT_FOUND.getCode(),HttpCodeEnum.NOT_FOUND.getMessage());
	}


	/**
	 * 资源不存在
	 * @param data
	 * @return
	 */
	public static ReturnEntity notFound(Object data) {
		return new ReturnEntity(HttpCodeEnum.NOT_FOUND.getCode(),HttpCodeEnum.NOT_FOUND.getMessage(), data);
	}


	/**
	 * 请求的格式不正确
	 * @return
	 */
	public static ReturnEntity notAcceptable() {
		return new ReturnEntity(HttpCodeEnum.NOT_ACCEPTABLE.getCode(),HttpCodeEnum.NOT_ACCEPTABLE.getMessage());
	}


	/**
	 * 请求的格式不正确
	 * @param data
	 * @return
	 */
	public static ReturnEntity notAcceptable(Object data) {
		return new ReturnEntity(HttpCodeEnum.NOT_ACCEPTABLE.getCode(),HttpCodeEnum.NOT_ACCEPTABLE.getMessage(), data);
	}


	/**
	 * 数据已经被删除
	 * @return
	 */
	public static ReturnEntity gone() {
		return new ReturnEntity(HttpCodeEnum.GONE.getCode(),HttpCodeEnum.GONE.getMessage());
	}


	/**
	 * 数据已经被删除
	 * @param data
	 * @return
	 */
	public static ReturnEntity gone(Object data) {
		return new ReturnEntity(HttpCodeEnum.GONE.getCode(),HttpCodeEnum.GONE.getMessage(), data);
	}


	/**
	 * 实体参数校验错误
	 * @return
	 */
	public static ReturnEntity unprocesableEntity() {
		return new ReturnEntity(HttpCodeEnum.UNPROCESABLE_ENTITY.getCode(),HttpCodeEnum.UNPROCESABLE_ENTITY.getMessage());
	}


	/**
	 * 实体参数校验错误
	 * @param data
	 * @return
	 */
	public static ReturnEntity unprocesableEntity(Object data) {
		return new ReturnEntity(HttpCodeEnum.UNPROCESABLE_ENTITY.getCode(),HttpCodeEnum.UNPROCESABLE_ENTITY.getMessage(), data);
	}



	/**
	 * 未知错误
	 * @return
	 */
	public static ReturnEntity unKnowError() {
		return new ReturnEntity(HttpCodeEnum.UN_KNOW_ERROR.getCode(),HttpCodeEnum.UN_KNOW_ERROR.getMessage());
	}

	/**
	 * 未知错误
	 * @param data
	 * @return
	 */
	public static ReturnEntity unKnowError(Object data) {
		return new ReturnEntity(HttpCodeEnum.UN_KNOW_ERROR.getCode(),HttpCodeEnum.UN_KNOW_ERROR.getMessage(), data);
	}


	/**
	 * 自定义返回
	 * @param e
	 * @return
	 */
	public static ReturnEntity custom(HttpCodeEnum e) {
		return new ReturnEntity(e.getCode(),e.getMessage());
	}
	/**
	 * 自定义返回
	 * @param error
	 * @return
	 */
	public static ReturnEntity custom(int code,String error) {
		return new ReturnEntity(code,error);
	}

	/**
	 * 自定义返回
	 * @param error
	 * @param data
	 * @return
	 */
	public static ReturnEntity custom(int code,String error,Object data) {
		return new ReturnEntity(code,error,data);
	}
}
