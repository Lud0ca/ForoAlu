package com.alura.foro.dto.etiquetas.categorias;

import com.alura.foro.modelo.Etiqueta;

public record DatosResumidosCategoria(Long id, String nombre) {

	public DatosResumidosCategoria(Etiqueta categoria) {
		this(categoria.getId(), categoria.getNombre());
	}
}