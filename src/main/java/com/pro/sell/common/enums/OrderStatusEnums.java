package com.pro.sell.common.enums;

import lombok.Getter;

/**
 * 订单状态的枚举
 * @author Administrator
 */

@Getter
public enum  OrderStatusEnums {
    NEW(0, "新生成"),
    FINISH(1, "旧订单"),
    CANCEL(2, "旧订单");

    private Integer code;

    private String message;

    OrderStatusEnums(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
