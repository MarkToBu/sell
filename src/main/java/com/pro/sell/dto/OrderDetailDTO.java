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

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * ORDER_DETAIL
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Data
public class OrderDetailDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -8336784742101021654L;

    /** detailId */
    private String detailId;

    /** orderId */
    private String orderId;

    /** productId */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 当前价格,分 */
    private BigDecimal productPrice;

    /** 数量 */
    private Integer productQuantity;

    /** 小图 */
    private String productIcon;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /**
     * 获取detailId
     * 
     * @return detailId
     */
    public String getDetailId() {
        return this.detailId;
    }

    /**
     * 设置detailId
     * 
     * @param detailId
     */
    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    /**
     * 获取orderId
     * 
     * @return orderId
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * 设置orderId
     * 
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取productId
     * 
     * @return productId
     */
    public String getProductId() {
        return this.productId;
    }

    /**
     * 设置productId
     * 
     * @param productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     * 
     * @return 商品名称
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置商品名称
     * 
     * @param productName
     *          商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取当前价格,分
     * 
     * @return 当前价格
     */
    public BigDecimal getProductPrice() {
        return this.productPrice;
    }

    /**
     * 设置当前价格,分
     * 
     * @param productPrice
     *          当前价格
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取数量
     * 
     * @return 数量
     */
    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    /**
     * 设置数量
     * 
     * @param productQuantity
     *          数量
     */
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     * 获取小图
     * 
     * @return 小图
     */
    public String getProductIcon() {
        return this.productIcon;
    }

    /**
     * 设置小图
     * 
     * @param productIcon
     *          小图
     */
    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Timestamp getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime
     *          创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     * 
     * @return 修改时间
     */
    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置修改时间
     * 
     * @param updateTime
     *          修改时间
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}