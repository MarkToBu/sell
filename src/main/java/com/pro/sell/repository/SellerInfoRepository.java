package com.pro.sell.repository;


import com.pro.sell.model.OrderDetailModel;
import com.pro.sell.model.SellerInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author Administrator
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfoModel, String>, JpaSpecificationExecutor<SellerInfoModel> {

    /**
     * 根据订单id 查询订单
     * @param openId
     * @return
     */
    SellerInfoModel findByOpenid(String openId);

}
