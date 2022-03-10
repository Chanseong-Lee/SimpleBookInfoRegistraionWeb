package booksdao;

import java.util.List;

import booksdto.BooksDTO;

public interface BooksDAO {
	public List<BooksDTO> selectALL();
	public List<BooksDTO> selectByBookname(String bookname);
	public List<BooksDTO> selectByWriter(String writer);
	public List<BooksDTO> selectByPublisher(String publisher);
	public Object selectContent(Long num);
	public Object selectByIsbn(Long isbn);
	public int count();
	public void update(BooksDTO booksDTO);
	public void insert(BooksDTO booksDTO);
	public void delete(Long num);
}
