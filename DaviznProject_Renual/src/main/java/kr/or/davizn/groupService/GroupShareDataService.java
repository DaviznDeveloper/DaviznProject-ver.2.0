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
		System.out.println("-------- grousharedto 정보 ------------");
		System.out.println("datatype : " + groupsharedto.getDatatype());
		System.out.println("dataseq : " + groupsharedto.getDataseq());
		System.out.println("groupseq : " + groupsharedto.getGroupseq());
		System.out.println("userid : " + groupsharedto.getUserid());
		System.out.println("------------------------------------------");
		GroupShareDataDAO shareDataDAO = sqlsession.getMapper(GroupShareDataDAO.class);
		int result = shareDataDAO.addShareData(groupsharedto);
		return result;
	}
}
