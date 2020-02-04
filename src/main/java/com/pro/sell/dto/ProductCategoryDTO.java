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

import java.sql.Timestamp;

/**
 * PRODECT_CATEGORY
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */

@Data
public class ProductCategoryDTO implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -8489278934771142810L;

    /**
     * categoryId
     */
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

}

