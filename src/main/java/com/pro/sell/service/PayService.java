package com.pro.sell.service;


import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import com.pro.sell.dto.OrderMasterDTO;

/**
 * 支付接口
 */
public interface PayService {


    PayResponse create(OrderMasterDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderMasterDTO orderDTO);
}
