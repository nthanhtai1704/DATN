package vn.mista.guitarshopspring.service;

import java.util.List;

import vn.mista.guitarshopspring.model.Book;

public interface BookService {

	public List<Book> getBooks();
	public Book getBook(int id);
	public void createBook(Book book);
}
