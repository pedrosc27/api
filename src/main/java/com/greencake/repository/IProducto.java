package com.greencake.repository;

import org.springframework.stereotype.Repository;

import com.greencake.entities.Producto;

@Repository
public interface IProducto {

	Iterable<Producto> obtenerProductos();
	Producto buscarProductoPorId(Integer id);
	boolean existeProducto(Integer id);
	Producto guardarProducto(Producto producto);
	void borrarProducto(Integer id);
	Producto actualizarProducto(Producto producto);
}
