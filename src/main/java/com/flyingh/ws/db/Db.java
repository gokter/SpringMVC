package com.flyingh.ws.db;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

public class Db {
	private static final Map<User, List<Book>> MAP = new HashMap<>();
	static {
		MAP.put(new User("a", "apass"), Arrays.asList(new Book(1, "Java", 88.8), new Book(2, "Android", 99.9)));
		MAP.put(new User("b", "bpass"), Arrays.asList(new Book(3, "Spring", 100.8), new Book(4, "SSH", 99.99)));
	}

	public static List<Book> getBooksByUserId(String username, String password) {
		return MAP.get(new User(username, password));
	}

	public static Map<String, Book> getAllBooks() {
		final Map<String, Book> result = new HashMap<String, Book>();
		for (final List<Book> books : MAP.values()) {
			for (final Book book : books) {
				result.put(book.getName(), book);
			}
		}
		return result;
	}
}
