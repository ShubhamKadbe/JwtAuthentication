package net.codejava.user.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.jwt.JwtTokenUtil;
import net.codejava.user.UserData;

@RestController
public class AuthApi {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenUtil jwtToken;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

			UserData user = (UserData) authentication.getPrincipal();
			
			String accessToken = jwtToken.generateAccessToken(user);
			AuthRespomse response = new AuthRespomse(user.getEmail(), accessToken);
			
			return ResponseEntity.ok(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

		}
	}

}
