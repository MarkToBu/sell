package com.pro.sell.common.enums;

import com.pro.sell.common.util.EnumUtil;
import lombok.Getter;

/**
 * 订单状态的枚举
 * @author Administrator
 */

@Getter
public enum  OrderStatusEnums implements CodeEnum{
    NEW(0, "新订单"),
    FINISH(1, "旧订单"),
    CANCEL(2, "旧订单");

    private Integer code;

    private String message;

    OrderStatusEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}
