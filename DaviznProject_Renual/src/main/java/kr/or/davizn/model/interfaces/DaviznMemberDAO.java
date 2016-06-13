package kr.or.davizn.model.interfaces;

import kr.or.davizn.model.dto.DaviznMemberDTO;

public interface DaviznMemberDAO {

	//회원가입
	public int insertMember(DaviznMemberDTO member);
	
	//로그인 
	public String loginMember(DaviznMemberDTO member);
	
	//중복 nickname check
	public int checkNickname(String nickname);
	
	//중복 이메일(memberid) check
	public int checkMemberid(String memberid);
	
	//회원정보 수정(기존 정보 검색)
	public DaviznMemberDTO selectOneMember(String userid);
	
	//회원정보 수정(회원 정보 수정)
	public int updateMember(DaviznMemberDTO member);
	
}