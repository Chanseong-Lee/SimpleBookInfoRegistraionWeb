package service;

import org.springframework.stereotype.Service;

import booksdao.BooksDAO;

@Service
public class ContentService {
	private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public Object showContent(Long num) {
		Object book = booksDAO.selectContent(num);
		return book;
	}
}
