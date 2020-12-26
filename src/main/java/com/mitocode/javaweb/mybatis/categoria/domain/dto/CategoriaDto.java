package com.mitocode.javaweb.mybatis.categoria.domain.dto;

import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaEstado;

public class CategoriaDto {

	public Integer id;
	public String nombre;
	public String descripcion;
	public byte[] imagen;
	public CategoriaEstado estado;
	public String estadoDescripcion;

	public CategoriaDto() {
		this.estado = CategoriaEstado.ACTIVA;
	}

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

	@Override
	public String toString() {
		return "CategoriaDto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
				+ "]";
	}

}
