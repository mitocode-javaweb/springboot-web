package com.mitocode.javaweb.mybatis.infraestructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mitocode.javaweb.mybatis.application.UsuarioFinderService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioFinderService usuarioFinderService;
	
	@GetMapping
	public void listarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioFinderService.findAll());
	}

}
