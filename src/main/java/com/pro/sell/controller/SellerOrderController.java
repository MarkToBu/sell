package com.pro.sell.controller;

import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 买家端controller
 * @author Administrator
 */

@Controller
@RequestMapping("/seller/order")
@Api(value = "买家商品")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    @ApiOperation(value="买家端", notes="买家端商品名称")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map){
        PageRequest of = PageRequest.of(page - 1, size);
        Page<OrderMasterDTO> list = orderService.findList(of);
        map.put("orderDTOPage", list);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("order/list", map);
    }

    /**
     *  取消订单
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId, Map<String, Object> map){
        try {
            OrderMasterDTO one = orderService.findOne(orderId);
            orderService.cancel(one);
        }catch (SellException e){
            log.error("【卖家端取消订单】发生异常 {}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map) {
        OrderMasterDTO orderDTO = new OrderMasterDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
     * 订单完结
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId, Map<String, Object> map) {

        OrderMasterDTO orderDTO = new OrderMasterDTO();
        try {
            orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        }catch (SellException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS);
        map.put("url", "/sell/seller/order/list");
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }



}
