package com.pro.sell.controller;

import com.pro.sell.common.ServerResponse;
import com.pro.sell.dto.vo.ProductInfoVo;
import com.pro.sell.dto.vo.ProductVO;
import com.pro.sell.model.ProductCategoryModel;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.service.ProductCategoryService;
import com.pro.sell.service.ProductInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/buyer/product")
@Api(value = "买家商品")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    @ApiOperation(value="查询上架商品的名称", notes="根据种类显示上架商品的名称")
    public ServerResponse list(){
        //1. 查询所有上架商品
        List<ProductInfoModel> upAllProducts = productInfoService.findUpAll();
        //2. 查询类目

       /*
       List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
        for (ProductInfoModel p : upAllProducts) {
            categoryTypeList.add(p.getCategoryType());
        }*/
        // Stream流的使用
        List<Integer> categoryTypeList = upAllProducts.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategoryModel> categoryList= productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategoryModel category : categoryList) {
            ProductVO vo = new ProductVO();
            vo.setCategoryName(category.getCategoryName());
            vo.setCategoryType(category.getCategoryType());

            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfoModel productInfo : upAllProducts) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            vo.setProductInfoVoList(productInfoVoList);
            productVOList.add(vo);

        }

        ServerResponse serverResponse = ServerResponse.createBySuccessMessage("成功");
        serverResponse.setData(productVOList);

        return serverResponse;
    }
}
