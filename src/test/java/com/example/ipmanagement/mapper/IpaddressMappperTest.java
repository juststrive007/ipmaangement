package com.example.ipmanagement.mapper;

import com.example.ipmanagement.entity.IpInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IpaddressMappperTest {
    @Autowired
    IpaddressMapper ipaddressMapper;

    @Test
    public void insertTest(){
        IpInfo ipInfo = new IpInfo();
        ipInfo.setIpaddr("10.38.1.110");
        ipInfo.setUsed((byte) 0);
        ipaddressMapper.insert(ipInfo);
    }

    @Test
    public void deleteTest(){
        ipaddressMapper.delete();
    }

    @Test
    public void getIpTest(){
        System.out.println(ipaddressMapper.getIp());
    }

}
