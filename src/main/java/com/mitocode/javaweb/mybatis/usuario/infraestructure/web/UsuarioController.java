package com.mitocode.javaweb.mybatis.usuario.infraestructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mitocode.javaweb.mybatis.usuario.application.UsuarioFinderService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioFinderService usuarioFinderService;
	
	@GetMapping("/listar")
	public void listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioFinderService.findAll());
	}

}
