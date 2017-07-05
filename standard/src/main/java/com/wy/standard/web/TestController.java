package com.wy.standard.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public ModelAndView hello(){
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("a", "aaa");
		return new ModelAndView("hello",model);
	}
}
