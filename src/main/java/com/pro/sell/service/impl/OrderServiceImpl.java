package com.pro.sell.service.impl;

import com.pro.sell.common.enums.OrderStatusEnums;
import com.pro.sell.common.enums.PayStatusEnum;
import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.common.util.KeyUtil;
import com.pro.sell.common.convert.OrderMasterConverter;
import com.pro.sell.dto.CartDTO;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.model.OrderDetailModel;
import com.pro.sell.model.OrderMasterModel;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.repository.OrderDetailRepository;
import com.pro.sell.repository.OrderMasterRepository;
import com.pro.sell.service.OrderService;
import com.pro.sell.service.PayService;
import com.pro.sell.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private PayService payService;

    @Override
    @Transactional(rollbackFor = Exception.class)
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
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
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
        dto.setOrderId(orderId);
        BeanUtils.copyProperties(dto, orderMasterModel);
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
        OrderMasterModel one = orderMasterRepository.getOne(id);
        if (one == null){
           throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetailModel> orderDetailModelList = orderDetailRepository.findByOrderId(id);
        if(CollectionUtils.isEmpty(orderDetailModelList)){
            throw new SellException(ResultEnum.ORDER_IS_EMPTY);
        }
        OrderMasterDTO dto = new OrderMasterDTO();
        BeanUtils.copyProperties(one, dto);
        dto.setOrderDetailList(orderDetailModelList);

        return dto;
    }

    @Override
    public Page<OrderMasterDTO> findList(String buyerOpenId, Pageable pageable) {
        Page<OrderMasterModel> orderMasterList = orderMasterRepository.findByBuyerOpenid(buyerOpenId, pageable);

        List<OrderMasterDTO> convert = OrderMasterConverter.convert(orderMasterList.getContent());
        Page<OrderMasterDTO> orderMasterDTOPage = new PageImpl<OrderMasterDTO>(convert, pageable, orderMasterList.getTotalElements());

        return orderMasterDTOPage;
    }

    @Override
    public Page<OrderMasterDTO> findList(Pageable pageable) {
        Page<OrderMasterModel> all = orderMasterRepository.findAll(pageable);
        List<OrderMasterDTO> orderMasterDTOList = OrderMasterConverter.convert(all.getContent());

        return new PageImpl<>(orderMasterDTOList, pageable, all.getTotalElements());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO) {
       OrderMasterModel orderMaster = new OrderMasterModel();

       //判断订单状态

        if ( !orderMasterDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())){
            log.error("[取消订单] 订单状态不正确，OrderId = {}, OrderStatus = {}",orderMasterDTO.getOrderId(), orderMasterDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderMasterDTO.setOrderStatus(OrderStatusEnums.CANCEL.getCode());
        BeanUtils.copyProperties(orderMasterDTO, orderMaster);
        OrderMasterModel updateReuslt = orderMasterRepository.save(orderMaster);
        if (updateReuslt == null){
            log.error("[取消订单]更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        //返还库存
        if (CollectionUtils.isEmpty(orderMasterDTO.getOrderDetailList())){
            log.error("[取消订单] 订单中五商品详情，orderDto = {}",orderMasterDTO);
            throw new SellException(ResultEnum.ORDER_IS_EMPTY);
        }
        List<CartDTO> cartDTOList = orderMasterDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productInfoService.increaseStock(cartDTOList);

        //如果已支付，要退款
        if (orderMasterDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            payService.refund(orderMasterDTO);
        }

        return orderMasterDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderMasterDTO finish(OrderMasterDTO orderMasterDTO) {
        //判断订单状态
        if ( !orderMasterDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())){
            log.error("[取消订单] 订单状态不正确，OrderId = {}, OrderStatus = {}",orderMasterDTO.getOrderId(), orderMasterDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderMasterDTO.setOrderStatus(OrderStatusEnums.FINISH.getCode());
        OrderMasterModel orderMasterModel = new OrderMasterModel();
        BeanUtils.copyProperties(orderMasterDTO, orderMasterModel);
        OrderMasterModel save = orderMasterRepository.save(orderMasterModel);
        if (save == null){
            log.error("[取消订单]更新失败，orderMaster={}",orderMasterDTO);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderMasterDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderMasterDTO paid(OrderMasterDTO orderMasterDTO) {
        //判断订单状态
        if ( !orderMasterDTO.getOrderStatus().equals(OrderStatusEnums.NEW.getCode())){
            log.error("[取消订单] 订单状态不正确，OrderId = {}, OrderStatus = {}",orderMasterDTO.getOrderId(), orderMasterDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //判断支付状态
        if (!orderMasterDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())) {
            log.error("[点单支付完成] 订单支付状态不正确， orderDto = {}", orderMasterDTO);
            throw new SellException(ResultEnum.ORDER_PAY_STATUS_ERROR);
        }

        //修改支付状态
        orderMasterDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMasterModel orderMasterModel = new OrderMasterModel();
        BeanUtils.copyProperties(orderMasterDTO, orderMasterModel);
        OrderMasterModel save = orderMasterRepository.save(orderMasterModel);
        if (save == null){
            log.error("[取消订单]更新失败，orderMaster={}",orderMasterDTO);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }

        return orderMasterDTO;
    }
}
