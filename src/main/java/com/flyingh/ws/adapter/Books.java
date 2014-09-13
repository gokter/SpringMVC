package com.flyingh.ws.adapter;

import java.util.List;

import com.flyingh.ws.vo.Book;

public class Books {
	private List<Book> books;

	public Books(List<Book> books) {
		super();
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
