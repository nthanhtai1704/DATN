package vn.mista.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.mista.bookmanagement.dao.BookDAO;
import vn.mista.bookmanagement.model.Book;


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
	
	public void deleteBook(int id) {
		Book book = bookDAO.getBook(id);
		if(book!=null) {
			bookDAO.deleteBook(book);
		}else {
			System.out.println("Khong co san pham voi id nay");
		}
	}
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
		
	}

	public List<Book> searchBook(String name) {
		return bookDAO.searchBook(name);
	}



}