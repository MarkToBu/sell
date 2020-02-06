package com.pro.sell.service.impl;

import com.pro.sell.common.enums.OrderStatusEnums;
import com.pro.sell.common.enums.PayStatusEnum;
import com.pro.sell.common.enums.ResultEum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.common.util.BigDecimalUtil;
import com.pro.sell.common.util.KeyUtil;
import com.pro.sell.dto.CartDTO;
import com.pro.sell.dto.OrderDetailDTO;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.model.OrderDetailModel;
import com.pro.sell.model.OrderMasterModel;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.repository.OrderDetailRepository;
import com.pro.sell.repository.OrderMasterRepository;
import com.pro.sell.service.OrderService;
import com.pro.sell.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 添加
 * @author Administrator
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional
    public OrderMasterDTO createOrder(OrderMasterDTO dto) {
        //1.  查询商品信息、库存
        List<OrderDetailModel> orderDetailList = dto.getOrderDetailList();
        if(CollectionUtils.isEmpty(orderDetailList)){
            throw new RuntimeException("订单为空");
        }

        String orderId = KeyUtil.getUniqueKey();
        BigDecimal totalAmount = new BigDecimal("0.0");
        for (OrderDetailModel orderDetail : orderDetailList) {
            ProductInfoModel productInfo = productInfoService.findOne(orderDetail.getProductId());
            if(productInfo == null){
                throw new SellException(ResultEum.PRODUCT_NOT_EXIST);
            }

            //2. 计算订单总价  fixme decimal的计算可能有问题
            totalAmount = productInfo.getProductPrice().
                    multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(totalAmount);

            //订单入库 属性赋值
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            orderDetailRepository.save(orderDetail);

        }

        //3. 写入订单数据库
        OrderMasterModel orderMasterModel = new OrderMasterModel();
        BeanUtils.copyProperties(dto, orderMasterModel);
        orderMasterModel.setOrderId(orderId);
        orderMasterModel.setOrderAmount(totalAmount);
        orderMasterModel.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMasterModel.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMasterModel);


        //4. 扣库存
        List<CartDTO> collect = dto.getOrderDetailList().stream()
                .map(a -> new CartDTO(a.getProductId(), a.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.decreaseStock(collect );

        return dto;
    }

    @Override
    public OrderMasterDTO findOne(String id) {
        return null;
    }

    @Override
    public Page<OrderMasterDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO) {
        return null;
    }

    @Override
    public OrderMasterDTO finish(OrderMasterDTO orderMasterDTO) {
        return null;
    }

    @Override
    public OrderMasterDTO paid(OrderMasterDTO orderMasterDTO) {
        return null;
    }
}
