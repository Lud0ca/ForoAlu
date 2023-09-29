package com.alura.foro.dto.etiquetas.categorias;

import java.util.List;

import com.alura.foro.dto.etiquetas.subcategorias.DatosResumidosSubcategoria;
import com.alura.foro.modelo.Etiqueta;

public record DatosCompletosCategoria (
		Long id,
		String nombre,
		List<DatosResumidosSubcategoria> subcategorias
	) {

	public DatosCompletosCategoria(Etiqueta categoria) {
		this(
				categoria.getId(),
				categoria.getNombre(),
				categoria.getEtiquetasHijas().stream().map(DatosResumidosSubcategoria::new).toList()
			);
	}
}