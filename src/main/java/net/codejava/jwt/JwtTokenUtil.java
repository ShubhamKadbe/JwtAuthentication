package net.codejava.jwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.codejava.user.UserData;

@Component
public class JwtTokenUtil {

	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; //24 hours
	
	@Value("${app.jwt.secret}")
	private String secretKey;
	
	public String generateAccessToken(UserData user) {
		return Jwts.builder()
				.setSubject(user.getId() + "," + user.getEmail())
				.setIssuer("Shubh")
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}
}
