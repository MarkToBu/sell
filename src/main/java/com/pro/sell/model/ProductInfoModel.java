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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pro.sell.common.enums.ProductStatusEnum;
import com.pro.sell.common.util.EnumUtil;
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    @Column(name = "CATEGORY_TYPE", nullable = false, length = 10)
    private Integer categoryType;

    /** 创建时间 */
    @Column(name = "CREATE_TIME", nullable = false, length = 26)
    private Timestamp createTime;

    /** 修改时间 */
    @Column(name = "UPDATE_TIME", nullable = false, length = 26)
    private Timestamp updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}