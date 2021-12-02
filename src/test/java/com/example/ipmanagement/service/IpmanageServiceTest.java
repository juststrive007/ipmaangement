package com.example.ipmanagement.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IpmanageServiceTest {
    @Autowired
    IpManageService ipManageService;


    @Test
    public void generateIpsTest(){
        ipManageService.generateIps("10.38.1.100","10.38.1.110");
    }

    @Test
    public void getIp(){
        String ipaddr = ipManageService.getIp();
        System.out.println(ipaddr);
    }

    @Test
    public void getIps(){
        List<String> ips = ipManageService.getIps(3);
        System.out.println(ips);
    }

    @Test
    public void releaseIp(){
        boolean status = ipManageService.release("10.38.1.100");
        System.out.println(status);
    }
}

