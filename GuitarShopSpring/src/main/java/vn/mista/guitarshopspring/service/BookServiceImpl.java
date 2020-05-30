package vn.mista.guitarshopspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.mista.guitarshopspring.dao.BookDAO;
import vn.mista.guitarshopspring.model.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO bookDAO;
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}
	
	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}
	
	public void createBook(Book book) {
		bookDAO.createBook(book);
	}
}
