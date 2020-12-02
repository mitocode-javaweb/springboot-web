package com.mitocode.javaweb.mybatis.shared.infraestructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;

@Controller
public class HomeController {

	@Autowired
	private CategoriaFinderService categoriaFinderService;

	@Autowired
	private CategoriaDtoMapper categoriaDtoMapper;

	@GetMapping({ "", "/", "/home" })
	public String home(ModelMap model) {
		model.put("categorias", categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll()));

		return "home/home";
	}
}
