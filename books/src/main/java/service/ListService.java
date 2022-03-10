package service;

import java.util.List;

import booksdao.BooksDAO;
import booksdto.BooksDTO;

public class ListService {
	private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public List<BooksDTO> showList() {
		return booksDAO.selectALL();
	}
	
}
