package com.pro.sell.repository;


import com.pro.sell.model.ProductInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Administrator
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfoModel, Integer>, JpaSpecificationExecutor<JpaRepository> {

}
