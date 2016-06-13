package kr.or.davizn.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.model.interfaces.AuthorityDAO;

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
	
}
