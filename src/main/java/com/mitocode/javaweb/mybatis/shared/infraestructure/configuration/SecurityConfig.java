package com.mitocode.javaweb.mybatis.shared.infraestructure.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.mitocode.javaweb.mybatis.shared.domain.SessionKeys;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.security.UserSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserSecurityService userSecurityService;
	
	@Autowired
	private AuthenticationSuccessHandler authenticationSuccessHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//				.withUser("user").password(passwordEncoder.encode("12345")).roles("USER")
//				.and()
//				.withUser("admin").password(passwordEncoder.encode("123")).roles("ADMIN");
		
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/home", "/").permitAll()
				.antMatchers("/dist/**", "/plugins/**").permitAll()
				.antMatchers("/categorias/**/imagen").permitAll()
				.antMatchers("/categorias/**").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
			.csrf().disable().headers().frameOptions().disable()
		.and()
			.formLogin()
				.loginPage("/login")
//				.defaultSuccessUrl("/home", true)
				.successHandler(authenticationSuccessHandler)
				.permitAll()
		.and()
			.logout()
//				.logoutUrl("/logout")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.addLogoutHandler(
						(request, response, authentication) -> {
							request.getSession().removeAttribute(SessionKeys.LOGIN_USUARIO);
						})
				.permitAll();
		
	}
	
	
}
