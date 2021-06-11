package com.product.grabmarket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
			.addResourceHandler("/image/**")
			.addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/css/**")
		.addResourceLocations("classpath:/static/css/");
		
		
		
	}
	

}
