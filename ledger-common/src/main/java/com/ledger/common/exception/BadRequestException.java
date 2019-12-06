package com.ledger.common.exception;

import com.ledger.common.core.entity.response.AjaxResult;
import com.ledger.common.enums.HttpCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 * 统一异常处理
 */
@Getter
public class BadRequestException extends RuntimeException{

    private Integer status = BAD_REQUEST.value();
    private String error;

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status,String msg){
        super(msg);
        this.status = status.value();
    }

    public BadRequestException(HttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMessage());
        this.status = httpCodeEnum.getCode();
        this.error = httpCodeEnum.getMessage();
    }
}
