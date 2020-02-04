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

import java.sql.Timestamp;

/**
 * 卖家信息表(SELLER_INFO)
 * 
 * @author Gianna
 * @version 1.0.0 2020-02-03
 */
public class SellerInfoDTO implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 682725994689680006L;

    /** sellerId */
    private String sellerId;

    /** username */
    private String username;

    /** password */
    private String password;

    /** 微信openID */
    private String openid;

    /** 创建时间 */
    private Timestamp createTime;

    /** 修改时间 */
    private Timestamp updateTime;

    /**
     * 获取sellerId
     * 
     * @return sellerId
     */
    public String getSellerId() {
        return this.sellerId;
    }

    /**
     * 设置sellerId
     * 
     * @param sellerId
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取username
     * 
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 设置username
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取password
     * 
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 设置password
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取微信openID
     * 
     * @return 微信openID
     */
    public String getOpenid() {
        return this.openid;
    }

    /**
     * 设置微信openID
     * 
     * @param openid
     *          微信openID
     */
    public void setOpenid(String openid) {
        this.openid = openid;
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