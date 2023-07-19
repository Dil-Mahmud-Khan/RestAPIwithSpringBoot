package com.api.service;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
			book=list.stream().filter(e->e.getId()==id).findFirst().get();

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return book;
	}
	
	//adding book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}
	
	//delete book
	
	public void deleteBook(int bid) {
		list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
	}
	
	
	//update book
	public void updateBook(Book book, int bookId) {
		list=list.stream().map(b->{
			if(b.getId()==bookId) {
				b.setAuthor("Salman Khan");
				b.setTitle("Unmarried");
			}
			return b;
		}).collect(Collectors.toList());
	}
	
}
