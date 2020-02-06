package com.pro.sell.common.util;

import java.util.Random;

/**
 * 生成主键的方法
 * @author Administrator
 */
public class KeyUtil {

    public static synchronized  String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) +100000;

        return  System.currentTimeMillis() +String.valueOf(number);
    }
}
