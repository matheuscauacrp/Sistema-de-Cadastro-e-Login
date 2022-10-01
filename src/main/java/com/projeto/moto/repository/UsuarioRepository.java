package com.projeto.moto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.projeto.moto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
