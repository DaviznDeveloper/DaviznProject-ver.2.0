package kr.or.davizn.memberInterface;

import java.util.List;

import kr.or.davizn.memberDTO.AuthorityDTO;

public interface AuthorityDAO {
	
	//권한 부여
	public int grantAuth(String memberid);
	public List<AuthorityDTO> getMemberAuths(String userid);
}
