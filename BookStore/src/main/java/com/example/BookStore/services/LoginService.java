package com.example.BookStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.models.Signuptable;

@Service
public class LoginService 
{
    @Autowired
    private SignupRepository loginrepo;
    
    public Signuptable login(String email, String password)
    {
    	 Signuptable user = loginrepo.findByEmail(email);//get the email from database
    	 if(user==null)//check if you found email or not
    	 {
    		 return null;//if you not found email then return null
    	 }
    	 
    	 //compare user typed password with database password is same or not
    	 if(!user.getPassword().equals(password))
    	 {
    		 return null;//login failed
    	 }
         return user;
    }
}
