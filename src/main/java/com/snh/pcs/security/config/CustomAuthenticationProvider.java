package com.snh.pcs.security.config;

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
		
		if(!passwordEncoder.matches(reqPassword, user.getPassword())) throw new BadCredentialsException("Not Found User");
		
		return new UsernamePasswordAuthenticationToken(user, reqPassword, user.getAuthorities());
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}