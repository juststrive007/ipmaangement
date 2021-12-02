package com.example.ipmanagement.enums;

public enum IpUsedStatusEnum {
    /***/
    NOTUSED((byte)0,"未使用"),
    USD((byte)1,"已使用");

    private byte status;
    private String desc;
    IpUsedStatusEnum(byte status,String desc){
        this.status=status;
        this.desc = desc;
    }

    public byte getStatus(){return status;}

}
