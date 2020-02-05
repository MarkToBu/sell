package com.pro.sell.service.impl;

import com.pro.sell.common.ProductStatusEnum;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.repository.ProductInfoRepository;
import com.pro.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfoModel findOne(String id) {
        return productInfoRepository.getOne(id);
    }

    @Override
    public List<ProductInfoModel> findAll() {
        return productInfoRepository.findAll();
    }

    @Override
    public List<ProductInfoModel> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfoModel> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfoModel save(ProductInfoModel productInfoModel) {
        return null;
    }
}
