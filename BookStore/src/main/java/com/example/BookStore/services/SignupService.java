package com.example.BookStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.models.Signuptable;

@Service
public class SignupService 
{
     @Autowired
     private SignupRepository repo2;
     
     public void regForm(Signuptable signup)
     {
    	 repo2.save(signup);
     }
}
