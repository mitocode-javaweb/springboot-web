package com.mitocode.javaweb.mybatis.shared.infraestructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvnConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		WebMvcConfigurer.super.addViewControllers(registry);
		
//		registry.addViewController("/").setViewName("redirect:/categorias");
//		registry.addViewController("/home").setViewName("redirect:/categorias");
//		registry.addViewController("/login").setViewName("login/login");
		registry.addViewController("/login/forgot-password").setViewName("login/forgot-password");
		registry.addViewController("/login/register").setViewName("login/register");
	}
}
