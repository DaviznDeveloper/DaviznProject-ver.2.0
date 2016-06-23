package kr.or.davizn.groupService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.groupDTO.GroupShareDataDTO;
import kr.or.davizn.groupInterface.GroupShareDataDAO;

@Service
public class GroupShareDataService {
	
	@Autowired
	SqlSession sqlsession;
	
	//내 데이터 공유하기
	public int addShareData(GroupShareDataDTO groupsharedto){
		GroupShareDataDAO shareDataDAO = sqlsession.getMapper(GroupShareDataDAO.class);
		int result = shareDataDAO.addShareData(groupsharedto);
		return result;
	}
	
	//공유한 데이터 목록 출력
	public List<GroupShareDataDTO> showShareData(int groupseq){
		System.out.println("공유된 데이터들 목록 출력하는 서비스");
		GroupShareDataDAO shareDataDAO = sqlsession.getMapper(GroupShareDataDAO.class);
		List<GroupShareDataDTO> sharedatalist = shareDataDAO.showShareDataList(groupseq);
		System.out.println(sharedatalist.size());
		return sharedatalist;
	}
}
