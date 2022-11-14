package com.greencake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greencake.entities.Categoria;
import com.greencake.repository.CategoriaCRUDRepository;
import com.greencake.repository.ICategoria;

@Service
public class CategoriaServicio implements ICategoria{
	
	@Autowired
	CategoriaCRUDRepository categoriaRepository;
	
	@Override
	public Iterable<Categoria> obtenerCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria buscarCategoriaPorId(Integer id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id).orElseThrow(
				()->new IllegalStateException
				("The user with id " + id + " does not exist"));
	}

	@Override
	public boolean existeCategoria(Integer id) {
		// TODO Auto-generated method stub
		return categoriaRepository.existsById(id);
	}

	@Override
	public void guardarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		
	}

	@Override
	public void borrarCategoria(Integer id) {
		categoriaRepository.deleteById(id);;
		
	}

}
