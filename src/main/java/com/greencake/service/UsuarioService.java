package com.greencake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencake.entities.Usuario;
import com.greencake.repository.IUsuario;
import com.greencake.repository.UsuarioCRUDRepository;

@Service
public class UsuarioService implements IUsuario{
	
	@Autowired
	UsuarioCRUDRepository usuarioRepository;

	@Override
	public Iterable<Usuario> obtenerUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarUsuarioPorId(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElseThrow(
				()->new IllegalStateException
				("The user with id " + id + " does not exist"));
	}

	@Override
	public boolean existeUsuario(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.existsById(id);
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void borrarUsuario(Integer id) {
		usuarioRepository.deleteById(id);
		
	}



}
