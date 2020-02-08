package com.pro.sell.service.impl;

import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.service.BuyerService;
import com.pro.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderMasterDTO findOrderOne(String openid, String orderId) {
        return checkOwner(openid, orderId);

    }

    @Override
    public OrderMasterDTO cancelOrderOne(String openid, String orderId) {
        OrderMasterDTO orderMasterDTO = checkOwner(openid, orderId);
        if(orderMasterDTO == null){
            log.error("【取消订单】查不到该订单，orderId = {}", orderId);
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderMasterDTO;
    }

    private OrderMasterDTO checkOwner(String openid, String orderId) {
        OrderMasterDTO one = orderService.findOne(orderId);
        if (one == null) {
            return null;
        }
        if (one.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致。 openid = {}, orderDTO = {}", openid, one);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);

        }
        return one;
    }
}
