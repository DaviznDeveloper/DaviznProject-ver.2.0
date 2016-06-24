package kr.or.davizn.groupService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupDataService {
	
	@Autowired
	SqlSession sqlsession;
}
