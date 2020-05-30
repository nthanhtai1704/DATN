package vn.mista.guitarshopspring.dao;

import java.util.List;

import vn.mista.guitarshopspring.model.Book;

public interface BookDAO {

	public List<Book> getBooks();
	public void createBook(Book book);
	public Book getBook(int id);
}
