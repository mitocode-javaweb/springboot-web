package com.mitocode.javaweb.mybatis.producto.infraestructure.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mitocode.javaweb.mybatis.categoria.infraestructure.dto.CategoriaDto;

public class ProductoDto {

	private Integer id;

	@JsonProperty("nombre-corto")
	private String nombreCorto;

	@JsonProperty(value = "nombre-extenso")
	private String nombreExtenso;

	@JsonProperty(value = "descripcion-corta")
	private String descripcionCorta;

	@JsonProperty(value = "descripcion-extensa")
	private String descripcionExtensa;

	private Integer cantidad;

	@JsonBackReference
	private CategoriaDto categoria;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreExtenso() {
		return nombreExtenso;
	}

	public void setNombreExtenso(String nombreExtenso) {
		this.nombreExtenso = nombreExtenso;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionExtensa() {
		return descripcionExtensa;
	}

	public void setDescripcionExtensa(String descripcionExtensa) {
		this.descripcionExtensa = descripcionExtensa;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public CategoriaDto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDto categoria) {
		this.categoria = categoria;
	}

}
