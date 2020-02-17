package com.pro.sell.controller;

import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.ProductCategoryDTO;
import com.pro.sell.model.ProductCategoryModel;
import com.pro.sell.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 类目的管理
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<ProductCategoryModel> all = productCategoryService.findAll();
        map.put("categoryList", all);
        return new ModelAndView("category/list");

    }

    /**
     * 商品类别的新增和修改
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam (value = "categoryId",required = false) Integer categoryId, Map<String, Object> map){
        if(categoryId != null){
            ProductCategoryModel one = productCategoryService.findOne(categoryId);
            map.put("productCategory", one);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 新增/保存类别
     * @param productCategoryDTO
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid  ProductCategoryDTO productCategoryDTO, BindingResult bindingResult, Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error");
        }
        Integer categoryId = productCategoryDTO.getCategoryId();
        ProductCategoryModel category= new ProductCategoryModel();
        try {
            if(categoryId != null){
                category = productCategoryService.findOne(categoryId);
            }
            BeanUtils.copyProperties(productCategoryDTO, category);
            productCategoryService.save(category);

        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/category/index");
            return new ModelAndView("common/error");
        }

        map.put("url","/sell/seller/category/list");
        return new ModelAndView("common/success", map);

    }

}
