package com.snh.pcs.login;


import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api")
@Slf4j
public class LoginController {

	/*
	@GetMapping("/login/success")
	public ResponseEntity notSesstion() {
		System.out.println("로그인 성공");
		Map<String,Object> map = new HashMap<>();
		map.put("result", 1);
		return new ResponseEntity(map, HttpStatus.OK);
	}
	@GetMapping("/login/fail")
	public ResponseEntity hello() {
		System.out.println("로그인 실패");
		Map<String,Object> map = new HashMap<>();
		map.put("result", 0);
		return new ResponseEntity(map, HttpStatus.OK);
	}*/

	@RequestMapping("/login/success")
    public String success() {
        return "/views/main.html";
    }
	
	@RequestMapping("/login/fail")
    public String fail() {
        return "/views/login/fail.html";
    }
	
	@GetMapping("/user")
	public String test(Principal user) {
		return "user만 접근";
	}

}