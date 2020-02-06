package com.pro.sell.model;/*
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

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.*;

import com.pro.sell.common.enums.OrderStatusEnums;
import com.pro.sell.common.enums.PayStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * ORDER_MASTER
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Entity
@Table(name = "ORDER_MASTER")
@DynamicUpdate
@Data
@NoArgsConstructor
public class OrderMasterModel implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -2933033267651552351L;

    /**
     * orderId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true, nullable = false, length = 32)
    private String orderId;

    /**
     * 买家名字
     */
    @Column(name = "BUYER_NAME", nullable = false, length = 32)
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "BUYER_PHONE", nullable = false, length = 32)
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "BUYER_ADDRESS", nullable = false, length = 128)
    private String buyerAddress;

    /**
     * 买家微信
     */
    @Column(name = "BUYER_OPENID", nullable = false, length = 64)
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    @Column(name = "ORDER_AMOUNT", nullable = false, length = 8)
    private BigDecimal orderAmount;

    /**
     * 订单状态，默认为新下单
     */
    @Column(name = "ORDER_STATUS", nullable = false, length = 3)
    private Integer orderStatus = OrderStatusEnums.NEW.getCode();

    /**
     * 支付状态，默认为未支付
     */
    @Column(name = "PAY_STATUS", nullable = false, length = 3)
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME", nullable = false, length = 26)
    private Timestamp createTime;

    /**
     * 修改时间
     */
    @Column(name = "UPDATE_TIME", nullable = false, length = 26)
    private Timestamp updateTime;

}

