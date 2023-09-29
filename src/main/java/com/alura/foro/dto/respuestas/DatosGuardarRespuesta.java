package com.alura.foro.dto.respuestas;

import com.alura.foro.modelo.Respuesta;
import jakarta.validation.constraints.NotBlank;

public record DatosGuardarRespuesta(
		@NotBlank(message = "El mensaje es obligatorio")
		String mensaje
		) {

	public DatosGuardarRespuesta(Respuesta respuesta) {
		this(respuesta.getMensaje());
	}

}