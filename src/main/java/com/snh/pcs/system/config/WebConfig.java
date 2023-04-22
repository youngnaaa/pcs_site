package com.snh.pcs.system.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		/* addResourceHandler에 명시되어 호출하는 자원은 addResourceLocations 폴더 아래에서 찾는다. */ 
	    registry.addResourceHandler("/bootstrap/css/**").addResourceLocations("classpath:/static/bootstrap/css/").setCachePeriod(60 * 60 * 24 * 365); 
	    registry.addResourceHandler("/bootstrap/js/**").addResourceLocations("classpath:/static/bootstrap/js/").setCachePeriod(60 * 60 * 24 * 365); 
	    registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(60 * 60 * 24 * 365); 
	    registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60 * 60 * 24 * 365); 
	    registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/").setCachePeriod(60 * 60 * 24 * 365); 
	    registry.addResourceHandler("/views/**").addResourceLocations("classpath:/templates/views/").setCachePeriod(60 * 60 * 24 * 365); 
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