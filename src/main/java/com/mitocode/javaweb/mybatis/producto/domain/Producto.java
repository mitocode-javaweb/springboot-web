package com.mitocode.javaweb.mybatis.producto.domain;

import java.util.ArrayList;
import java.util.List;

import com.mitocode.javaweb.mybatis.categoria.domain.Categoria;
import com.mitocode.javaweb.mybatis.productomensaje.domain.ProductoMensaje;

public class Producto {

	private Integer id;

	private String nombreCorto;

	private String nombreExtenso;

	private String descripcionCorta;

	private String descripcionExtensa;
	
	private Integer cantidad;

	private Categoria categoria;

	private List<ProductoMensaje> mensajes;

	public Producto() {
		this.categoria = new Categoria();
		this.mensajes = new ArrayList<>();
	}

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<ProductoMensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<ProductoMensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreCorto=" + nombreCorto + ", nombreExtenso=" + nombreExtenso
				+ ", descripcionCorta=" + descripcionCorta + ", descripcionExtensa=" + descripcionExtensa
				+ ", cantidad=" + cantidad + ", categoria=" + categoria + ", mensajes=" + mensajes + "]";
	}
	
}
