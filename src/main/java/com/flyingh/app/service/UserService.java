package com.flyingh.app.service;

import java.util.List;
import java.util.Map;

import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

public interface UserService {
	String say(String name);

	List<Book> getBooksByUser(User user);

	Map<String, Book> getAllBooks();
}
