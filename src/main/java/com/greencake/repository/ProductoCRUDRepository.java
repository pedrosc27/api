package com.greencake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greencake.entities.Producto;

@Repository
public interface ProductoCRUDRepository extends JpaRepository<Producto, Integer>{
	//Iterable<Producto> buscarProductosPorCategoria(String imagen);
	Iterable<Producto> findByCategoria(String categoria);
}
