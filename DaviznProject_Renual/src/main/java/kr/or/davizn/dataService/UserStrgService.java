package kr.or.davizn.dataService;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.davizn.dataDTO.UserStrgDTO;
import kr.or.davizn.dataInterface.UserStrgDAO;

@Service
public class UserStrgService {
	@Autowired
	SqlSession sqlsession;
	
	//저장소 추가
	public int addStorage(String strgname, String userid){
		UserStrgDAO dao = sqlsession.getMapper(UserStrgDAO.class);
		int result = dao.addStorage(strgname, userid);
		return result;
	}
	
	//저장소 이름 수정
	public int modifyStorageName(UserStrgDTO userstrgdto){
		UserStrgDAO dao = sqlsession.getMapper(UserStrgDAO.class);
		int result = dao.modifyStorageName(userstrgdto);
		return result;
	}
	
	//저장소 리스트 출력
	public List<UserStrgDTO> showStorageList(String userid){
		UserStrgDAO dao = sqlsession.getMapper(UserStrgDAO.class);
		List<UserStrgDTO> result = dao.showStorageList(userid);
		System.out.println("아이디"+userid);
		System.out.println("저장소 리스트 : "+result.toString());
		return result;
	}
}
