package booksdao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import booksdto.MemberDTO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	public MemberDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//insert
	public void insertMember(MemberDTO memberDTO) {
		sqlSessionTemplate.insert("insertMember", memberDTO);
	}
	
	//selectByEmail
	public MemberDTO selectByEmail(String email) {
		return sqlSessionTemplate.selectOne("selectByEmail", email);
	}
	
	
}
