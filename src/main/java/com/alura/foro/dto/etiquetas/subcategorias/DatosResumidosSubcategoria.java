package com.alura.foro.dto.etiquetas.subcategorias;

import com.alura.foro.modelo.Etiqueta;

public record DatosResumidosSubcategoria(
		Long id,
		String nombre
		) {

	public DatosResumidosSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre()
			);
	}
}