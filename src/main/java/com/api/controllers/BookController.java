package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.influx.InfluxDbOkHttpClientBuilderProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.entities.Book;
import com.api.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	//get all book handler
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookService.getAllBooks();
	}
	
	//get single book handler
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
	//create Handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b=this.bookService.addBook(book);
		return b;
	}
	
	
	//delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBoook(@PathVariable("bookId")int bookId) {
		this.bookService.deleteBook(bookId);
	}
	
	
//	//update controlller
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId")int bookId) {
		this.bookService.updateBook(book,bookId);
		return book;
	}
	
	
}
