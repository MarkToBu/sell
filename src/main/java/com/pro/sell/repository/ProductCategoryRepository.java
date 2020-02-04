package com.pro.sell.repository;


import com.pro.sell.model.ProductCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Administrator
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryModel, Integer>, JpaSpecificationExecutor<JpaRepository> {

    /**
     * @param types
     * @return models
     * findAllById
     *
     */
    List<ProductCategoryModel> findByCategoryTypeIn(List<Integer> types);

}
