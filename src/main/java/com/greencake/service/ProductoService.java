package com.greencake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencake.entities.Producto;
import com.greencake.repository.IProducto;
import com.greencake.repository.ProductoCRUDRepository;

@Service
public class ProductoService implements IProducto{
	
	@Autowired
	ProductoCRUDRepository productoRepository;

	@Override
	public Iterable<Producto> obtenerProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}
	
	@Override
	public Producto buscarProductoPorId(Integer id) {
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalStateException
				("The user with id " + id + " does not exist"));
	}

	@Override
	public boolean existeProducto(Integer id) {
		// TODO Auto-generated method stub
		
		return productoRepository.existsById(id);
	}

	@Override
	public void guardarProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public void borrarProducto(Integer id) {
		productoRepository.deleteById(id);
		
	}

	@Override
	public Producto actualizarProducto(Producto producto) {

		Producto productoNuevo = buscarProductoPorId(producto.getProducto_id());
		productoNuevo.setNombre_producto(producto.getNombre_producto());
		productoNuevo.setDescripcion_producto(producto.getDescripcion_producto());
		productoNuevo.setCategoria_nombre(producto.getCategoria_nombre());
		productoNuevo.setImagen(producto.getImagen());
		//guardarProducto(productoNuevo);
		//return productoNuevo;
		return productoRepository.save(productoNuevo);
	}

	
	




}
