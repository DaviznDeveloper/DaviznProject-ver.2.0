package kr.or.davizn.dataService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostItService {

	@Autowired
	SqlSession sqlsession;
}
