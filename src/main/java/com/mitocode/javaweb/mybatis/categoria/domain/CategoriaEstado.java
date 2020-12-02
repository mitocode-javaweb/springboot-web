package com.mitocode.javaweb.mybatis.categoria.domain;

public enum CategoriaEstado {
	
	ACTIVA("Activa"), INACTIVA("Inactiva"), SIN_STOCK("Sin Stock");
	
	private String descripcion;

	private CategoriaEstado(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

}
