package com.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.entities.Book;

@Component
public class BookService {
	private static List<Book> list=new ArrayList<>();
	static {
		list.add(new Book(12,"Dil","Horror"));
		list.add(new Book(3,"Mahmud","Fantasy"));
		list.add(new Book(2,"Khan","Fiction"));
	}
	
	//get all books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get single book
	public Book getBookById(int id) {
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//adding book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
}
