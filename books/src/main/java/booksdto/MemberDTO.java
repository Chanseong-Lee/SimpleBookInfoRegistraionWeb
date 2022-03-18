package booksdto;

import org.apache.ibatis.type.Alias;

@Alias("memberDTO")
public class MemberDTO {
	private Long mNum;
	private String email;
	private String name;
	private String password;
	private String validKey;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getmNum() {
		return mNum;
	}
	public void setmNum(Long mNum) {
		this.mNum = mNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getValidKey() {
		return validKey;
	}
	public void setValidKey(String validKey) {
		this.validKey = validKey;
	}
	
	
}
