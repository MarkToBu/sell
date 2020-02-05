package com.pro.sell.repository;


import com.pro.sell.model.ProductInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoModel, String>, JpaSpecificationExecutor<JpaRepository> {

    /**
     * 根据状态查询商品
     * @param productStatus
     * @return
     */
    List<ProductInfoModel> findByProductStatus(Integer productStatus);

}
