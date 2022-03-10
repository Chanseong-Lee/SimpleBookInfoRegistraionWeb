package service;

import java.util.List;

import booksdao.BooksDAO;
import booksdto.BooksDTO;
import command.SearchCommand;

public class SearchBookService {
private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public List<BooksDTO> search(SearchCommand searchCommand) {
		List<BooksDTO> books = null;
		if(searchCommand.getSearchType().equals("bookname")) {
			books = booksDAO.selectByBookname(searchCommand.getSearchValue());
		}else if(searchCommand.getSearchType().equals("writer")) {
			books = booksDAO.selectByWriter(searchCommand.getSearchValue());
		}else if(searchCommand.getSearchType().equals("publisher")){
			books = booksDAO.selectByPublisher(searchCommand.getSearchValue());
		}
		
		return books;
	}
}
