package net.codejava.user.api;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class AuthRequest {
	
	@Email @Length(min = 2, max = 50)
	private String email;
	
	@Length(min = 2, max = 10)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
