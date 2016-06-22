package kr.or.davizn.groupService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.GroupInfoDTO;
import kr.or.davizn.groupInterface.GroupInfoDAO;

@Service
public class GroupInfoService {
	
	@Autowired
	SqlSession sqlsession;
	
	//랜덤 그룹 리스트 출력
	public List<GroupInfoDTO> randomGroupList(){
		GroupInfoDAO ginfodao =  sqlsession.getMapper(GroupInfoDAO.class);
		List<GroupInfoDTO> randomList = ginfodao.randomGroupList();
		System.out.println("리스트 : "+randomList);
		return randomList;
	}
	
	//검색한 그룹 리스트 출력
	public List<GroupInfoDTO> searchGroupList(String keyword){
		GroupInfoDAO ginfodao =  sqlsession.getMapper(GroupInfoDAO.class);
		List<GroupInfoDTO> searchList = ginfodao.searchGroupList(keyword);
		return searchList;
	}
}
