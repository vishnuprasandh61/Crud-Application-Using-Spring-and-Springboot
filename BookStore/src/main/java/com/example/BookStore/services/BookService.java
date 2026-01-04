package com.example.BookStore.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.BookStore.models.Book;

@Service//tells the spring that this class handles business logic like processing, saving and calculations and interacts with repository to store, access or modify the data 
public class BookService 
{
	@Autowired
	private BookRepository repo1; //spring will automatically create BookRepository object on Service class, with the help of BookRepository object 
	                              // to store the entity  into database
	
	//insert the data into database
	public void saveBook(Book book)
	{
		repo1.save(book);//store the entity object(book)  present in Service class into Repository 
		                 // once you run the application, enter the datas, those datas will store in database 
		                 //with the help of Spring Data Jpa dependency without that dependency => Repository cannot connect with database
	}
	
	//view the data into database
	public List<Book> getAllData()
	{
	    return repo1.findAll();// in service layer retrieve all the datas that are stored in database and generate in a list 
	}
	
	//delete the particular record
	public void deleteBook(Integer bookId)
	{
		repo1.deleteById(bookId);
	}
	
	//edit the particular record
    public Book getBookById(Integer bookId)
    {
    	return repo1.findById(bookId).orElse(null);//calling this method will get the particular record from database
    }
    
    //update the record
    public void updateBook(Book book)
	{
		repo1.save(book);
		                 
	}
}
