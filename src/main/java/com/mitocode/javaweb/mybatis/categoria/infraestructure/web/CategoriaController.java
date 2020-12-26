package com.mitocode.javaweb.mybatis.categoria.infraestructure.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaCreateService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaDeleteService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaUpdateService;
import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.exception.CategoriaNotFoundException;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	private CategoriaFinderService categoriaFinderService;
	
	@Autowired
	private CategoriaCreateService categoriaCreateService;
	
	@Autowired
	private CategoriaUpdateService categoriaUpdateService;

	@Autowired
	private CategoriaDeleteService categoriaDeleteService;
	
	@Autowired
	private CategoriaDtoMapper categoriaDtoMapper;
	
	@ModelAttribute("modulo")
	public String modulo() {
		return "categoria";
	}
	
	@GetMapping({ "", "/" })
	public String listarCategorias(ModelMap model) {
		model.put("categorias", categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll(), new CycleAvoidingMappingContext()));
		model.put("pageLength", 4);
		
		model.put("opcion", "listar");

		return "categoria/categorias";
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
	public String nuevaCategoria(ModelMap model, CategoriaForm categoriaForm) {
		model.put("opcion", "crear");
		
		return "categoria/categoria-nuevo";
	}
	
	@PostMapping("/registrar")
	public String registrarCategoria(@Valid CategoriaForm categoriaForm, BindingResult bindingResult, 
			ModelMap model, RedirectAttributes redirectAttributes) throws IOException {
		String resultPage = "categoria/categoria-nuevo";
		
		if(!bindingResult.hasErrors()) {
			Categoria categoria = new Categoria();
			categoria.setNombre(categoriaForm.getNombre());
			categoria.setDescripcion(categoriaForm.getDescripcion());
			if(!categoriaForm.getImagen().isEmpty()) {
				categoria.setImagen(categoriaForm.getImagen().getBytes());
			}
			
			int filas = categoriaCreateService.save(categoria);
			
			if(filas > 0) {
				redirectAttributes.addFlashAttribute("categoriaCreateMessage", true);
				resultPage = "redirect:/categorias";
			}else {
				model.put("categoriaCreateErrorMessage", true);
			}
		}
		
		return resultPage;
	}
	
	@GetMapping("/{id}/editar")
	public String editarCategoria(@PathVariable Integer id, CategoriaForm categoriaForm, ModelMap model) throws CategoriaNotFoundException {
		Optional<Categoria> oCategoria = categoriaFinderService.findById(id);
		
		if(oCategoria.isPresent()) {
			Categoria categoria = oCategoria.get();
			categoriaForm.setId(categoria.getId());
			categoriaForm.setNombre(categoria.getNombre());
			categoriaForm.setDescripcion(categoria.getDescripcion());
			categoriaForm.setEstado(categoria.getEstado());
		}
		
		return "categoria/categoria-editar";
	}
	
	@PostMapping("/{id}/editar")
	public String actualizarCategoria(@PathVariable Integer id, @Valid CategoriaForm categoriaForm, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, ModelMap model) throws IOException {
		
		log.debug("categoriaForm: " + categoriaForm.toString());
		
		String resultPage = "categoria/categoria-nuevo";
		
		if(!bindingResult.hasErrors()) {
			Categoria categoria = new Categoria();
			categoria.setId(id);
			categoria.setNombre(categoriaForm.getNombre());
			categoria.setDescripcion(categoriaForm.getDescripcion());
			if(!categoriaForm.getImagen().isEmpty()) {
				categoria.setImagen(categoriaForm.getImagen().getBytes());
			}
			categoria.setEstado(categoriaForm.getEstado());
			
			log.debug("categoria: " + categoria.toString());
			
			int filas = categoriaUpdateService.update(categoria);
			
			if(filas > 0) {
				redirectAttributes.addFlashAttribute("categoriaEditMessage", true);
				resultPage = "redirect:/categorias";
			}else {
				model.put("categoriaEditErrorMessage", true);
			}
		}
		
		return resultPage;
	}
	
	@Operation(hidden = true)
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<EliminarResponse> eliminarCategoria(@PathVariable Integer id) {
		int row = categoriaDeleteService.delete(id);
		ResponseEntity<EliminarResponse> response = null;
		
		if(row > 0) {
			response = new ResponseEntity<EliminarResponse>(new EliminarResponse("Se eliminó correctamente"), HttpStatus.OK);
		} else {
			response = new ResponseEntity<EliminarResponse>(new EliminarResponse("Se eliminó correctamente"), HttpStatus.EXPECTATION_FAILED);
		}
		
		return response;
	}
}



class EliminarResponse {
	private String message;

	public EliminarResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
