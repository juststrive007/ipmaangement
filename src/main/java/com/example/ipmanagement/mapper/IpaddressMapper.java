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

    /**
     * 获取起始IP地址
     * @return
     */
    IpInfo getStartIp();

    /**
     * 获取结尾IP地址
     * @return
     */
    IpInfo getEndIp();

    /**
     * 修改IP地址的使用状态
     */
    Integer updateIp(IpInfo ipInfo);
}
