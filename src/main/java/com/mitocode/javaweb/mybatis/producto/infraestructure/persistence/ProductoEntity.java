package com.mitocode.javaweb.mybatis.producto.infraestructure.persistence;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mitocode.javaweb.mybatis.categoria.infraestructure.presistence.CategoriaEntity;
import com.mitocode.javaweb.mybatis.productomensaje.infraestructure.persistence.ProductoMensajeEntity;

@Entity
@Table(name = "producto")
public class ProductoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Column(name = "nombre_corto")
	private String nombreCorto;

	@Column(name = "nombre_extenso")
	private String nombreExtenso;

	@Column(name = "descripcion_corta")
	private String descripcionCorta;

	@Column(name = "descripcion_extensa")
	private String descripcionExtensa;

	@Column
	private Integer cantidad;

	@OneToOne
	@JoinColumn(name = "id_categoria", insertable = false, updatable = false)
	private CategoriaEntity categoria;

	// no es recomendable colocar EAGER  a listas
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProductoMensajeEntity> mensajes;

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

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}

	public List<ProductoMensajeEntity> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<ProductoMensajeEntity> mensajes) {
		this.mensajes = mensajes;
	}

	@Override
	public String toString() {
		return "ProductoEntity [id=" + id + ", nombreCorto=" + nombreCorto + ", nombreExtenso=" + nombreExtenso
				+ ", descripcionCorta=" + descripcionCorta + ", descripcionExtensa=" + descripcionExtensa
				+ ", cantidad=" + cantidad + ", categoria=" + categoria + "]";
	}

}
