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

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * ORDER_DETAIL
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Entity
@Table(name = "ORDER_DETAIL")
@DynamicUpdate
@Data
@NoArgsConstructor
public class OrderDetailModel implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -8336784742101021654L;

    /**
     * detailId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETAIL_ID", unique = true, nullable = false, length = 32)
    private String detailId;

    /**
     * orderId
     */
    @Column(name = "ORDER_ID", nullable = false, length = 32)
    private String orderId;

    /**
     * productId
     */
    @Column(name = "PRODUCT_ID", nullable = false, length = 32)
    private String productId;

    /**
     * 商品名称
     */
    @Column(name = "PRODUCT_NAME", nullable = false, length = 64)
    private String productName;

    /**
     * 当前价格,分
     */
    @Column(name = "PRODUCT_PRICE", nullable = false, length = 9)
    private BigDecimal productPrice;

    /**
     * 数量
     */
    @Column(name = "PRODUCT_QUANTITY", nullable = false, length = 10)
    private Integer productQuantity;

    /**
     * 小图
     */
    @Column(name = "PRODUCT_ICON", nullable = true, length = 512)
    private String productIcon;

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

