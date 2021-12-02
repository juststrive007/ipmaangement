package com.example.ipmanagement.service;

import java.util.List;

public interface IpManageService {
    Boolean generateIps(String startIp, String endIp);
    String getIp();
    List<String> getIps(int num);
    Boolean release(String ipaddr);
}
