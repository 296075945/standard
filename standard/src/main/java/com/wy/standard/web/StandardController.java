package com.wy.standard.web;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wy.standard.model.Standard;
import com.wy.standard.model.StandardTree;
import com.wy.standard.service.StandardService;
import com.wy.user.model.UserInfo;
import com.wy.user.service.UserInfoService;

@RestController
@EnableAutoConfiguration
public class StandardController {
	
	@Autowired
	StandardService standardService;
	
	@Autowired 
	UserInfoService userInfoService;
	
	@RequestMapping("/add")
	String list(@ModelAttribute Standard standard){
		standardService.save(standard);
		return "hello world";
	}
	@RequestMapping("/tree")
	@ResponseBody
	JSONPObject tree(@RequestParam(required=false) String callbackparam){
		
		Map<String, Object> modal = new HashMap<String, Object>();
		UserInfo userInfo =  userInfoService.getUserinfo(1);
		return new  JSONPObject(callbackparam,standardService.getTree(modal));
	}
}
