package com.pro.sell.controller;

import com.pro.sell.common.ServerResponse;
import com.pro.sell.common.convert.OrderForm2OrderDtoConvert;
import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.dto.form.OrderForm;
import com.pro.sell.service.BuyerService;
import com.pro.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

   @Autowired
   private OrderService orderService;

   @Autowired
   private BuyerService  buyerService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ServerResponse<Map<String, String>> create(@Validated OrderForm orderForm
    , BindingResult bindResult){
        if (bindResult.hasErrors()){
            log.error("[创建订单]参数不正确， orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindResult.getFieldError().getDefaultMessage());
        }
        OrderMasterDTO orderMasterDTO = OrderForm2OrderDtoConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderMasterDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw  new SellException(ResultEnum.CART_EMMPTY);
        }
        OrderMasterDTO order = orderService.createOrder(orderMasterDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", order.getOrderId());

        return ServerResponse.createBySuccess(map);
    }

    /**
     * 查询list
     */
    @GetMapping("/list")
    public ServerResponse<List<OrderMasterDTO>> list(@RequestParam("openid") String openid,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size", defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page,size);
        Page<OrderMasterDTO> result = orderService.findList(openid, request);

        return ServerResponse.createBySuccess(result.getContent());
    }

    /**
     *查询订单详情
     */
    @GetMapping("/detail")
    public ServerResponse<OrderMasterDTO> detail(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId ){

        /*
        不安全的做法，越权访问
        OrderMasterDTO one = orderService.findOne(orderId);
        */
        OrderMasterDTO orderOne = buyerService.findOrderOne(openid, orderId);

        return  ServerResponse.createBySuccess(orderOne);
    }

   /**
    * 取消订单
    */
    @PostMapping("/cancel")
    public ServerResponse<OrderMasterDTO> cancel(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId ){
        OrderMasterDTO dto = orderService.findOne(orderId);

        /*
        //不安全的做法，越权访问
        orderService.cancel(dto);
         */

        OrderMasterDTO orderMasterDTO = buyerService.cancelOrderOne(openid, orderId);

        return ServerResponse.createBySuccess();
    }
}
