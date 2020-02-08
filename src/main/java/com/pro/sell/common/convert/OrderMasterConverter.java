package com.pro.sell.common.convert;

import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.model.OrderMasterModel;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMasterConverter {

    public static OrderMasterDTO convert(OrderMasterModel orderMasterModel){
        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
        BeanUtils.copyProperties(orderMasterModel, orderMasterDTO);
        return orderMasterDTO;
    }

    public static List<OrderMasterDTO> convert(List<OrderMasterModel> orderMasterModelList){
        return orderMasterModelList.stream().map(e -> convert(e)).collect(Collectors.toList());
    }
}
