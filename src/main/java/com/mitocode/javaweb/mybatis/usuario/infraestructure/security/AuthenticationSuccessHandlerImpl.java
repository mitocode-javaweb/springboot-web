package com.mitocode.javaweb.mybatis.usuario.infraestructure.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.mitocode.javaweb.mybatis.shared.domain.SessionKeys;
import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;
import com.mitocode.javaweb.mybatis.usuario.infraestructure.dto.UsuarioDtoMapper;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private HttpSession session;
	
	private UsuarioFinderService usuarioFinderService;
	
	private UsuarioDtoMapper usuarioDtoMapper;
	
	enum ROLES {
		ADMIN, USER;
	}

	public AuthenticationSuccessHandlerImpl(UsuarioFinderService usuarioFinderService,  UsuarioDtoMapper usuarioDtoMapper) {
		this.usuarioFinderService = usuarioFinderService;
		this.usuarioDtoMapper = usuarioDtoMapper;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
		
		String username =  authentication.getName();
		String url = "/login";
		
		Usuario usuario;
		try {
			usuario = usuarioFinderService.findByUsuario(username);
			session.setAttribute(SessionKeys.LOGIN_USUARIO, usuarioDtoMapper.toUsuarioDto(usuario));
			
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				String rol = grantedAuthority.getAuthority();
				if(ROLES.valueOf(rol) == ROLES.ADMIN) {
					url = "/categorias";
				} else if(ROLES.valueOf(rol) == ROLES.USER) {
					url = "/home";
				}
			}
		} catch (UsuarioNotFoundException e) {
		}

		redirectStrategy.sendRedirect(request, response, url);
	}

}
