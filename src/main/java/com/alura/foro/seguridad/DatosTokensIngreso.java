package com.alura.foro.seguridad;

public record DatosTokensIngreso(
		DatosCompletosToken accessToken, 
		DatosCompletosToken refreshToken
		) {
}