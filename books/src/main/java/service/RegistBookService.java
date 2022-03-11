package service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import booksdao.BooksDAO;
import booksdto.BooksDTO;
import command.RegistCommand;
import exceptions.AlreadyExistingBookException;
import exceptions.NoImageException;
import validate.FileTypeByTika;

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
		
		MultipartFile imgFile = rc.getImgFile(); //커맨드 객체에서 멀티파트파일 타입 객체 불러옴
		String oriFilename = imgFile.getOriginalFilename();//업로드 당시 파일 이름
		//String fileExtension = 	oriFilename.substring(oriFilename.lastIndexOf("."));
		//System.out.println("확장자 : " + fileExtension);
		
		String savedFilename = UUID.randomUUID().toString().replaceAll("-", "")+oriFilename;
		//서버에 저장될 파일 이름은 중복을 피하기 위해 uuid클래스로 랜덤 생성해 처리
		InputStream inputStream = null;
		File file = null;
		try{//자동 클로즈는 resource try catch 문
			//저장된 파일이 아닌 멀티파트파일 객체에 직접 스트림 꽂음
			inputStream = imgFile.getInputStream();
			System.out.println("Content Type : " + imgFile.getContentType());
			if(!imgFile.isEmpty()) {//비어있지 않다면
				boolean isValid = FileTypeByTika.validImgFile(inputStream);//티카 사용해서 이미지파일인지 아닌지 검증
				if(!isValid) {
					//이미지 타입 아닐때 에러 
					throw new NoImageException();
				}
				//업로드진행
				file = new File(path, savedFilename); //파일 객체 생성
				imgFile.transferTo(file);	//파일 저장
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
			inputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	/* 파일검증 하드코딩
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
	*/
}
