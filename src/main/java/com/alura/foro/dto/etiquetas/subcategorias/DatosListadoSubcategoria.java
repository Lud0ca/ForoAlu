package com.alura.foro.dto.etiquetas.subcategorias;

import com.alura.foro.dto.etiquetas.categorias.DatosResumidosCategoria;
import com.alura.foro.modelo.Etiqueta;

public record DatosListadoSubcategoria(
		Long id,
		String nombre,
		DatosResumidosCategoria categoria
		) {

	public DatosListadoSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre(),
				new DatosResumidosCategoria(subcategoria.getEtiquetaPadre())
			);
	}
}