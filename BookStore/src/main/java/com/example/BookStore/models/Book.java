package com.example.BookStore.models;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "booktable")
public class Book 
{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int bookId;
   
   private String bookname;
   private int bookprice;
   private int bookcount;
   public int getBookId() {
	return bookId;
   }
   public void setBookId(int bookId) {
	this.bookId = bookId;
   }
   public String getBookname() {
	return bookname;
   }
   public void setBookname(String bookname) {
	this.bookname = bookname;
   }
   public int getBookprice() {
	return bookprice;
   }
   public void setBookprice(int bookprice) {
	this.bookprice = bookprice;
   }
   public int getBookcount() {
	return bookcount;
   }
   public void setBookcount(int bookcount) {
	this.bookcount = bookcount;
   }
   
   
}
