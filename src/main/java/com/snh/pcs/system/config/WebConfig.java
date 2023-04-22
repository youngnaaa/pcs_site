package com.snh.pcs.system.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/views").addResourceLocations("classpath:/static/views/").setCachePeriod(60 * 60 * 24 * 365); 
		
		/* addResourceHandler에 명시되어 호출하는 자원은 addResourceLocations 폴더 아래에서 찾는다. */ 
        registry.addResourceHandler("/web/bootstrap/css/**").addResourceLocations("classpath:/web/bootstrap/css/").setCachePeriod(60 * 60 * 24 * 365); 
        registry.addResourceHandler("/web/bootstrap/js/**").addResourceLocations("classpath:/web/bootstrap/js/").setCachePeriod(60 * 60 * 24 * 365); 
        registry.addResourceHandler("/web/js/**").addResourceLocations("classpath:/web/js/").setCachePeriod(60 * 60 * 24 * 365); 
        registry.addResourceHandler("/web/css/**").addResourceLocations("classpath:/web/css/").setCachePeriod(60 * 60 * 24 * 365); 
        registry.addResourceHandler("/web/img/**").addResourceLocations("classpath:/web/img/").setCachePeriod(60 * 60 * 24 * 365); 
        registry.addResourceHandler("/web/template/**").addResourceLocations("classpath:/web/template/").setCachePeriod(60 * 60 * 24 * 365); 
	}
	
	@Bean
	public MessageSource messageSource() {
	  ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
	  source.setBasename("classpath:/messages/messages");
	  source.setDefaultEncoding("UTF-8");
	  source.setUseCodeAsDefaultMessage(true);
	  source.setDefaultLocale(Locale.KOREA);
	  return source;
	}
	
	@Bean
	public MessageSource validationMessageSource() {
	  ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	  messageSource.setBasename("classpath:/messages/validation");
	  messageSource.setDefaultEncoding("UTF-8");
	  return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	  LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	  bean.setValidationMessageSource(messageSource());
	  return bean;
	}
}