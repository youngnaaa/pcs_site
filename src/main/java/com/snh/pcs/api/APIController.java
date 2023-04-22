package com.snh.pcs.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class APIController {
	
	@GetMapping("/main")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");

        return "views/login.html";
    }

}
