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
 * PRODUCT_INFO
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Entity
@Table(name = "PRODUCT_INFO")
@DynamicUpdate
@Data
@NoArgsConstructor
public class ProductInfoModel implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 36759465417067348L;

    /** productId */
    @Id
    @GenericGenerator(name="idGenerator", strategy="uuid")
    @GeneratedValue(generator="idGenerator")
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false, length = 32)
    private String productId;

    /** 商品名称 */
    @Column(name = "PRODUCT_NAME", nullable = false, length = 64)
    private String productName;

    /** 商品单价 */
    @Column(name = "PRODUCT_PRICE", nullable = false, length = 8)
    private BigDecimal productPrice;

    /** 库存 */
    @Column(name = "PRODUCT_STOCK", nullable = false, length = 10)
    private Integer productStock;

    /** 描述 */
    @Column(name = "PRODUCT_DESCRIPTION", nullable = true, length = 54)
    private String productDescription;

    /** 小图 */
    @Column(name = "PRODUCT_ICON", nullable = true, length = 512)
    private String productIcon;

    /** 商品状态,0正常1下架 */
    @Column(name = "PRODUCT_STATUS", nullable = true, length = 3)
    private Integer productStatus;

    /** 类目编号 */
    @Column(name = "CATEGORY_TYPE", nullable = false, length = 10)
    private Integer categoryType;

    /** 创建时间 */
    @Column(name = "CREATE_TIME", nullable = false, length = 26)
    private Timestamp createTime;

    /** 修改时间 */
    @Column(name = "UPDATE_TIME", nullable = false, length = 26)
    private Timestamp updateTime;

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
     * 获取商品单价
     * 
     * @return 商品单价
     */
    public BigDecimal getProductPrice() {
        return this.productPrice;
    }

    /**
     * 设置商品单价
     * 
     * @param productPrice
     *          商品单价
     */
    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 获取库存
     * 
     * @return 库存
     */
    public Integer getProductStock() {
        return this.productStock;
    }

    /**
     * 设置库存
     * 
     * @param productStock
     *          库存
     */
    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    /**
     * 获取描述
     * 
     * @return 描述
     */
    public String getProductDescription() {
        return this.productDescription;
    }

    /**
     * 设置描述
     * 
     * @param productDescription
     *          描述
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
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
     * 获取商品状态,0正常1下架
     * 
     * @return 商品状态
     */
    public Integer getProductStatus() {
        return this.productStatus;
    }

    /**
     * 设置商品状态,0正常1下架
     * 
     * @param productStatus
     *          商品状态
     */
    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 获取类目编号
     * 
     * @return 类目编号
     */
    public Integer getCategoryType() {
        return this.categoryType;
    }

    /**
     * 设置类目编号
     * 
     * @param categoryType
     *          类目编号
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
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