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
 * 卖家信息表(SELLER_INFO)
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
@Entity
@Table(name = "SELLER_INFO")
@DynamicUpdate
@Data
@NoArgsConstructor
public class SellerInfoModel implements java.io.Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 682725994689680006L;

    /**
     * sellerId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELLER_ID", unique = true, nullable = false, length = 32)
    private String sellerId;

    /**
     * username
     */
    @Column(name = "USERNAME", nullable = false, length = 32)
    private String username;

    /**
     * password
     */
    @Column(name = "PASSWORD", nullable = false, length = 32)
    private String password;

    /**
     * 微信openID
     */
    @Column(name = "OPENID", nullable = false, length = 64)
    private String openid;

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
