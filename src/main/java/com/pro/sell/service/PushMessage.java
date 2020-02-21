package com.pro.sell.service;

import com.pro.sell.dto.OrderMasterDTO;

/**
 * 推送消息
 * @author Maktub
 * @Date 2020/2/21 10:45
 */
public interface PushMessage {

    /**
     * 订单状态变更
     * @param orderMasterDto
     */
    void pushOrderStatus(OrderMasterDTO orderMasterDto);
}
