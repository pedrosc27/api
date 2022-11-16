package com.greencake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greencake.entities.Producto;
import com.greencake.repository.ProductoCRUDRepository;
import com.greencake.service.ProductoService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ProductoController {

	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	ProductoCRUDRepository productoRepository;
	
	@GetMapping("/producto") //localhost:8080/api/customer
	public @ResponseBody Iterable<Producto> obtenerProductos() {
		
		return productoService.obtenerProductos();
	}
	
	@GetMapping("/producto/{id}") //localhost:8080/api/customer/id
	public @ResponseBody Producto buscarProductoPorId(@PathVariable("id") Integer id) {
		
		return productoService.buscarProductoPorId(id);
	}	
	
	@GetMapping("/producto/categoria/{categoria}") //localhost:8080/api/customer/id
	public @ResponseBody Iterable<Producto>  buscarProductosPorCategoria(@PathVariable("categoria")  String categoria) {
		return productoRepository.findByCategoria(categoria);
	}
	
	@PostMapping("/producto/agregar")
	public @ResponseBody String guardarProducto(
			@RequestParam String nombre, @RequestParam String imagen, 
			@RequestParam String categoria) {
	
		Producto producto = new Producto();
		producto.setNombre_producto(nombre);
		producto.setImagen(imagen);
		producto.setCategoria_nombre(categoria);
		productoService.guardarProducto(producto);
		return "guardado";
	}
	
	@DeleteMapping("/producto/{id}")
	public @ResponseBody void borrarProducto(@PathVariable("id") Integer id) {
		productoService.borrarProducto(id);
	}	
	
	@PutMapping("/producto/actualizar")
	@ResponseBody
	public ResponseEntity<?> actualizarUsuario(@RequestBody Producto producto){
	try {
			return new ResponseEntity<Producto>(productoService.actualizarProducto(producto), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
