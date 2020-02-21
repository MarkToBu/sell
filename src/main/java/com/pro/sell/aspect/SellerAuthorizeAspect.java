package com.pro.sell.aspect;

import com.pro.sell.common.Const;
import com.pro.sell.common.exception.SellerAuthorizeException;
import com.pro.sell.common.util.CookieUtil;
import freemarker.template.utility.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Maktub
 * @Date 2020/2/20 18:46
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.pro.sell.controller.Seller*.*(..)) && !execution(public * com.pro.sell.controller.SellerUserController.*(..)) ")
    public void verify(){};

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Cookie cookie = CookieUtil.get(request, Const.CookieConstant.TOKEN);
        if (cookie == null){
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }
        String tokenValue = redisTemplate.opsForValue().get(String.format(Const.RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if(StringUtils.isEmpty(tokenValue)){
            log.warn("【登录校验】redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
