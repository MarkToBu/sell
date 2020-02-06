package com.pro.sell.common.exception;

import com.pro.sell.common.enums.ResultEum;

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

    public SellException(ResultEum resultEum){
        super(resultEum.getMessage());
        this.code = resultEum.getCode();
    }

    public SellException(String message, Throwable cause) {
        super(message, cause);
    }
}
