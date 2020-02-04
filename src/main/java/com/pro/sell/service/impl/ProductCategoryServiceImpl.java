package com.pro.sell.service.impl;

import com.pro.sell.model.ProductCategoryModel;
import com.pro.sell.repository.ProductCategoryRepository;
import com.pro.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryModel findOne(Integer id) {
        return productCategoryRepository.getOne(id);
    }

    @Override
    public List<ProductCategoryModel> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategoryModel> findByCategoryTypeIn(List<Integer> types) {
        return productCategoryRepository.findByCategoryTypeIn(types);
    }

    @Override
    public ProductCategoryModel save(ProductCategoryModel model) {
        return productCategoryRepository.save(model);
    }
}
