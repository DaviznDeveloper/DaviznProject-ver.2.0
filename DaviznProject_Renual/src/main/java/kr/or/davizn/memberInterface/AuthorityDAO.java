package kr.or.davizn.memberInterface;

import kr.or.davizn.memberDTO.DaviznMemberDTO;

public interface AuthorityDAO {
	
	//권한 부여
	public int grantAuth(String memberid);
}
