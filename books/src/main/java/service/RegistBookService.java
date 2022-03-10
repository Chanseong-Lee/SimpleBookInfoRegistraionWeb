package service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import booksdao.BooksDAO;
import booksdto.BooksDTO;
import command.RegistCommand;
import exceptions.AlreadyExistingBookException;
import exceptions.NoImageException;

public class RegistBookService {
	private BooksDAO booksDAO;
	
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	public void register(RegistCommand rc) {
		String path = "C:\\aaa\\upload";
		BooksDTO hasBook = (BooksDTO) booksDAO.selectByIsbn(rc.getIsbn());
		//커맨드객체에 담긴 isbn이 db에 이미 있다면 예외처리(중복)
		if(hasBook != null) {
			throw new AlreadyExistingBookException();
		}
		try {
		MultipartFile imgFile = rc.getImgFile();
		String oriFilename = imgFile.getOriginalFilename();//업로드 당시 파일 이름
		//String fileExtension = 	oriFilename.substring(oriFilename.lastIndexOf("."));
		//System.out.println("확장자 : " + fileExtension);
		
		String savedFilename = UUID.randomUUID().toString().replaceAll("-", "")+oriFilename;
		//서버에 저장될 파일 이름은 중복을 피하기 위해 uuid클래스로 랜덤 생성해 처리
		File file = null;
		if(savedFilename != null) {
			if(savedFilename.endsWith("jpg")||savedFilename.endsWith("png")) {
				file = new File(path, savedFilename); //파일 객체 생성
				imgFile.transferTo(file);	//파일 저장
			}else {
				System.out.println("이미지가 아닙니다.");
				throw new NoImageException();
			}
		}
		
		BooksDTO newBook = new BooksDTO();
		newBook.setIsbn(rc.getIsbn());
		newBook.setBookname(rc.getBookname());
		newBook.setWriter(rc.getWriter());
		newBook.setSavedFilename(savedFilename);
		newBook.setRealFilename(oriFilename);
		newBook.setPrice(rc.getPrice());
		newBook.setContent(rc.getContent());
		newBook.setPublisher(rc.getPublisher());
		
		booksDAO.insert(newBook);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//이미지 파일인지 아닌지 아직 사용안함
	public boolean isImgFile(String fileExtension) {
		boolean checker = true;
		if(!fileExtension.equals("jpg") && !fileExtension.equals("png")) {
			checker = false;
		}
			return checker;
	}
}
