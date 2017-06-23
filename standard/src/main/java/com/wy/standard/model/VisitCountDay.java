package com.wy.standard.model;

import java.util.Date;

public class VisitCountDay {
    private Integer id;

    private String channel;

    private Integer source;

    private Integer ipNum;

    private Integer totalNum;

    private Integer baseNum;

    private Date addTime;

    private Date countTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getIpNum() {
        return ipNum;
    }

    public void setIpNum(Integer ipNum) {
        this.ipNum = ipNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getBaseNum() {
        return baseNum;
    }

    public void setBaseNum(Integer baseNum) {
        this.baseNum = baseNum;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getCountTime() {
        return countTime;
    }

    public void setCountTime(Date countTime) {
        this.countTime = countTime;
    }
}