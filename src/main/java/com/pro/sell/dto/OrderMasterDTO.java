package com.pro.sell.dto;/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:Gianna
 * Email:edinsker@163.com
 * Version:5.8.8
 */

import com.pro.sell.model.OrderDetailModel;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * ORDER_MASTER
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Data
public class OrderMasterDTO implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -2933033267651552351L;

    /**
     * orderId
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为新下单
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认为未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    private List<OrderDetailModel> orderDetailList;

}

