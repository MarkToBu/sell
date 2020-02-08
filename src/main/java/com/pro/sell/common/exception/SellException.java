package com.pro.sell.common.exception;

import com.pro.sell.common.enums.ResultEnum;

/**
 * 项目异常
 * @author Administrator
 */
public class SellException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -7342243882722872947L;

    private Integer code;

    private String message;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(String message, Throwable cause) {
        super(message, cause);
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }
}
