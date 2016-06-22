package kr.or.davizn.groupService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.GroupShareDataDTO;
import kr.or.davizn.groupInterface.GroupShareDataDAO;

@Service
public class GroupShareDataService {
	
	@Autowired
	SqlSession sqlsession;
	
	public int addShareData(GroupShareDataDTO groupsharedto){
		GroupShareDataDAO shareDataDAO = sqlsession.getMapper(GroupShareDataDAO.class);
		int result = shareDataDAO.addShareData(groupsharedto);
		return result;
	}
}
