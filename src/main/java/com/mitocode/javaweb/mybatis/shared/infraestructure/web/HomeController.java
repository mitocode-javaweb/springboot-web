package com.mitocode.javaweb.mybatis.shared.infraestructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@Controller
public class HomeController {

	@Autowired
	private CategoriaFinderService categoriaFinderService;

	@Autowired
	private CategoriaDtoMapper categoriaDtoMapper;
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "home";
	}

	@GetMapping({ "", "/", "/home" })
	public String home(ModelMap model) {
		model.put("categorias", categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll(), new CycleAvoidingMappingContext()));
		
		model.put("opcion", "home");
		
		return "home/home";
	}
}
