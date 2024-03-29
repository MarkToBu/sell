package com.pro.sell.service.impl;

import com.pro.sell.common.enums.ProductStatusEnum;
import com.pro.sell.common.enums.ResultEnum;
import com.pro.sell.common.exception.SellException;
import com.pro.sell.dto.CartDTO;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.repository.ProductInfoRepository;
import com.pro.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Administrator
 */
@Service
@CacheConfig(cacheNames = "productList")  //子域中不要再写cacheNames
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    @Cacheable(cacheNames = "productList", key = "123", condition = "#id.length() > 5", unless = "#result == null")  //key=#id spEl表达式
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
/*        Page<OrderMasterModel> all = orderMasterRepository.findAll(pageable);
        List<OrderMasterDTO> orderMasterDTOList = OrderMasterConverter.convert(all.getContent());

        return new PageImpl<>(orderMasterDTOList, pageable, all.getTotalElements());
 */
        return productInfoRepository.findAll(pageable);
    }

    @Override
    @CachePut(cacheNames = "productList", key = "123")
    public ProductInfoModel save(ProductInfoModel productInfoModel) {
        return productInfoRepository.save(productInfoModel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<CartDTO> cartDTOList) {
        cartDTOList.forEach(cartOne ->{
            ProductInfoModel productInfo = productInfoRepository.getOne(cartOne.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer lastStock = productInfo.getProductStock() + cartOne.getProductQuantity();

            // fixme 此处可能会有并发问题
            productInfo.setProductStock(lastStock);

            productInfoRepository.save(productInfo);
        });


    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {
        cartDTOList.forEach(cartOne ->{
            ProductInfoModel productInfo = productInfoRepository.getOne(cartOne.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer lastStock = productInfo.getProductStock() - cartOne.getProductQuantity();
            if(lastStock < 0){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // fixme 此处可能会有并发问题
            productInfo.setProductStock(lastStock);

            productInfoRepository.save(productInfo);
        });

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductInfoModel onSale(String productId) {
        ProductInfoModel one = productInfoRepository.getOne(productId);
        if(one == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(one.getProductStatusEnum() == ProductStatusEnum.UP){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        one.setProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoRepository.save(one);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductInfoModel offSale(String productId) {
        ProductInfoModel one = productInfoRepository.getOne(productId);
        if(one == null) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if(one.getProductStatusEnum() == ProductStatusEnum.DOWN){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        one.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return productInfoRepository.save(one);
    }
}
