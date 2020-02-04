package com.pro.sell.repository;


import com.pro.sell.model.ProductCategoryModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    @Transactional
    public void opeProductCategory(){
        /*
        ProductCategoryModel model = new ProductCategoryModel();
        model.setCategoryName("肉类");
        model.setCategoryType(1);

        productCategoryRepository.save(model);
         */
        ProductCategoryModel model = productCategoryRepository.findById(2).get();
        System.out.println(model);
        model.setCategoryName("瘦肉类");

        ProductCategoryModel result = productCategoryRepository.save(model);
        Assert.assertNotNull(result);
        Assert.assertNotEquals(null,result);

    }

    @Test
    public void testFind(){
        List<ProductCategoryModel> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1, 3, 4));

        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }

}