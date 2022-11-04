package com.pro.sell.service.impl;

import com.lly835.bestpay.utils.JsonUtil;
import com.pro.sell.model.ProductInfoModel;
import com.pro.sell.service.ProductInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    ProductInfoService productInfoService;

    @Test
    public void findOne() {
        ProductInfoModel one = productInfoService.findOne("297e1d767010c794017010c7a5710000");
        System.out.println(JsonUtil.toJson(one));

    }
}