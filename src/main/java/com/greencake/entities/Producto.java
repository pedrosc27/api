package com.greencake.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producto_id")
	private Integer producto_id;
	
	@Column(name="nombre_producto")
	private String nombre_producto;
	
	@Column(name="descripcion_producto")
	private String descripcion_producto;
	
	@Column(name="imagen")
	private String imagen;
	
	@Column(name="categoria")
	private String categoria;
	
	public Producto() {
		
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCategoria_nombre() {
		return categoria;
	}

	public void setCategoria_nombre(String categoria_nombre) {
		this.categoria = categoria_nombre;
	}

	
	


	
	


}
