package com.pro.sell.service;

import com.pro.sell.dto.CartDTO;
import com.pro.sell.model.ProductInfoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 产品服务
 * @author Administrator
 */
public interface ProductInfoService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    ProductInfoModel findOne(String id);

    /**
     * 查询全部
     * @return
     */
    List<ProductInfoModel> findAll();


    /**
     * 查找上架的
     * @return
     */
    List<ProductInfoModel> findUpAll();

    /**
     * 分页查全部
     * @param pageable
     * @return
     */
    Page<ProductInfoModel> findAll(Pageable pageable);

    /**
     * 保存
     * @param productInfoModel
     * @return
     */
    ProductInfoModel save(ProductInfoModel productInfoModel);

    /**
     *加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    //todo 减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
