package com.snh.pcs.security.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
/**
 * 인증 성공시 사용되는 핸들
 * @author hyuna
 *
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Value("${BASE_URL}")
    private String baseUrl;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60);
        response.sendRedirect(baseUrl+"login/success");
    }

}