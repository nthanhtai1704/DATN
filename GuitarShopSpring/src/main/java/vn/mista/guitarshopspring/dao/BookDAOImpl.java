package vn.mista.guitarshopspring.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.mista.guitarshopspring.model.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO{

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
	 
	public List<Book> getBooks(){
        Criteria cr = getCurrentSession().createCriteria(Book.class);
        return cr.list();
    }

	public void createBook(Book book) {
		getCurrentSession().save(book);
	}
	
	public Book getBook(int id){
		Book book = (Book) getCurrentSession().get(Book.class,id);
        return book;
    }
	   
}
