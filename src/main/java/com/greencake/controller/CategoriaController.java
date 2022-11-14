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

import com.greencake.entities.Categoria;
import com.greencake.service.CategoriaServicio;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class CategoriaController {

	
	@Autowired
	private CategoriaServicio categoriaService;
	
	
	@GetMapping("/categoria") //localhost:8080/api/customer
	public @ResponseBody Iterable<Categoria> obtenerCategorias() {
		return categoriaService.obtenerCategorias();
	}
	
	@GetMapping("/categoria/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Categoria buscarCategoriaPorId(@PathVariable("id") Integer id) {
		return categoriaService.buscarCategoriaPorId(id);
	}	
	
	@PostMapping("/categoria/agregar")
	public @ResponseBody String guardarCategoria(@RequestParam String nombre) {
		Categoria categoria = new Categoria();
		categoria.setNombre_categoria(nombre);
		categoriaService.guardarCategoria(categoria);
		return "guardado";
	}
	
	@DeleteMapping("/categoria/{id}")
	public @ResponseBody void borrarCategoria(@PathVariable("id") Integer id) {
		categoriaService.borrarCategoria(id);
	}	
	
}
