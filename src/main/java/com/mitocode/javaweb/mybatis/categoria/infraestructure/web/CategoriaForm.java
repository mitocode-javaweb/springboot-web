package com.mitocode.javaweb.mybatis.categoria.infraestructure.web;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaEstado;

public class CategoriaForm {

	private Integer id;
	
	@NotBlank(message = "{categoria.forms.nombre.notempty}")
	private String nombre;

	@NotBlank
//	@Max(value = 50, message = "La descripción debe ser de 50 caracteres máximo")
	private String descripcion;
	
	@NotNull
	private MultipartFile imagen;

	private CategoriaEstado estado;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

	public CategoriaEstado getEstado() {
		return estado;
	}

	public void setEstado(CategoriaEstado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CategoriaForm [nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen + ", estado="
				+ estado + "]";
	}

}
