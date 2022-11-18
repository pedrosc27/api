package com.greencake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	@GetMapping("/producto") 
	@ResponseBody
	public ResponseEntity<?> obtenerProductos() {
		try{
			return new ResponseEntity<Iterable<Producto>>(productoService.obtenerProductos(), HttpStatus.OK);
		}    
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/producto/id") 
	@ResponseBody
	public ResponseEntity<?> buscarProductoPorId(@RequestParam Integer id) {
		try{
			return new ResponseEntity<Producto>(productoService.buscarProductoPorId(id), HttpStatus.OK);
		} 
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}	
	
	@GetMapping("/producto/productos")
	@ResponseBody 
	public ResponseEntity<?> paginationProductos(@RequestParam int pagina) {
		try{
			return new ResponseEntity<Page<Producto>>(productoService.paginationProductos(pagina), HttpStatus.OK);
		} 
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}		

	@GetMapping("/producto/categoria") 
	@ResponseBody 
	public ResponseEntity<?>  buscarProductosPorCategoria(@RequestParam("categoria")  String categoria) {
		try{
			return new ResponseEntity<Iterable<Producto>>(productoRepository.findByCategoria(categoria), HttpStatus.OK);
		} 
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/producto/categoria/pagina") 
	@ResponseBody 
	public ResponseEntity<?>  buscarProductosPorCategoriaPagination(@RequestParam("categoria")  String categoria, @RequestParam("pagina")  int pagina) {
		int index = pagina -1;
		try{
			
			return new ResponseEntity<Page<Producto>>(productoRepository.findByCategoria(PageRequest.of(index, 12),categoria), HttpStatus.OK);
		} 
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}	
	
	
	@PostMapping("/producto/agregar")
	@ResponseBody
	public ResponseEntity<?> agregarUsuario(@RequestBody Producto producto){
	try {
			return new ResponseEntity<Producto>(productoService.guardarProducto(producto), HttpStatus.OK);
		}
		catch (IllegalStateException e){
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
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
	
	@DeleteMapping("/producto/{id}")
	@ResponseBody 
	public void borrarProducto(@PathVariable("id") Integer id) {
		productoService.borrarProducto(id);
	}	
	

	
	
}
