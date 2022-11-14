package com.greencake.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greencake.entities.Categoria;
@Repository
public interface CategoriaCRUDRepository extends CrudRepository<Categoria, Integer>{

}
