package booksdao;

import booksdto.MemberDTO;

public interface MemberDAO {
	public void insertMember(MemberDTO memberDTO);
	public Object selectByEmail(String email);
}
