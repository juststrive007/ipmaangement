package com.example.ipmanagement.entity;

import lombok.Data;

@Data
public class IpInfo {
    private Integer id;
    private String ipaddr;
    private byte used;

    public IpInfo(String ipaddr, byte used) {
        this.ipaddr = ipaddr;
        this.used = used;
    }

    public IpInfo() {
    }
}
