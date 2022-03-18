package email;

import java.util.Random;
//이메일 인증 난수화 코드
public class TempKey {
	private boolean checker;//소문자체커
	private int size;//길이
	
	public String getKey(int size, boolean checker) {
		this.size = size;
		this.checker = checker;
		return init();
	}
	
	private String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;
		do {
			num = ran.nextInt(75) + 48;//48~123(사용할건122까지 : 0 ~ z)
			if((num >= 48 && num <=57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)){
				//48~57 =0~9 || 65~90 = A~Z || 97~122 = a~z
				sb.append((char) num);
			}else {
				continue;
			}
		}while(sb.length() < size);
		//checker가 트루면 전부 소문자만
		if(checker) {
			return sb.toString().toLowerCase();
		}
		//true면 대소문자 섞임
		return sb.toString();
	}
	
	
}
