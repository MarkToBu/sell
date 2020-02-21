package com.pro.sell.handler;

import com.pro.sell.config.ProjectUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maktub
 * @Date 2020/2/20 20:23
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登录异常
     */
    @ExceptionHandler
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

}
