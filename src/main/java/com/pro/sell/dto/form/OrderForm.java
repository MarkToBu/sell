package com.pro.sell.dto.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Administrator
 */
@Data
public class OrderForm {

    /**
     * 买家
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号码")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openId必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;

}
