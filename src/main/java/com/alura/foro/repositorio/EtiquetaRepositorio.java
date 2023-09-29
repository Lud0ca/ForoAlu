package com.alura.foro.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Etiqueta;
import com.alura.foro.modelo.Nivel;

public interface EtiquetaRepositorio extends JpaRepository<Etiqueta, Long>  {

	Page<Etiqueta> findAllByNivel(Nivel nivel, Pageable paginacion);

	Etiqueta findByIdAndNivel(Long id, Nivel nivel);

	boolean existsByIdAndNivel(Long id, Nivel nivel);

	Page<Etiqueta> findAllByNivelAndEtiquetaPadreId(Nivel nivel, Long etiquetaPadreId, Pageable paginacion);

}