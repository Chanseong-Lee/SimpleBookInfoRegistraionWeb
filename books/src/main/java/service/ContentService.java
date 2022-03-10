package service;

import booksdao.BooksDAO;

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
