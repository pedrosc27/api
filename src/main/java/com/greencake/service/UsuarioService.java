package com.greencake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencake.entities.*;
import com.greencake.repository.*;

@Service
public class UsuarioService implements IUsuario{
	@Autowired
	UsuarioCRUDRepository usuarioRepository;
	
	@Override
	public Iterable<Usuario> findAllUsers() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findUserById(Integer usuario_id) {
		return usuarioRepository.findById(usuario_id)
				.orElseThrow(()->
				new IllegalStateException
				("El usuario con el id " + usuario_id + "no existe"));
	}

	@Override
	public Usuario findUserByEmail(Usuario usuario) {
		return usuarioRepository.findByEmail(usuario.getEmail());
	}

	@Override
	public boolean existsUserById(Integer usuario_id) {
		return usuarioRepository.existsById(usuario_id);
	}

	@Override
	public boolean existsUserByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	@Override
	public Usuario saveUser(Usuario usuario) throws Exception {
		usuario.setIsActive(true);
		if (!(usuario.getNombre_usuario().length() < Usuario.NOMBRE_LENGTH))			
			throw new IllegalStateException("El nombre es mayor a  "+ Usuario.NOMBRE_LENGTH);
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUser(Usuario usuario) {
		Usuario userInDatabase = findUserById(usuario.getIdcliente());	
		userInDatabase.setPassword(usuario.getPassword());
		usuario.setIsActive(true);
		return usuarioRepository.save(userInDatabase);
	}

	@Override
	public String deleteUserById(Integer usuario_id) {
		Usuario userInDatabase = findUserById(usuario_id);
		userInDatabase.setIsActive(false);		
		usuarioRepository.save(userInDatabase);
		return "El usuario ha sido eliminado";	
	}

}
