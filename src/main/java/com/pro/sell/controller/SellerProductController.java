package com.pro.sell.controller;

import com.pro.sell.common.exception.SellException;
import com.pro.sell.common.util.KeyUtil;
import com.pro.sell.dto.ProductInfoDTO;
import com.pro.sell.model.ProductCategoryModel;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.service.ProductCategoryService;
import com.pro.sell.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
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
    @Autowired
    private ProductCategoryService productCategoryService;


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
            return new ModelAndView("common/error");
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
            return new ModelAndView("common/error");
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId, Map<String, Object> map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfoModel productInfo = productInfoService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有类目
        List<ProductCategoryModel> categoryList= productCategoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }


    @PostMapping("/save")
    public ModelAndView save(@Valid ProductInfoDTO productInfoDTO, BindingResult bindingResult, Map<String, Object> map){

        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error");
        }
        String productId = productInfoDTO.getProductId();

        ProductInfoModel productInfoModel = new ProductInfoModel();
        try {
            //id为空，表示新增
            if (!StringUtils.isEmpty(productId)){
                productInfoModel = productInfoService.findOne(productId);
            }
            BeanUtils.copyProperties(productInfoDTO, productInfoModel);
            productInfoService.save(productInfoModel);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/index");
            return new ModelAndView("common/error");
        }

        map.put("url","/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
