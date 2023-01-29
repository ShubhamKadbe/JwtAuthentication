package net.codejava.user.api;

public class AuthRespomse {
	
	private String email;
		
	private String accesstoken;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public AuthRespomse(String email, String accesstoken) {
		this.email = email;
		this.accesstoken = accesstoken;
	}

	public AuthRespomse() {
	}
	
	

}
