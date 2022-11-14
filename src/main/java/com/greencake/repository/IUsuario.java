package com.greencake.repository;

import org.springframework.stereotype.Repository;

import com.greencake.entities.Usuario;
@Repository
public interface IUsuario {
	Iterable<Usuario> obtenerUsuarios();
	Usuario buscarUsuarioPorId(Integer id);
	boolean existeUsuario(Integer id);
	void guardarUsuario(Usuario usuario);
	void borrarUsuario(Integer id);
}
