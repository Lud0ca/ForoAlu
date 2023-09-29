package com.alura.foro.dto.etiquetas.cursos;

import com.alura.foro.modelo.Etiqueta;

public record DatosResumidosCurso (Long id, String nombre) {

	public DatosResumidosCurso(Etiqueta curso) {
		this(curso.getId(), curso.getNombre());
	}
}