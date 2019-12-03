package com.ledger.common.exception.file;


import ledger.common.exception.base.BaseException;

public class ExcelException extends BaseException {
	private static final long serialVersionUID = 1L;

	public ExcelException(String code, Object[] args) {
		super("excel", code, args, null);
	}
}
