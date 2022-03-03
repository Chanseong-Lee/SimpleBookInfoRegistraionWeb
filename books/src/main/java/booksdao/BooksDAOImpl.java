package booksdao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import booksdto.BooksDTO;

public class BooksDAOImpl implements BooksDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	
	public BooksDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<BooksDTO> selectALL() {
		return sqlSessionTemplate.selectList("selectAll");
	}

	@Override
	public List<BooksDTO> selectByBookname(String bookname) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectByBookname", bookname);
	}

	@Override
	public List<BooksDTO> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectByWriter", writer);
	}

	@Override
	public List<BooksDTO> selectByPublisher(String publisher) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("selectByPublisher", publisher);
	}

	@Override
	public BooksDTO selectContent(int num) {
		return sqlSessionTemplate.selectOne("selectContent", num);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("count");
	}

	@Override
	public void update(BooksDTO booksDTO) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("update", booksDTO);
	}

	@Override
	public void insert(BooksDTO booksDTO) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insert", booksDTO);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("delete", num);
	}

}
