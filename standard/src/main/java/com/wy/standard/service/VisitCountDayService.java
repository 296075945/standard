package com.wy.standard.service;

import java.util.List;
import java.util.Map;

import com.wy.standard.model.VisitChannel;
import com.wy.standard.model.VisitCount;
import com.wy.standard.model.VisitCountDay;

public interface VisitCountDayService {
	List<VisitCountDay> getList(Map<String, Object> modal);
	
	List<VisitChannel> getVisitCount(Map<String, Object> modal);
}
