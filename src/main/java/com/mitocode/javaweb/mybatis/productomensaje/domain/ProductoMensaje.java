package com.mitocode.javaweb.mybatis.productomensaje.domain;

import java.time.LocalDate;

public class ProductoMensaje {

	private Integer id;

	private String nombreUsuario;

	private LocalDate fecha;

	private String mensaje;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ProductoMensaje [id=" + id + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha + ", mensaje="
				+ mensaje + "]";
	}

}
