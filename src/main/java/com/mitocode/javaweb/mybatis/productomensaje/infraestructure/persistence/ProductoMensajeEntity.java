package com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mitocode.javaweb.mybatis.producto.infraestructure.persistence.ProductoEntity;

@Entity
@Table(name = "producto_mensaje")
public class ProductoMensajeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	@Column
	private LocalDate fecha;

	@Column
	private String mensaje;

	@ManyToOne
	@JoinColumn(name = "id_producto", insertable = false, updatable = false)
	private ProductoEntity producto;

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

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "ProductoMensajeEntity [id=" + id + ", nombreUsuario=" + nombreUsuario + ", fecha=" + fecha
				+ ", mensaje=" + mensaje + ", producto=" + producto + "]";
	}

}
