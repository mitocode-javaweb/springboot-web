package com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.mitocode.javaweb.mybatis.categoria.domain.CategoriaEstado;
import com.mitocode.javaweb.mybatis.producto.infraestructure.persistence.ProductoEntity;

@Entity
@Table(name = "categoria")
@DynamicUpdate
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	public Integer id;
	
	@Column
	public String nombre;
	
	@Column
	public String descripcion;
	
	@Column
	public byte[] imagen;
	
	@Enumerated(EnumType.STRING)
	public CategoriaEstado estado;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	private List<ProductoEntity> productos;

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

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "CategoriaEntity [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen="
				+ Arrays.toString(imagen) + ", estado=" + estado + "]";
	}
	
}
