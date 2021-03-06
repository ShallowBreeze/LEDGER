package com.ledger.common.core.entity.response;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ledger.common.enums.HttpCodeEnum;

import java.util.List;

public class PageResult<T> extends ReturnEntity {

	private Long total = 0L;
	private Long totalPage;
	private List<T> rows;
	private Long page = 1L;
	private Long pageSize = 0L;
	private List footer;
	
	public PageResult(PageInfo<T> page) {
		this.rows = page.getList();
		this.total = page.getTotal();
		this.pageSize = (long)page.getPageSize();
		this.totalPage = (long) Math.ceil((double)this.total / (double)this.pageSize);
		this.page = (long)page.getPageNum();
		this.code = HttpCodeEnum.OK.getCode();
		this.message = HttpCodeEnum.OK.getMessage();
	}
	
	public PageResult(Page<T> page) {
		this.rows = page.getResult();
		this.total = page.getTotal();
		this.pageSize = (long)page.getPageSize();
		this.totalPage = (long) Math.ceil((double)this.total / (double)this.pageSize);
		this.page = (long)page.getPageNum();
		this.code = HttpCodeEnum.OK.getCode();
		this.message = HttpCodeEnum.OK.getMessage();
	}
	
	public PageResult(Page<T> page, List<T> list) {
		this.rows = list;
		this.total = page.getTotal();
		this.pageSize = (long)page.getPageSize();
		this.totalPage = (long) Math.ceil((double)this.total / (double)this.pageSize);
		this.page = (long)page.getPageNum();
		this.code = HttpCodeEnum.OK.getCode();
		this.message = HttpCodeEnum.OK.getMessage();
	}
	
	public PageResult(HttpCodeEnum e, String msg) {
		this.rows = Lists.newArrayList();
		this.code = e.getCode();
		this.message = msg;
	}
	
	public PageResult() {
		this.code =HttpCodeEnum.FAIL.getCode();
		this.message = HttpCodeEnum.FAIL.getMessage();
	}
	
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public static <T> PageResult<T> create(List<T> list) {
		PageInfo<T> page = new PageInfo<T>(list);
		return new PageResult<T>(page);
	}
	
	public static <T> PageResult<T> create(PageInfo<T> page) {
		return new PageResult<T>(page);
	}
	
	public static <T> PageResult<T> create(Page page, List<T> list) {
		return new PageResult<T>(page, list);
	}
	
	public static <T> PageResult<T> createEmpty() {
		return new PageResult<T>();
	}
	
	public static <T> PageResult<T> createFail(String msg) {
		return new PageResult<T>(HttpCodeEnum.FAIL, msg);
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List getFooter() {
		return footer;
	}

	public void setFooter(List footer) {
		this.footer = footer;
	}
	
}
