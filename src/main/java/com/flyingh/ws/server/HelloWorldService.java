package com.flyingh.ws.server;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flyingh.ws.adapter.MapBooksAdapter;
import com.flyingh.ws.vo.Book;
import com.flyingh.ws.vo.User;

@WebService
public interface HelloWorldService {
	String say(String name);

	List<Book> getBooksByUser(User user);

	@XmlJavaTypeAdapter(MapBooksAdapter.class)
	Map<String, Book> getAllBooks();

}
