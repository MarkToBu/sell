package com.pro.sell.service;

import com.pro.sell.dto.OrderMasterDTO;

/**
 * @author Administrator
 */
public interface BuyerService {
    /**
     * 查询一个订单
     */
    OrderMasterDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     */
    OrderMasterDTO cancelOrderOne(String openid, String orderId);
}
