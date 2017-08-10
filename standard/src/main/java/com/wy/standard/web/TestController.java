package com.wy.standard.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wy.sequence.service.SequenceService;

@Controller
public class TestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SequenceService sequenceService;
	@RequestMapping("/hello")
	public ModelAndView hello(){
		
		logger.debug("debug");
		logger.info("info");
		logger.error("error");
		logger.warn("warn");
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("a", "aaa");
		model.put("b", sequenceService.getSequence());
		return new ModelAndView("hello",model);
	}
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		
		for(int i =0;i<10000;i++){
			System.out.println(sequenceService.getSequence(i));
		}
		return "";
	}
}
