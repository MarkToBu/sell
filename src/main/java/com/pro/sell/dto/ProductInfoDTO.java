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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pro.sell.common.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * PRODUCT_INFO
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Data
public class ProductInfoDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 36759465417067348L;

    /** productId */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 商品状态,0正常1下架 */
//    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;

    /** 创建时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Timestamp createTime;

    /** 修改时间 */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Timestamp updateTime;

}

