package com.alura.foro.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Rol;

public interface RolRepositorio extends JpaRepository<Rol, Long>{

	Optional<Rol> findByNombre(String nombre);
}