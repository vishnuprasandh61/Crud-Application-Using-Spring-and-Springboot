package com.example.BookStore.models;

import jakarta.validation.constraints.NotBlank;

public class SignupDto 
{
     private Integer sno;
     
     @NotBlank(message = "username is required")
     private String username;
     
     @NotBlank(message = "email is required")
     private String email;
     
     @NotBlank(message = "password is required")
     private String password;

	 public Integer getSno() {
		 return sno;
	 }

	 public void setSno(Integer sno) {
		 this.sno = sno;
	 }

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

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
