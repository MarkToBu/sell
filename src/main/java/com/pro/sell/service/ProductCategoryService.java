package com.pro.sell.service;

import com.pro.sell.model.ProductCategoryModel;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ProductCategoryModel findOne(Integer id);

    /**
     * @return
     */
    List<ProductCategoryModel>  findAll();

    /**
     * 根据类型
     * @param types
     * @return
     */
    List<ProductCategoryModel> findByCategoryTypeIn(List<Integer> types);

    /**
     * 保存实体类
     * @param model
     * @return
     */
    ProductCategoryModel save(ProductCategoryModel model);

}
