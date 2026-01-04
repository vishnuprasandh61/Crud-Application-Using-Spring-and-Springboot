package com.example.BookStore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="signup")
public class Signuptable 
{
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int sno;
     
     private String username;
     private String email;
     private String password;
     
	 public int getSno() {
		 return sno;
	 }
	 public void setSno(int sno) {
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
