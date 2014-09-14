package com.flyingh.ws.server.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.flyingh.app.service.UserService;
import com.flyingh.ws.server.HelloWorldService;
import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

@WebService(endpointInterface = "com.flyingh.ws.server.HelloWorldService", serviceName = "helloWorldService")
@Component("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
	private UserService userService;

	@Override
	public String say(String name) {
		return userService.say(name);
	}

	@Override
	public List<Book> getBooksByUser(User user) {
		return userService.getBooksByUser(user);
	}

	@Override
	public Map<String, Book> getAllBooks() {
		return userService.getAllBooks();
	}

	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
