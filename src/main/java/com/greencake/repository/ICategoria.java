package com.greencake.repository;

import org.springframework.stereotype.Repository;

import com.greencake.entities.Categoria;
@Repository
public interface ICategoria {
	Iterable<Categoria> obtenerCategorias();
	Categoria buscarCategoriaPorId(Integer id);
	boolean existeCategoria(Integer id);
	void guardarCategoria(Categoria categoria);
	void borrarCategoria(Integer id);
}
