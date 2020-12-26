package com.mitocode.javaweb.mybatis.categoria.infraestructure.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaEstado;
import com.mitocode.javaweb.mybatis.producto.infraestructure.dto.ProductoDto;

public class CategoriaDto {

	public Integer id;
	public String nombre;
	public String descripcion;

	@JsonIgnore
	public byte[] imagen;

	@JsonProperty(value = "imagen-url")
	private String imagenUrl;

	public MultipartFile fileImagen;

	public CategoriaEstado estado;

	@JsonProperty("estado-descripcion")
	public String estadoDescripcion;

	@JsonManagedReference
	private List<ProductoDto> productos;

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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public CategoriaEstado getEstado() {
		return estado;
	}

	public void setEstado(CategoriaEstado estado) {
		this.estado = estado;
	}

	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}

	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public List<ProductoDto> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDto> productos) {
		this.productos = productos;
	}

	public MultipartFile getFileImagen() {
		return fileImagen;
	}

	public void setFileImagen(MultipartFile fileImagen) {
		this.fileImagen = fileImagen;
	}

	@Override
	public String toString() {
		return "CategoriaDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ "]";
	}

}
