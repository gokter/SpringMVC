package com.flyingh.app.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.flyingh.app.service.UserService;
import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final Map<User, List<Book>> MAP = new HashMap<>();
	static {
		MAP.put(new User("a", "apass"), Arrays.asList(new Book(1, "Java", 88.8), new Book(2, "Android", 99.9)));
		MAP.put(new User("b", "bpass"), Arrays.asList(new Book(3, "Spring", 100.8), new Book(4, "SSH", 99.99)));
	}

	@Override
	public String say(String name) {
		return "Hello," + name;
	}

	@Override
	public List<Book> getBooksByUser(User user) {
		return MAP.get(user);
	}

	@Override
	public Map<String, Book> getAllBooks() {
		final Map<String, Book> result = new HashMap<String, Book>();
		for (final List<Book> books : MAP.values()) {
			for (final Book book : books) {
				result.put(book.getName(), book);
			}
		}
		return result;
	}
}
