package com.greencake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.greencake.entities.Usuario;
import com.greencake.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins="*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping //localhost:8080/api/usuario
	@ResponseBody 
	//ResponseEntity configura la respuesta http
	public ResponseEntity<Iterable<Usuario>> getAllUser() {		
		return new ResponseEntity<Iterable<Usuario>>
			(usuarioService.findAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}") //localhost:8080/api/usuario/id
	@ResponseBody
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<Usuario>(usuarioService.findUserById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping //localhost:8080/api/usuario
	@ResponseBody
	public ResponseEntity<?> addNewUser(@RequestBody Usuario usuario) {
		try {
			//Se guarda el cliente y lo retorna con el id asignado.
			return new ResponseEntity<Usuario>(usuarioService.saveUser(usuario), HttpStatus.CREATED);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
					
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody Usuario usuario) {	
		try {
			return new ResponseEntity<Usuario>(usuarioService.updateUser(usuario), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}			
	}
	
	@DeleteMapping("/{id}") //localhost:8080/api/usuario/id
	@ResponseBody
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		try {			
			return new ResponseEntity<String>(usuarioService.deleteUserById(id), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	
	}
	
}
