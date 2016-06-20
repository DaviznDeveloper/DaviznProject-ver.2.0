package kr.or.davizn.etcService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.memberDTO.DaviznMemberDTO;
import kr.or.davizn.memberInterface.DaviznMemberDAO;


@Service
public class JoinService {

	@Autowired
	SqlSession sqlsession;
	
	
	//회원가입
	public int insertMember(DaviznMemberDTO member){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int result = dao.insertMember(member);	
		return result;
	}
	
	//이메일 중복확인
	public String checkAccount(String account){
		DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
		int checkResult = dao.checkAccount(account);
		if(checkResult == 0) return "You can use this account";
		else return "You can't use this account. Alreay exist";
	}

	
	//아이디 중복확인
	public String checkUserid(String userid){
			DaviznMemberDAO dao = sqlsession.getMapper(DaviznMemberDAO.class);
			int checkResult = dao.checkUserid(userid);
			if(checkResult == 0) return "You can use this id";
			else return "You can't use this id. Alreay exist";
		}
}
