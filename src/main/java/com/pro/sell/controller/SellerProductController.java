package com.pro.sell.controller;

import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.service.ProductInfoService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
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
 * 商品管理
 * @author Administrator
 */
@Controller
@RequestMapping("/seller/product")
@Api(value = "商品管理")
@Slf4j
public class SellerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    @ApiOperation(value="商品列表展示", notes="商品列表展示")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1")Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size, Map<String, Object> map){
        PageRequest of = PageRequest.of(page - 1, size);
        Page<ProductInfoModel> all = productInfoService.findAll(of);
        map.put("productInfoPage", all);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list", map);
    }

    @GetMapping("/on_sale")
    @ApiOperation(value="商品列表展示", notes="商品列表展示")
    public ModelAndView onSale(@RequestParam("productId") String productId, Map<String, Object> map){
        try {
            productInfoService.onSale(productId);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");
        }

        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success", map);
    }


    @GetMapping("/off_sale")
    @ApiOperation(value="商品列表展示", notes="商品列表展示")
    public ModelAndView offSale(@RequestParam("productId") String productId, Map<String, Object> map){
        try {
            productInfoService.offSale(productId);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list");
        }

        map.put("url","/sell/seller/product/list");

        return new ModelAndView("common/success", map);
    }
}
