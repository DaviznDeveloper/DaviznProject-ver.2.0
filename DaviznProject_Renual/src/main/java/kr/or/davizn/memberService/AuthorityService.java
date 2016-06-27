package kr.or.davizn.memberService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.memberDTO.AuthorityDTO;
import kr.or.davizn.memberInterface.AuthorityDAO;

@Service
public class AuthorityService {
	
	@Autowired
	SqlSession sqlsession;
	
	//권한 부여
	public int grantAuth(String memberid){
		AuthorityDAO dao = sqlsession.getMapper(AuthorityDAO.class);
		int result = dao.grantAuth(memberid);
		return result;
	}
	
	public List<AuthorityDTO> getMemberAuths(String userid){
		AuthorityDAO dao = sqlsession.getMapper(AuthorityDAO.class);
		return dao.getMemberAuths(userid);
	}
}
