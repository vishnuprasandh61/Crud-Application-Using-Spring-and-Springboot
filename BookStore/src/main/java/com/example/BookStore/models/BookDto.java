package com.example.BookStore.models;

import jakarta.validation.constraints.*;

public class BookDto 
{
	
	private Integer bookId;//for this there is no need to set validation because it is auto incremented in table
	
	@NotBlank(message="Book name is required")
	private String bookname;
	
	@NotNull(message = "Book price is required")
	@Min(value = 100, message = "Price value is greater than 100")
	private Integer bookprice;
	
	@NotNull(message = "Count is required")
	@Min(value = 1, message = "value greater then 1")
	private Integer bookcount;
	

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getBookprice() {
		return bookprice;
	}

	public void setBookprice(Integer bookprice) {
		this.bookprice = bookprice;
	}

	public Integer getBookcount() {
		return bookcount;
	}

	public void setBookcount(Integer bookcount) {
		this.bookcount = bookcount;
	}
	
	public void setBookId(Integer bookId)
	{
		this.bookId = bookId;
	}
	public Integer getBookId()
	{
		return bookId;
	}

}
