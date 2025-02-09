package tr.project.kerem.syndicate.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tr.project.kerem.syndicate.dto.RegisterRequest;
import tr.project.kerem.syndicate.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
		return ResponseEntity.ok(authService.register(request));
	}
}
