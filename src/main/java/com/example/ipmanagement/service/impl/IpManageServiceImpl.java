package com.example.ipmanagement.service.impl;

import com.example.ipmanagement.entity.IpInfo;
import com.example.ipmanagement.mapper.IpaddressMapper;
import com.example.ipmanagement.service.IpManageService;
import com.example.ipmanagement.service.ex.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //TODO 检查是否需要添加，查询开头与末尾
        for(int i =startNum ;i<endNum+1;i++){
            String ipaddr = startIpHead+i;
            ipaddressMapper.insert(new IpInfo(ipaddr,(byte) 0));
        }


        return null;
    }
}
