package com.greencake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greencake.entities.Usuario;
import com.greencake.service.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuario") //localhost:8080/api/customer
	public @ResponseBody Iterable<Usuario> obtenerUsuarios() {
		return usuarioService.obtenerUsuarios();
	}
	
	@GetMapping("/usuario/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Usuario buscarUsuarioPorId(@PathVariable("id") Integer id) {
		return usuarioService.buscarUsuarioPorId(id);
	}
	
	@PostMapping("/usuario/agregar")
	public @ResponseBody String agregarUsuario(
			@RequestParam String nombre, @RequestParam String apellido, 
			@RequestParam String email, @RequestParam String password) {
		Usuario usuario = new Usuario();
		usuario.setNombre_usuario(nombre);
		usuario.setApellido_usuario(apellido);
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuarioService.guardarUsuario(usuario);
		return "guardado";
	}
	
	@DeleteMapping("/usuario/{id}")
	public @ResponseBody void eliminarUsuarioPorId(@PathVariable("id") Integer id) {
		usuarioService.borrarUsuario(id);
	}
	
}
