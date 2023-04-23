package com.snh.pcs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
/**
 * 인증 실패 사용되는 핸들
 * @author hyuna
 *
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Value("${BASE_URL}")
    private String baseUrl;
	
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(baseUrl+"login/fail");
    }

}