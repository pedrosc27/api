package com.greencake.entities;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name="usuarios")
public class Usuario {
	public static final int NOMBRE_LENGTH = 60;
	public static final int EMAIL_LENGTH = 60;
	public static final int CONTRASENA_LENGTH = 60;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Integer idcliente;
	@Column(name="nombre_usuario", length=NOMBRE_LENGTH)
	private String nombre_usuario;
	@Column(name="email",updatable=false, length=EMAIL_LENGTH)
	private String email;
	//@NotNull
	@Column(name="password", length=CONTRASENA_LENGTH)
	private String password;
	@CreationTimestamp 
	@Column(name="fecha_alta")
	private Timestamp fecha_alta;
	@Column(name="is_active")
	private boolean isActive;
	
	public Usuario() {}
	
	public Integer getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(Timestamp fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}