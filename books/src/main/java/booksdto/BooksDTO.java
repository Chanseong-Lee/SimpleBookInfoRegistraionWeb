package booksdto;

import org.apache.ibatis.type.Alias;

@Alias("booksDTO")
public class BooksDTO {
	private Long num;
	private Long isbn;
	private String bookname;
	private String writer;
	private String publisher;
	private Long price;
	private String content;
	private String savedFilename;
	private String realFilename;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSavedFilename() {
		return savedFilename;
	}
	public void setSavedFilename(String savedFilename) {
		this.savedFilename = savedFilename;
	}
	public String getRealFilename() {
		return realFilename;
	}
	public void setRealFilename(String realFilename) {
		this.realFilename = realFilename;
	}
	
	
	
	
}
