package com.wy.standard.model;

import java.util.Date;
import java.util.Map;

public class VisitChannel {
	private Date date;
	private Map<String, VisitCount> channelMap ;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Map<String, VisitCount> getChannelMap() {
		return channelMap;
	}
	public void setChannelMap(Map<String, VisitCount> channelMap) {
		this.channelMap = channelMap;
	}
	
}
