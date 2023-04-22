package com.snh.pcs.view;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.snh.pcs.user.model.UserDTO;
import com.snh.pcs.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final UserRepository userRepository = null;


    @RequestMapping("/login")
    String loginView() {
        return "login";
    }

    @RequestMapping("/success")
    String successView() {
        return "success";
    }

    @RequestMapping("/fail")
    String failView() {
        return "fail";
    }

    @RequestMapping("/my")
    ModelAndView myView(Authentication authentication) {
        /*
    	UserDTO userDTO = Optional.ofNullable(userRepository.findByEmail(authentication.getName())
        		.map(u -> UserDTO.builder().id(u.getId()).email(u.getEmail()).password(u.getPassword()).build())
        		.orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다.")));
		*/
    	
        ModelAndView modelAndView = new ModelAndView("/my");
        //modelAndView.addObject("userDTO", userDTO);

        return modelAndView;
    }

	private UserDTO UserDTO() {
		// TODO Auto-generated method stub
		return null;
	}

}