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

import java.sql.Timestamp;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**
 * PRODECT_CATEGORY
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Entity
@Table(name = "PRODUCT_CATEGORY")
@DynamicUpdate
@Data
@NoArgsConstructor
public class ProductCategoryModel implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = -8489278934771142810L;

    /**
     * categoryId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID", unique = true, nullable = false, length = 10)
    private Integer categoryId;

    /**
     * 类目名称
     */
    @Column(name = "CATEGORY_NAME", nullable = false, length = 64)
    private String categoryName;

    /**
     * 类目编号
     */
    @Column(name = "CATEGORY_TYPE", unique = true, nullable = false, length = 10)
    private Integer categoryType;

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

