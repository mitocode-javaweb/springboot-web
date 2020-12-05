package com.mitocode.javaweb.mybatis.categoria.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mitocode.javaweb.mybatis.producto.domain.Producto;

public class Categoria {

	public Integer id;
	public String nombre;
	public String descripcion;
	public byte[] imagen;
	public CategoriaEstado estado;

	private List<Producto> productos;

	public Categoria() {
		this.estado = CategoriaEstado.ACTIVA;
		this.productos = new ArrayList<>();
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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen="
				+ Arrays.toString(imagen) + ", estado=" + estado + ", productos=" + productos + "]";
	}

}
