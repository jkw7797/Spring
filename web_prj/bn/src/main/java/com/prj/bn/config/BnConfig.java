package com.prj.bn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BnConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**")
			.addResourceLocations("classpath:/static/assets/img/");
		registry.addResourceHandler("/assets/demo/**")
		.addResourceLocations("classpath:/static/assets/demo/");
		registry.addResourceHandler("/css/**")
		.addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/js/**")
		.addResourceLocations("classpath:/static/js/");
		
		
		
	}
	

}
