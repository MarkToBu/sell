package com.pro.sell.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品库存不足"),
    ORDER_NOT_EXIST(12,"订单不存在"),
    ORDER_IS_EMPTY(13, "订单详情为空"),
    ORDER_STATUS_ERROR(14, "订单状态错误"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_PAY_STATUS_ERROR(16, "订单支付状态错误"),
    PARAM_ERROR(17, "参数错误"),
    CART_EMMPTY(18, "购物车给为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    WECHAT_MP_ERROR(20, "微信公众账号方面错误"),
    ;



    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

}
