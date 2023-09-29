package com.alura.foro.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.dto.usuarios.DatosIngresoUsuario;
import com.alura.foro.dto.usuarios.DatosRegistroUsuario;
import com.alura.foro.seguridad.DatosCompletosToken;
import com.alura.foro.seguridad.DatosTokensIngreso;
import com.alura.foro.seguridad.TokenServicio;
import com.alura.foro.servicios.UsuarioServicio;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class AutenticacionControlador {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Autowired
	private TokenServicio tokenServicio;

	@PostMapping("/auth/login")
	@Transactional
	public ResponseEntity<Object> iniciarSesion(@RequestBody @Valid DatosIngresoUsuario datosUsuario) {
		Authentication autenticacionToken = new UsernamePasswordAuthenticationToken(datosUsuario.correo(), datosUsuario.contrasena());
		Authentication usuarioAutenticado = authenticationManager.authenticate(autenticacionToken);

		DatosTokensIngreso tokens = tokenServicio.generarTokensDeIngreso(usuarioAutenticado);

		return ResponseEntity.ok().body(tokens);
	}

	@PostMapping("/auth/signup")
	@Transactional
	public ResponseEntity<Object> registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datosUsuario) {
		usuarioServicio.registrarUsuario(datosUsuario);
		return ResponseEntity.ok().body("Registro exitoso");
	}

	@PostMapping("auth/logout")
	@Transactional
	@PreAuthorize("hasAuthority('USUARIO')")
	public ResponseEntity<Object> cerrarSesion() {
		tokenServicio.eliminarRefreshTokenDeBD();
		SecurityContextHolder.clearContext();
		return ResponseEntity.ok().build();
	}

	@PostMapping("auth/token/refresh")
	public ResponseEntity<Object> refreshToken(
			HttpServletRequest peticion, 
			HttpServletResponse respuesta)
			throws IOException {

		DatosCompletosToken accessToken = tokenServicio.generarNuevoAccessToken(peticion);
		return ResponseEntity.ok().body(accessToken);
	}
}