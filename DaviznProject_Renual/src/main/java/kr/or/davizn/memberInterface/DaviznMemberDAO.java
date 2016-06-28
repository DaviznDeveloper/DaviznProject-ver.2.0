package kr.or.davizn.memberInterface;

import kr.or.davizn.memberDTO.DaviznMemberDTO;

public interface DaviznMemberDAO {

	//회원가입
	public int insertMember(DaviznMemberDTO member);
	
	//로그인 
	public String loginMember(DaviznMemberDTO member);
	
	//중복 account check
	public int checkAccount(String account);
	
	//중복 userid check
	public int checkUserid(String userid);
	
	//회원정보 수정(기존 정보 검색)
	public DaviznMemberDTO selectOneMember(String userid);
	
	//회원정보 수정(회원 정보 수정)
	public int updateMember(DaviznMemberDTO member);
	
}