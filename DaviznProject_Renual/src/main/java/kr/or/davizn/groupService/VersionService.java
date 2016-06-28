package kr.or.davizn.groupService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.VersionDTO;
import kr.or.davizn.groupInterface.ManageVersionDAO;

@Service
public class VersionService {
	@Autowired
	SqlSession sqlsession;
	
	public int addVersion(VersionDTO versiondto){
		ManageVersionDAO versiondao = sqlsession.getMapper(ManageVersionDAO.class);
		int result = versiondao.addverison(versiondto);
		return result;
	}
}
