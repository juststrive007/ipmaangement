package com.example.ipmanagement.service.impl;

import com.example.ipmanagement.entity.IpInfo;
import com.example.ipmanagement.enums.IpUsedStatusEnum;
import com.example.ipmanagement.mapper.IpaddressMapper;
import com.example.ipmanagement.service.IpManageService;
import com.example.ipmanagement.service.ex.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IpManageServiceImpl implements IpManageService {
@Autowired
IpaddressMapper ipaddressMapper;

    @Override
    public Boolean generateIps(String startIp, String endIp) {
        if(startIp==null || endIp==null){
            throw new BaseException("ipaddr is null");
        }
        int num = startIp.lastIndexOf(".")+1;
        int startNum  = Integer.parseInt( startIp.substring(num) );
        String startIpHead = startIp.substring(0,num);

        num = endIp.lastIndexOf(".")+1;
        int endNum = Integer.parseInt( endIp.substring(num) ) ;
        String endIpHead = startIp.substring(0,num);

        if((startNum) > endNum ){
            throw new BaseException("startip > endIP");
        }
        if(!startIpHead.equals(endIpHead)){
            throw new BaseException("startip and endip not in the same subnet");
        }

        //检查是否需要添加，查询开头与末尾
        String dbStartIp = ipaddressMapper.getStartIp().getIpaddr();
        String dbEndIp = ipaddressMapper.getEndIp().getIpaddr();
        if(!startIp.equals(dbStartIp)  || !endIp.equals(dbEndIp) ) {
            ipaddressMapper.delete();
            for (int i = startNum; i < endNum + 1; i++) {
                String ipaddr = startIpHead + i;
                ipaddressMapper.insert(new IpInfo(ipaddr,IpUsedStatusEnum.NOTUSED.getStatus()));
            }
        }
        return true;
    }

    @Override
    public String getIp() {
        //获取一个IP地址后将IP地址标注为已用
        IpInfo ipInfo =ipaddressMapper.getIp();
        if(ipInfo==null){
            throw new BaseException("no ip can use");
        }
        String ipaddr  = ipInfo.getIpaddr();
        ipaddressMapper.updateIp(new IpInfo(ipaddr,IpUsedStatusEnum.USD.getStatus()));
        return ipaddr;
    }

    @Override
    public List<String> getIps(int num) {
        List<String> ips = new ArrayList<>(num);
        try{
        for(int i =0;i<num;i++){
            String ipaddr = getIp();
            ips.add(ipaddr);
        }
        }catch (Exception e){
            for(String ip :ips){
                release(ip);
            }
            throw  new BaseException(e.getMessage());
        }
        return ips;
    }

    @Override
    public Boolean release(String ipaddr) {
        Integer changeLine = ipaddressMapper.updateIp(new IpInfo(ipaddr, IpUsedStatusEnum.NOTUSED.getStatus()));
        if (1 ==changeLine){
            return true;
        }
        return false;
    }
}
