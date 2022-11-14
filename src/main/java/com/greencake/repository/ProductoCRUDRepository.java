package com.greencake.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greencake.entities.Producto;

@Repository
public interface ProductoCRUDRepository extends CrudRepository<Producto, Integer>{

}
