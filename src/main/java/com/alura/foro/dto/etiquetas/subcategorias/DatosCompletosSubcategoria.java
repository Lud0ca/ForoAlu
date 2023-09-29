package com.alura.foro.dto.etiquetas.subcategorias;

import java.util.List;

import com.alura.foro.dto.etiquetas.categorias.DatosResumidosCategoria;
import com.alura.foro.dto.etiquetas.cursos.DatosResumidosCurso;
import com.alura.foro.modelo.Etiqueta;

public record DatosCompletosSubcategoria (
		Long id,
		String nombre,
		DatosResumidosCategoria categoria,
		List<DatosResumidosCurso> cursos
		) {

	public DatosCompletosSubcategoria(Etiqueta subcategoria) {
		this(
				subcategoria.getId(),
				subcategoria.getNombre(),
				new DatosResumidosCategoria(subcategoria.getEtiquetaPadre()),
				subcategoria.getEtiquetasHijas().stream().map(DatosResumidosCurso::new).toList()
			);
	}
}