package com.pro.sell.dto;

import lombok.Data;

/**
 * 前端传来的商品列表
 * @author Administrator
 */

@Data
public class CartDTO {
    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    /** 商品id */
    private String productId;

    /** 数量*/
    private Integer productQuantity;
}
