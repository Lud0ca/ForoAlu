package com.alura.foro.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Respuesta;

public interface RespuestaRepositorio extends JpaRepository<Respuesta, Long> {

	Page<Respuesta> findAllByPublicacionId(Long publicacion_id, Pageable paginacion);
}