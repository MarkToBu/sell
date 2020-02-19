package com.pro.sell.service.impl;

import com.pro.sell.model.SellerInfoModel;
import com.pro.sell.repository.SellerInfoRepository;
import com.pro.sell.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */

@Service
@Slf4j
public class SellerServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfoModel findByOpenId(String openId) {
        return sellerInfoRepository.findByOpenid(openId);
    }

    @Override
    public SellerInfoModel save(SellerInfoModel sellerInfoModel) {
        return sellerInfoRepository.save(sellerInfoModel);
    }
}
