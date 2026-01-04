package com.example.BookStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BookStore.models.Book;
import com.example.BookStore.models.BookDto;
import com.example.BookStore.services.BookService;

import jakarta.validation.Valid;

@Controller//tells the spring that this class handles the web requests and return the HTML pages
@RequestMapping("/Book")
public class BookController
{
	 @Autowired
	 private BookService bookservice;//spring will automatically create and provide BookService(class) object to your controller,
	                                 // with the help of object(=>bookservice) to store the entity into database
	
	//controller for displaying
     @GetMapping("/create")
     private String displayPage(Model model)
     {
    	 //model.addAttribute=>send the data to the form
    	 model.addAttribute("book", new BookDto());    //whatever name you given as string=>"book" you given that only can be used everywhere
    	 return "Book/createbook";
     }

     
     //controller for Validation and insert the data
     @PostMapping("/validate")
     public String validationPage(@Valid @ModelAttribute("book") BookDto bookdto, BindingResult result, Model model)
     {
    	 if(result.hasErrors())
    	 {
    		 return "Book/createbook";//returns same html page 
    	 }
    	 
    	 //once you received the form data from controller the datas will already stored into dto object and get the dto object 
    	 //store it into entity
    	 Book book = new Book();
    	 book.setBookname(bookdto.getBookname());
    	 book.setBookprice(bookdto.getBookprice());
    	 book.setBookcount(bookdto.getBookcount());
    	 
    	 bookservice.saveBook(book);//call the service layer(object) to save the entity=>(book) into database
    	 return "redirect:/Book/create";//refreshes the page automatically by using "redirect:/RequestMapping/GetMapping or PostMapping" url path
    	
     }  
 
     //controller for viewing the stored datas in database
	 @GetMapping("/view")
	 public String viewBook(Model model)
	 {
		 List<Book> list = bookservice.getAllData();
		 model.addAttribute("book",list);
		 return "Book/viewbook";
	 }
	 
	 //controller for delete the particular record in database
	 @GetMapping("/delete/{id}")
	 public String deleteBook(@PathVariable("id") Integer bookId) 
	 {
	     bookservice.deleteBook(bookId);
	     return "redirect:/Book/view";  // controller reloads the page for user to see updated table in viewbook.html page
	 }
	 
	 //controller for edit the particular record in database
	 @GetMapping("/edit/{id}")
	 public String editBook(@PathVariable("id") Integer bookId, Model model)
	 {
		 Book book = bookservice.getBookById(bookId);
		 model.addAttribute("book", book);
		 return "Book/editbook";	 
	 }
	 
	 //controller for update the particular record in database
	 @PostMapping("/update")
	 private String updatePage(@Valid @ModelAttribute("book") BookDto bookdto,
	                           BindingResult result,
	                           Model model)
	 {
	     if(result.hasErrors()) 
	     {
	    	 
	         return "Book/editbook";
	     }

	     // 1️⃣ Load existing book using ID by calling the method in Bookservice class
	     Book existingBook = bookservice.getBookById(bookdto.getBookId());

	     // 2️⃣ Update only selected fields and uptade the values in into BookDto object
	     existingBook.setBookname(bookdto.getBookname());
	     existingBook.setBookprice(bookdto.getBookprice());
	     existingBook.setBookcount(bookdto.getBookcount());

	     // 3 Save updated book
	     bookservice.saveBook(existingBook);   // ✔ updates instead of insert

	     return "redirect:/Book/view";
	 }

	 

}


