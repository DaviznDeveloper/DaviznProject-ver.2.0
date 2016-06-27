package kr.or.davizn.datasetService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostItService {

	@Autowired
	SqlSession sqlsession;
}
