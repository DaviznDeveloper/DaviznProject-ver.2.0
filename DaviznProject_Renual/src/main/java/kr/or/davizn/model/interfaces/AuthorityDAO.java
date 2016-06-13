package kr.or.davizn.model.interfaces;

import kr.or.davizn.model.dto.DaviznMemberDTO;

public interface AuthorityDAO {
	
	//권한 부여
	public int grantAuth(String memberid);
}
