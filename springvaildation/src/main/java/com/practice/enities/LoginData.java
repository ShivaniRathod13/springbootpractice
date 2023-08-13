package com.practice.enities;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginData {
	@NotBlank(message = "user name can not be empty !!")
	@Size(min = 3,max = 12,message = "Username must be between3-12 charracter")
	private String userName;
	
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Inavalid Email")
	private String email;

	@AssertTrue( message = "must agree terms and condition")
	private boolean agreed;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}

}
