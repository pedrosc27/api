package com.greencake.repository;

import org.springframework.stereotype.Repository;

import com.greencake.entities.Usuario;

@Repository
public interface IUsuario {
	public Iterable<Usuario> findAllUsers();
	public Usuario findUserById(Integer usuario_id);
	public String findUserByEmail(Usuario usuario);		
	public boolean existsUserById(Integer usuario_id);
	public boolean existsUserByEmail(String email);
	public Usuario saveUser(Usuario usuario) throws Exception;
	public Usuario updateUser(Usuario usuario);
	public String deleteUserById(Integer usuario_id);
}
