package com.example.ipmanagement.mapper;

import com.example.ipmanagement.entity.IpInfo;
import org.springframework.stereotype.Component;

/**
 * 处理IP数据增删改查的持久层接口
 */
@Component
public interface IpaddressMapper {

    Integer insert(IpInfo ipInfo);

    Integer delete();

    /**
     * 获取一个未使用的IP地址
     * @return
     */
    IpInfo getIp();

    IpInfo getStartIp();

    IpInfo getEndIp();
}
