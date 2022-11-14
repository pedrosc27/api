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
import com.greencake.entities.Producto;
import com.greencake.service.ProductoService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ProductoController {

	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/producto") //localhost:8080/api/customer
	public @ResponseBody Iterable<Producto> obtenerProductos() {
		
		return productoService.obtenerProductos();
	}
	
	@GetMapping("/producto/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Producto buscarProductoPorId(@PathVariable("id") Integer id) {
		
		return productoService.buscarProductoPorId(id);
	}	
	
	@PostMapping("/producto/agregar")
	public @ResponseBody String guardarProducto(
			@RequestParam String nombre, @RequestParam String imagen, 
			@RequestParam Integer id) {
		
		Categoria categoria = new Categoria();
		categoria.setCategoria_id(id);
		Producto producto = new Producto();
		producto.setNombre_producto(nombre);
		producto.setImagen(imagen);
		producto.setCategoria(categoria);
		
		productoService.guardarProducto(producto);
		return "guardado";
	}
	
	@DeleteMapping("/producto/{id}")
	public @ResponseBody void borrarProducto(@PathVariable("id") Integer id) {
		productoService.borrarProducto(id);
	}	
	
}
