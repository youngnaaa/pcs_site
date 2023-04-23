package com.snh.pcs.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.snh.pcs.user.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoadUserByUsername implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    	//DB로 유저정보 가져오기 
        //UserDto user = userRepository.getOne(loginId);
    	
    	
    	//TODO 테스트 데이터 셋팅 ===== S
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String encoded = passwordEncoder.encode("1234");
    	
    	UserDto user = new UserDto();
    	user.setUsername("local");
    	user.setPassword(encoded);
    	user.setRole("USER");
    	//TODO 테스트 데이터 셋팅 ===== E
    	
        if(user == null)     throw new UsernameNotFoundException("Not Found User");
        return user;
    }

}
