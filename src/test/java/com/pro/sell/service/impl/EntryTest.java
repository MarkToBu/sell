package com.pro.sell.service.impl;

import com.pro.sell.dto.OrderMasterDTO;
import com.pro.sell.service.OrderService;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EntryTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptors() {

        System.out.println(stringEncryptor.encrypt("Z8E@2&cw"));
    }
}