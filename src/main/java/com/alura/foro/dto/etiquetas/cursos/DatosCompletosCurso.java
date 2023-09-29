package com.alura.foro.dto.etiquetas.cursos;

import com.alura.foro.dto.etiquetas.categorias.DatosResumidosCategoria;
import com.alura.foro.dto.etiquetas.subcategorias.DatosResumidosSubcategoria;
import com.alura.foro.modelo.Etiqueta;

public record DatosCompletosCurso (
		Long id,
		String nombre,
		DatosResumidosCategoria categoria,
		DatosResumidosSubcategoria subcategoria
	){

	public DatosCompletosCurso(Etiqueta curso) {
		this(
				curso.getId(),
				curso.getNombre(),
				new DatosResumidosCategoria(curso.getEtiquetaPadre().getEtiquetaPadre()),
				new DatosResumidosSubcategoria(curso.getEtiquetaPadre())
			);
	}
}