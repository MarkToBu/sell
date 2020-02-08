package com.pro.sell.repository;


import com.pro.sell.model.OrderMasterModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Administrator
 */
public interface OrderMasterRepository extends JpaRepository<OrderMasterModel, String>, JpaSpecificationExecutor<OrderMasterModel> {

    /**
     * 根据openid查询订单
     * @param buyerOpenId
     * @param pageable
     * @return
     */
    Page<OrderMasterModel> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
