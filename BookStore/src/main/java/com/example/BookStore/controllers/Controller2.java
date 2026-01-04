package com.example.BookStore.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BookStore.models.Book;
import com.example.BookStore.models.LoginDto;
import com.example.BookStore.models.SignupDto;
import com.example.BookStore.models.Signuptable;
import com.example.BookStore.services.BookService;
import com.example.BookStore.services.LoginService;
import com.example.BookStore.services.SignupService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/Book1")
public class Controller2 
{
	@Autowired
	private SignupService service1;//this is for signup
	
	@Autowired
	private LoginService loginservice;
	
    @GetMapping("/signup")//load the signup page
    public String signupPage(Model model)
    {
     	model.addAttribute("signup", new SignupDto());
    	return "ValidationFolder/signup";
    }
    @PostMapping("/register")//register the data in signup page
    public String validatePage(@Valid @ModelAttribute("signup") SignupDto signupdto, BindingResult result1, Model model)
    {
    	if(result1.hasErrors())
    	{
    		return "ValidationFolder/signup";
    	}
    	Signuptable signup = new Signuptable();
    	signup.setUsername(signupdto.getUsername());  
    	signup.setEmail(signupdto.getEmail());
    	signup.setPassword(signupdto.getPassword());
    	service1.regForm(signup);
    	
    	   // ✔ Redirect to LOGIN page=> to start the login page with new request so tha old request data will be deleted
        return "redirect:/Book1/login";	
    }
    
    @GetMapping("/login")
    public String showLoginPage(Model model) 
    {
        model.addAttribute("logindata", new LoginDto());
        return "ValidationFolder/login";
    }
    
    @PostMapping("/login")
    public String doLogin(@ModelAttribute("logindata") LoginDto loginDto, Model model)
    {
        Signuptable user = loginservice.login(loginDto.getEmail(), loginDto.getPassword());

        if (user != null) {
            model.addAttribute("book", new Book());
            return "redirect:/Book/create";//redirected to createbook page so that this page will start with new request 
            //old request data will be deleted
        } 
        else {
            model.addAttribute("errorMsg", "Invalid email or password");
            return "ValidationFolder/login";
        }
    }
     
}
