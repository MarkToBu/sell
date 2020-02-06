package com.pro.sell.service;

import com.pro.sell.dto.OrderMasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

/**
 * Created by KW
 * date
 * @author Administrator
 */
public interface OrderService {

    /**
     * 创建订单
     * @param dto
     */
    OrderMasterDTO createOrder(OrderMasterDTO dto);

    /** 查询单个订单 */
    OrderMasterDTO findOne(String id);

    /**
     *  查询订单列表
     * @param buyerOpenId
     * @param pageable
     * */
    Page<OrderMasterDTO> findList(String buyerOpenId, Pageable pageable);

    /** 取消订单*/
    OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO);

    /** 完结订单*/
    OrderMasterDTO  finish(OrderMasterDTO orderMasterDTO);

    /** 支付订单*/
    OrderMasterDTO paid(OrderMasterDTO orderMasterDTO);
}
