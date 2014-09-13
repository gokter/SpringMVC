package com.flyingh.ws.server.impl;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.flyingh.ws.db.Db;
import com.flyingh.ws.server.HelloWorldService;
import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

@WebService(endpointInterface = "com.flyingh.ws.server.HelloWorldService", serviceName = "helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String say(String name) {
		return "Hello," + name;
	}

	@Override
	public List<Book> getBooksByUser(User user) {
		return Db.getBooksByUserId(user.getUsername(), user.getPassword());
	}

	@Override
	public Map<String, Book> getAllBooks() {
		return Db.getAllBooks();
	}

}
