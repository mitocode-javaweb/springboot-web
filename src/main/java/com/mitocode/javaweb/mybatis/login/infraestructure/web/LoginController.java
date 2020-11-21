package com.mitocode.javaweb.mybatis.login.infraestructure.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mitocode.javaweb.mybatis.login.application.LoginService;
import com.mitocode.javaweb.mybatis.login.domain.exception.BadCredentialsException;

@Controller
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String login(LoginForm loginForm) {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String iniciarSesion(LoginForm loginForm, ModelMap modelMap) {
		String message = null;
		String pageResult = "login/login";
		
		log.info(loginForm.toString());
		
		try {
			loginService.validarUsuarioClave(loginForm.getUsername(), loginForm.getPassword());
			
			pageResult = "home";
		} catch (BadCredentialsException e) {
			message = "error";
		}
		
		modelMap.put("message", message);
		
		return pageResult;
	}
}
