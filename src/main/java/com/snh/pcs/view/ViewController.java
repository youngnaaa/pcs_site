package com.snh.pcs.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ViewController {

	@RequestMapping("/login")
    public String loginView() {
        return "/views/login/login.html";
    }
}