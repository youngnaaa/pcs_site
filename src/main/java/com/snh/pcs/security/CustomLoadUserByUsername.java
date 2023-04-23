package com.snh.pcs.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.snh.pcs.user.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
/**
 * 고객정보 가져오기 
 * @author hyuna
 *
 */
public class CustomLoadUserByUsername implements UserDetailsService{

	@Value("${SERVER}")
    private String server;
	
    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
    	
    	UserDto user = new UserDto();
    	
    	//DB로 유저정보 가져오기 
        //UserDto user = userRepository.getOne(loginId);
    	
    	//로컬환경의 경우 테스트 데이터 강제 셋
    	if("local".equals(server)) {
        	//TODO 테스트 데이터 셋팅 ===== S
        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        	String encoded = passwordEncoder.encode("1234");
        	
        	user.setUsername("local");
        	user.setPassword(encoded);
        	user.setRole("USER");
        	//TODO 테스트 데이터 셋팅 ===== E
    	}
    	
        if(user == null)     throw new UsernameNotFoundException("Not Found User");
        return user;
    }

}
