package com.mitocode.javaweb.mybatis.usuario.infraestructure.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;
import com.mitocode.javaweb.mybatis.usuario.domain.Usuario;
import com.mitocode.javaweb.mybatis.usuario.domain.exception.UsuarioNotFoundException;

@Service
public class UserSecurityService implements UserDetailsService {

	private UsuarioFinderService usuarioFinderService;
	
	public UserSecurityService(UsuarioFinderService usuarioFinderService) {
		this.usuarioFinderService = usuarioFinderService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		
		try {
			Usuario usuario = usuarioFinderService.findByUsuario(username);
			
			List<GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority(usuario.getRol()));
			
			userDetails = new User(username, usuario.getClaveUsuario(), roles);
		} catch (UsuarioNotFoundException e) {
			throw new UsernameNotFoundException("Usuario no existe");
		}
		
		return userDetails;
	}

}
