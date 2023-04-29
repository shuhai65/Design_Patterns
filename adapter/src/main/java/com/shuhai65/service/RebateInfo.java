package com.shuhai65.service;

import java.util.Date;

// 统⼀的MQ消息体

/**
 * MQ消息中会有多种多样的类型属性，虽然他们都有同样的值提供给使⽤⽅，但是如果都这样接⼊
 * 那么当MQ消息特别多时候就会很麻烦。
 * 所以在这个案例中我们定义了通⽤的MQ消息体，后续把所有接⼊进来的消息进⾏统⼀的处理。
 */
public class RebateInfo {

    private String userId;  // 用户ID
    private String bizId;   // 业务ID
    private Date bizTime;   // 业务时间
    private String desc;    // 业务描述

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = new Date(Long.parseLong("1591077840669"));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
