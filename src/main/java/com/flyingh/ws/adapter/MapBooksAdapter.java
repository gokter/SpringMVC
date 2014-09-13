package com.flyingh.ws.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.flyingh.ws.vo.Book;

public class MapBooksAdapter extends XmlAdapter<Books, Map<String, Book>> {

	@Override
	public Map<String, Book> unmarshal(Books books) throws Exception {
		final HashMap<String, Book> result = new HashMap<String, Book>();
		for (final Book book : books.getBooks()) {
			result.put(book.getName(), book);
		}
		return result;
	}

	@Override
	public Books marshal(Map<String, Book> map) throws Exception {
		return new Books(new ArrayList<Book>(map.values()));
	}

}
