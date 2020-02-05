package com.pro.sell.repository;

import com.pro.sell.model.ProductInfoModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void testSave() {
        ProductInfoModel productInfoModel = new ProductInfoModel();
//        productInfoModel.setProductId("aaaaaa");
        productInfoModel.setProductPrice(new BigDecimal("2.5"));
        productInfoModel.setProductName("月饼");
        productInfoModel.setProductStock(100);
        productInfoModel.setProductDescription("nice");
        productInfoModel.setProductIcon("http://nice.jpg");
        productInfoModel.setProductStatus(0);
        productInfoModel.setCategoryType(2);

       Assert.assertNotNull(productInfoRepository.save(productInfoModel));

    }

    @Test
    public void findByProductStatus() {
       Assert.assertNotEquals(0,productInfoRepository.findByProductStatus(0).size());
    }
}