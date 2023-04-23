package com.snh.pcs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
/**
 * Spring Security 기본설정 
 * @author hyuna
 *
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .csrf().disable();
	
	  http
	    .authorizeRequests()	//경로에 권한, 인증 설정을 한다는 선언
	      .antMatchers("/login/user").hasAnyRole("USER")	///api/user에 대한 요청은 USER권한을 가진 회원만 승인
	      .anyRequest().permitAll();
	
	  http
	    .formLogin()
	    	.loginPage("/login")  				//로그인 페이지 설정 
	        .loginProcessingUrl("/loginProc")	//Rest Api로 로그인 요청 URL 설정
	        .usernameParameter("loginId")		
	        .passwordParameter("password")
	        .successHandler(customAuthenticationSuccessHandler)		//로그인 성공 핸들러 
	        .failureHandler(customAuthenticationFailureHandler);	//로그인 실패 핸들러 
	    
	
	  http
	    .sessionManagement()
	      .maximumSessions(1)				//최대 허용 가능 세션 수 설정
	      .maxSessionsPreventsLogin(true); 	//동시로그인 설정
	    
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//로그인 요청시 인증 처리를 담당
		auth.authenticationProvider(customAuthenticationProvider);
	}

}