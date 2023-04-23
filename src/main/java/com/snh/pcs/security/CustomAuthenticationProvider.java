package com.snh.pcs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.snh.pcs.user.model.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
/**
 * 로그인 인증 검증
 * @author hyuna
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomLoadUserByUsername customLoadUserByUsername;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println(">> getName :"+authentication.getName().toString());
		UserDto user = (UserDto) customLoadUserByUsername.loadUserByUsername(authentication.getName().toString());

		
		String reqPassword = authentication.getCredentials().toString();
		System.out.println(">> login req ID :"+authentication.getName());
		System.out.println(">> login req Password :"+reqPassword);

		System.out.println(">> user res Id :"+user.getUsername());
		System.out.println(">> user res Password :"+user.getPassword());
		
		// req패스워드와 DB패스워드 불일치시 실패/성공 핸들러 이동 
		if(!passwordEncoder.matches(reqPassword, user.getPassword())) throw new BadCredentialsException("Not Found User");
		
		return new UsernamePasswordAuthenticationToken(user, reqPassword, user.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}