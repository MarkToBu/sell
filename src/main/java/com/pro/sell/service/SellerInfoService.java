package com.pro.sell.service;

import com.pro.sell.model.SellerInfoModel;

/**
 * 卖家信息
 * @author Administrator
 */
public interface SellerInfoService {

    /**
     * 通过openid查询
     * @param openId
     * @return
     */
    SellerInfoModel findByOpenId(String openId);

    /**
     * 保存用户信息
     * @param sellerInfoModel
     * @return
     */
    SellerInfoModel save(SellerInfoModel sellerInfoModel);
}
