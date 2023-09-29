package com.alura.foro.dto.publicaciones;

import java.time.LocalDateTime;
import java.util.List;

import com.alura.foro.dto.respuestas.DatosResumidosRespuesta;
import com.alura.foro.dto.usuarios.DatosResumidosUsuario;
import com.alura.foro.modelo.EstadoPublicacion;
import com.alura.foro.modelo.Publicacion;

public record DatosListadoPublicacionPorCurso(
		Long publicacionId, 
		String titulo, 
		String mensaje, 
		LocalDateTime fechaCreacion, 
		EstadoPublicacion estado, 
		List<DatosResumidosRespuesta> respuestas,
		DatosResumidosUsuario autor
		) {

	public DatosListadoPublicacionPorCurso(Publicacion publicacion) {
		this(
				publicacion.getId(), 
				publicacion.getTitulo(), 
				publicacion.getMensaje(), 
				publicacion.getFechaCreacion(), 
				publicacion.getEstado(), 
				publicacion.getRespuestas().stream().map(DatosResumidosRespuesta::new).toList(),
				new DatosResumidosUsuario(publicacion.getAutor())
			);
	}
}