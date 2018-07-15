package cartelera.controllers;

import java.util.Collections;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cartelera.clasesDTO.Token;
import cartelera.clasesDTO.Usuario;
import cartelera.jwt.TokenManagerSecurity;
import cartelera.ar.com.facultad.springmvc.api.ServicioGuarani;

/**
 * @author Manuel Ortiz - ortizman@gmail.com
 *
 * Nov 28, 2016
 */
@CrossOrigin
@RestController
public class LoginController {
	
	@Inject
	private ServicioGuarani loginService;
	
	@Inject
	private TokenManagerSecurity tokenManagerSecurity;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario userPost) {
		try {
//			Usuario user = loginService.login(userPost.getUserLogin(), userPost.getPassword());
			Token token = new Token(tokenManagerSecurity.createJWT(new Usuario()));
			return ResponseEntity.ok(token);
		} catch (Exception e) {
			return new ResponseEntity<>(Collections.singletonMap("AuthenticationException",e.getMessage()), HttpStatus.UNAUTHORIZED);
		}
	}

}
