package com.example.ipmanagement.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IpmanageServiceTest {
    @Autowired
    IpManageService ipManageService;


    @Test
    public void generateIpsTest(){
        ipManageService.generateIps("10.38.1.100","10.38.1.110");
    }
}
