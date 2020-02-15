package com.pro.sell.service.impl;

import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.service.OrderService;
import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    public void findList() {
        Pageable pageable = PageRequest.of(0, 2);
        Page<OrderMasterDTO> list = orderService.findList(pageable);
        Assert.assertNotEquals(0, list.getTotalElements());
        Assert.assertTrue("数量大于o", list.getTotalElements()> 0);
    }
}