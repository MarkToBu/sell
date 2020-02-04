package com.pro.sell.service.impl;



import com.pro.sell.model.ProductCategoryModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategoryModel one = productCategoryService.findOne(2);
        Assert.assertEquals(new Integer(2), one.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategoryModel> all = productCategoryService.findAll();
        Assert.assertNotEquals(0, all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategoryModel> byCategoryTypeIn = productCategoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0, byCategoryTypeIn.size());
    }

    @Test
    public void save() {
        ProductCategoryModel model = new ProductCategoryModel();
        model.setCategoryName("蔬菜");
        model.setCategoryType(8);

        productCategoryService.save(model);
        Assert.assertNotNull(model);

    }
}