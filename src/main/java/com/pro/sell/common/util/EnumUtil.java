package com.pro.sell.common.util;

import com.pro.sell.common.enums.CodeEnum;

/**
 * 返回枚举的工作类
 * @author Administrator
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (code.equals(enumConstant.getCode())){
                return enumConstant;
            }
        }
        return null;
    }
}
