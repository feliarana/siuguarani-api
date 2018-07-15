package cartelera.ar.com.facultad.springmvc.api;
import java.util.Collections;
//package rest;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cartelera.clasesDTO.Alumno;
import cartelera.clasesDTO.Profesor;
import cartelera.clasesDTO.Usuario;
import cartelera.clasesDTO.Token;
import cartelera.jwt.TokenManagerSecurity;

@RestController
public class ServicioGuarani {
	
	@Inject
	private TokenManagerSecurity tokenManagerSecurity;
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<Usuario> logout(Usuario usr) {
//TODO
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	// ALUMNOS
	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> listarAlumnos() {
		List<Alumno> listadoAlumnos = Alumno.crearListadoAlumno();
		return new ResponseEntity<List<Alumno>>(listadoAlumnos, HttpStatus.OK);
	}

	@RequestMapping(value = "/alumnos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Alumno> encontrarUsuario(@PathVariable("id") int id) {
		Alumno alumno = Alumno.encontrarAlumno(id);
		if (alumno == null) {
			return new ResponseEntity<Alumno>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@RequestMapping(value = "/alumnos/chequearLogin", method = RequestMethod.POST)
	public ResponseEntity<?> validarAlumno(@RequestBody Usuario alumno) {
		try {
			Alumno alumnoLogueado = Alumno.validar(alumno.getNombres(), alumno.getContrasenia());
			if (alumnoLogueado == null) {
				throw new Exception("holis");
			}
			Usuario usr = new Usuario();
			usr.setNombres(alumno.getNombres());
			Token token = new Token(tokenManagerSecurity.createJWT(usr));
			//return ResponseEntity.ok(token);
			return new ResponseEntity<String>("backend.jsp", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}

	// PROFESORES
	@RequestMapping(value = "/profesores", method = RequestMethod.GET)
	public ResponseEntity<List<Profesor>> listarProfesores() {
		List<Profesor> listadoProfesores = Profesor.crearListadoProfesor();
		return new ResponseEntity<List<Profesor>>(listadoProfesores, HttpStatus.OK);
	}

	@RequestMapping(value = "/profesores/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profesor> encontrarProfesor(@PathVariable("id") int id) {
		Profesor p = Profesor.encontrarProfesor(id);
		if (p == null) {
			return new ResponseEntity<Profesor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Profesor>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/profesores/chequearLogin", method = RequestMethod.POST)
	public ResponseEntity<String> validarProfesor(@RequestBody Profesor profesor) {
		Profesor profesorLogueado = Profesor.validar(profesor.getNombres(), profesor.getContrasenia());
		if (profesorLogueado == null) {
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>("backend-admin.jsp", HttpStatus.OK);
	}

}
