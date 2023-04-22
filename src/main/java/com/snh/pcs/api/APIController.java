package com.snh.pcs.api;

import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class APIController {

	@RequestMapping(value = "/",method = {RequestMethod.GET, RequestMethod.POST})
	public String main(@RequestParam HashMap<String,Object> param, Model model) throws Exception {

		return "/WEB-INF/views/login/login.jsp";
	}
}
