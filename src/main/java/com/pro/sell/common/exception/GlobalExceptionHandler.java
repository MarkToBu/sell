package com.pro.sell.common.exception;


import com.pro.sell.common.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public ResponseEntity handlerException(HttpServletRequest request, HttpClientErrorException e) {
        log.info("--URL:" + request.getRequestURI());
        log.error(e.getMessage(), e);
        if (HttpStatus.UNAUTHORIZED.equals(e.getStatusCode())){
            return new ResponseEntity<>("{\"code\": 0,\"message\":\"token is non-existent!\"}", e.getStatusCode());
        }
        if (HttpStatus.FORBIDDEN.equals(e.getStatusCode())){
            return new ResponseEntity<>("{\"code\": 0,\"message\": \"no auth\"}", e.getStatusCode());
        }
        return ResponseEntity.status(e.getRawStatusCode())
                .headers(e.getResponseHeaders())
                .body(e.getResponseBodyAsString());
    }

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @returns
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServerResponse handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        log.info("URL           :{}", request.getRequestURI());
        log.info("参数格式不正确:{}", defaultMessage);
        return ServerResponse.createByErrorMessage(defaultMessage);
    }

    /**
     * 处理所有接口数据验证异常
     *
     * @param e
     * @returns
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ServerResponse handleBindException(HttpServletRequest request, BindException e) {
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        log.info("URL           :{}", request.getRequestURI());
        log.info("参数格式不正确:{}", defaultMessage);
        return ServerResponse.createByErrorMessage(defaultMessage);
    }

    /**
     * 处理自定义异常 BusinessTypeException
     *
     * @param e
     * @returns
     */
    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ServerResponse handlerException(SellException e) {
        log.error(e.getMessage(), e);
        return ServerResponse.createByErrorMessage(e.getMessage());
    }

    /**
     * 处理异常 Exception
     *
     * @param e
     * @returns
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ServerResponse handlerException(Exception e) {
        log.error(e.getMessage(), e);
        return ServerResponse.createByErrorMessage("系统繁忙,请稍后重试!");
    }
}
