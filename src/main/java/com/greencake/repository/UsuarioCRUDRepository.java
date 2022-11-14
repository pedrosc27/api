package com.greencake.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greencake.entities.Usuario;

@Repository
public interface UsuarioCRUDRepository extends CrudRepository<Usuario, Integer>{

}
