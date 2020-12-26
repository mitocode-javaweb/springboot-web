package com.mitocode.javaweb.mybatis.categoria.infraestructure.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mitocode.javaweb.mybatis.categoria.application.CategoriaCreateService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaDeleteService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaFinderService;
import com.mitocode.javaweb.mybatis.categoria.application.CategoriaUpdateService;
import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.categoria.domain.exception.CategoriaNotFoundException;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDto;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDtoMapper;
import com.mitocode.javaweb.mybatis.shared.infraestructure.dto.CycleAvoidingMappingContext;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaRestController {

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
	
	
	@GetMapping
	public List<CategoriaDto> listarCategorias(HttpServletRequest request) {
		List<CategoriaDto> lista = categoriaDtoMapper.toCategoriaDtos(categoriaFinderService.findAll(), new CycleAvoidingMappingContext());
		
		lista.forEach(dto -> dto.setImagenUrl(
				request.getRequestURL().toString().concat("/").concat(dto.getId().toString()).concat("/image")));
		
		return lista;
	}
	
	@GetMapping(value = "/{id}/image",  produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable String id) throws NumberFormatException, CategoriaNotFoundException {
	    Optional<Categoria> categoria = categoriaFinderService.findById(Integer.valueOf(id));
	    return categoria.get().getImagen();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDto> getCategoria(@PathVariable String id, HttpServletRequest request) {
		try {
			Optional<Categoria> categoria = categoriaFinderService.findById(Integer.valueOf(id));
			
			CategoriaDto dto = categoriaDtoMapper.toCategoriaDto(categoria.get(), new CycleAvoidingMappingContext());
			dto.setImagenUrl(request.getRequestURL().toString().concat("/image"));
			
			return ResponseEntity.ok(dto);
		} catch (NumberFormatException e) {
			return ResponseEntity.badRequest().build();
		} catch (CategoriaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDto> crearCategoria(@RequestBody CategoriaDto categoriaDto) throws IOException {
		Categoria categoria = categoriaDtoMapper.toCategoria(categoriaDto, new CycleAvoidingMappingContext());
		int result = categoriaCreateService.save(categoria);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} else {
			return ResponseEntity.ok(categoriaDtoMapper.toCategoriaDto(categoria, new CycleAvoidingMappingContext()));
		}
	}
	
	@PostMapping("/formulario")
	public ResponseEntity<CategoriaDto> crearCategoriaFormulario(@ModelAttribute CategoriaDto categoriaDto) throws IOException {
		Categoria categoria = categoriaDtoMapper.toCategoria(categoriaDto, new CycleAvoidingMappingContext());
		
		int result = categoriaCreateService.save(categoria);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} else {
			return ResponseEntity.ok(categoriaDtoMapper.toCategoriaDto(categoria, new CycleAvoidingMappingContext()));
		}
	}
	
	@PostMapping(value = "/{id}/image")
	public ResponseEntity<String> uploadCategoriaImagen(@PathVariable Integer id, @RequestParam("file") MultipartFile file) throws IOException {
		if (file == null) {
			return ResponseEntity.badRequest().build();
		}
		
		try {
			Optional<Categoria> categoria = categoriaFinderService.findById(id);
			categoria.get().setImagen(file.getBytes());
			
			int result = categoriaUpdateService.update(categoria.get());
			
			if(result == 0) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			} else {
				return ResponseEntity.ok().build();
			}
		} catch (CategoriaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable("id") Integer id) {
		if(categoriaDeleteService.delete(id) == 1) {
			return ResponseEntity.ok("Se eliminó");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDto> actualizarCategoria(@PathVariable Integer id, @ModelAttribute CategoriaDto categoriaDto) throws IOException, CategoriaNotFoundException {
		Categoria categoria = categoriaDtoMapper.toCategoria(categoriaDto, new CycleAvoidingMappingContext());
		categoria.setId(id);
		
		int result = categoriaUpdateService.update(categoria);
		
		if(result == 0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		} else {
			categoria = categoriaFinderService.findById(categoria.getId()).get();
			return ResponseEntity.ok(categoriaDtoMapper.toCategoriaDto(categoria, new CycleAvoidingMappingContext()));
		}
	}
}

