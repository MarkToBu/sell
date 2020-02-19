package com.pro.sell.common;


/**
 * 常用类
 * @author Administrator
 */
public class Const {
    /**
     * redis常量
     */
     public  interface RedisConstant {
        String TOKEN_PREFIX = "token_%s";
        //2小时
        Integer EXPIRE = 7200;
    }

    public interface CookieConstant{
        String TOKEN = "token";
        Integer EXPIRE = 7200;
    }

}
