package com.wy.standard.model;

import java.util.Date;

public class VisitCountDayBase {
    private Integer id;

    private String channel;

    private Integer source;

    private String goalPage;

    private String enterChannel;

    private Integer uvNum;

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

    public String getGoalPage() {
        return goalPage;
    }

    public void setGoalPage(String goalPage) {
        this.goalPage = goalPage == null ? null : goalPage.trim();
    }

    public String getEnterChannel() {
        return enterChannel;
    }

    public void setEnterChannel(String enterChannel) {
        this.enterChannel = enterChannel == null ? null : enterChannel.trim();
    }

    public Integer getUvNum() {
        return uvNum;
    }

    public void setUvNum(Integer uvNum) {
        this.uvNum = uvNum;
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