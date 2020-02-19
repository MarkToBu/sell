package com.pro.sell.service.impl;

import com.lly835.bestpay.utils.JsonUtil;
import com.pro.sell.model.SellerInfoModel;
import com.pro.sell.service.SellerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {

    @Autowired
    SellerInfoService sellerInfoService;

    public String openId = "111";


    @Test
    public void save() {
//        SellerInfoModel sellerInfoModel = new SellerInfoModel().builder().openid(openId).password("111")
//                .username("test").createTime(null).updateTime(null).build();
        SellerInfoModel sellerInfoModel = new SellerInfoModel();
        sellerInfoModel.setOpenid(openId);
        sellerInfoModel.setPassword("111");
        sellerInfoModel.setUsername("aaa");
        log.info(JsonUtil.toJson(sellerInfoService.save(sellerInfoModel)));
    }
    @Test
    public void findByOpenId() {
        SellerInfoModel byOpenId = sellerInfoService.findByOpenId(openId);
        log.info(JsonUtil.toJson(byOpenId));
    }


}