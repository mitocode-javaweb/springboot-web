package com.mitocode.javaweb.mybatis.categoria.infraestructure.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.exception.CategoriaNotFoundException;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	private CategoriaFinderService categoriaFinderService;
	
	@Autowired
	private CategoriaDtoMapper categoriaDtoMapper;
	
	@GetMapping({"/", ""})
	public String obtenerCategorias(ModelMap model) {
		model.put("categorias", categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll()));
		
		return "categoria/categorias-vista";
	}
	
	@GetMapping("/editar")
	public String editarCategorias(ModelMap model) {
		model.put("categorias", categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll()));
		
		return "categoria/categorias-editar";
	}
	
	
	@GetMapping("/{id}/imagen")
	public void obtenerImagen(@PathVariable Integer id, HttpServletResponse response) throws CategoriaNotFoundException, IOException {
		Optional<Categoria> categoria = categoriaFinderService.findById(id);
		
		if(categoria.isPresent()) {
			response.setContentType("image/jpg");
			
			InputStream is = new ByteArrayInputStream(categoria.get().getImagen());
			IOUtils.copy(is, response.getOutputStream());
		}
	}
	
	@GetMapping("/nuevo")
	public String obtenerCategorias2() {
		return "";
	}
	
	@PostMapping("/registrar")
	public String obtenerCategorias3() {
		return "";
	}
	
	@PostMapping("/{id}")
	public String obtenerCategorias4() {
		return "";
	}
	
	@DeleteMapping("/{id}")
	public String obtenerCategorias5() {
		return "";
	}
}
