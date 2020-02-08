package com.pro.sell.common.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.dto.form.OrderForm;
import com.pro.sell.model.OrderDetailModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@Slf4j
public class OrderForm2OrderDtoConvert {

    public static OrderMasterDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderMasterDTO orderDTO = new OrderMasterDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetailModel> orderDetailList = new ArrayList<>();
        try{
            orderDetailList = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetailModel>>() {
            }.getType());
        } catch(
                Exception e){
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }

}

