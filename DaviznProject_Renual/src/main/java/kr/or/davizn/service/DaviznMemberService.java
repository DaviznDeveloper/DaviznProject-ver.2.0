package kr.or.davizn.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.model.dto.DaviznMemberDTO;
import kr.or.davizn.model.interfaces.DaviznMemberDAO;

@Service
public class DaviznMemberService {
	
	@Autowired
	SqlSession sqlsession;
	
	//회원가입
	public int insertMember(DaviznMemberDTO member){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int result = dao.insertMember(member);	
		return result;
	}
	
	//닉네임 중복확인
	public String checkNickname(String nickname){
		System.out.println("checkNickname");
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int checkResult = dao.checkNickname(nickname);
		if(checkResult == 0) return "You can use this nickname";
		else return "You can't use this nickname. Alreay exist";
	}

	
	//이메일 중복확인
		public String checkMemberid(String memberid){
			DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
			int checkResult = dao.checkMemberid(memberid);
			if(checkResult == 0) return "You can use this memberid";
			else return "You can't use this memberid. Alreay exist";
		}
		
	//회원정보 수정(기존 정보 검색)
	public DaviznMemberDTO selectOneMember(String userid){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		DaviznMemberDTO member = dao.selectOneMember(userid);
		return member;
	}
	
	//회원정보 수정(회원정보 수정)
	public int updateMember(DaviznMemberDTO member){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int result = dao.updateMember(member);
		return result;
	}
}